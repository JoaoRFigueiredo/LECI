import argparse
import os
import sys
sys.path.append(os.path.dirname(os.getcwd())+"/playing_area")
sys.path.append(os.path.dirname(os.getcwd())+"/player")
sys.path.append(os.path.dirname(os.getcwd())+"/extra")
sys.path.append(os.path.dirname(os.getcwd())+"/caller")
import json
import argparse
import socket
import utils as utils
import utils_sec as utils_sec
import messages_sec as messages_sec
from cryptography.hazmat.primitives.asymmetric import rsa
from cryptography.hazmat.primitives import serialization
import random
from user_sec import Client
import time


    

def main():
# Parse command line arguments
    parser = argparse.ArgumentParser(description='Secure Bingo Caller')
    
    parser.add_argument('--ip_address', help='IP address of playing area', default='127.0.0.1')
    parser.add_argument('--port', type=int, help='Port number of playing area', default=5003)
    parser.add_argument('--auth_method', choices=['PKI', 'CC'], help='Authentication method (PKI or CC)', default='PKI')
    
    args = parser.parse_args()

    # Connect to playing area
    s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    s.connect((args.ip_address, args.port))

      #generate caller's key pair
    c_private_key = rsa.generate_private_key(
            public_exponent=65537,
            key_size=3072
        )

    c_public_key = c_private_key.public_key()

    # Register with playing area
    nickname = random.choice(utils.NAMES)
   
    # Register caller
    message = {
        'header': 'register',
        'type': 'caller',
        'body': nickname,
        'key': c_public_key.public_bytes(
    encoding=serialization.Encoding.PEM,
    format=serialization.PublicFormat.SubjectPublicKeyInfo
    ).decode()
    }
    signature = utils_sec.sign_message(message, c_private_key, args.auth_method)
    message['signature'] = signature
    messages_sec.send_message(s, message)
    
    utils_sec.client_login(s, c_private_key)

  
    message.pop('type')
    player_cards = {}
    

    # Process player registration requests
    player_data = {}  # Dictionary of player data {player_id: {nickname: bla, key: public_key}}
    game_in_progress = False
    players = []  # List of player IDs
    

    print("Waiting for players to register...")
    print("A 10 seconds countdown will begin, once 2 players have joined the game!")




    # Wait for players to register
    start_time = None
    timeout = 10
    elapsed_time = 0
    while True :

        if start_time != None:
            elapsed_time = time.time() - start_time  # Calculate elapsed time

        if elapsed_time > timeout:  # If elapsed time is greater than timeout, break out of loop
            break
           
        data = messages_sec.receive_message(s)
        data = json.dumps(data)
        data = json.loads(data)
    
        if data == None:
            continue
        if data['header'] == 'player_register':
            if game_in_progress:
                # Reject registration request if game is already in progress
                
                message = {'header': 'error', 'body': 'Cannot register new players: game is already in progress'}
                messages_sec.send_message(s, message)
                continue
            
            player_id = data['player_id']
            players.append(player_id)
            nickname = data['nickname']
            public_key = data['public_key']
            player_data[player_id] = {'nickname': nickname, 'key': public_key}

            # Sign player data and send it back to player
            signed_data = utils_sec.sign_data(player_id, nickname, public_key, c_private_key, args.auth_method)
            
            message = {'header': 'signed_data', 'player_id': player_id, 'body': signed_data}
            messages_sec.send_message(s, message)
            print("Player ", player_id, "registered successfully")



            #verificar o card e a assinatura
        if data['header'] == 'card':
            id = data['player_id']
            signature = utils_sec.sign_message(data['body'], c_private_key, args.auth_method)
            #primeiro elemento --> cartao
            #segundo elemento --> assinatura do player
            #terceiro elemento --> assinatura do caller
            #quarto elemento --> chave publica do player
            player_cards[id] = (data['body'], data['signature'], signature, player_data[id]['key'])
            #player_cards["card_singature_"+str(id)] = data['signature']
            
            #verificar assinatura
            if not utils_sec.verify_signature(data['body'], data['signature'].encode('latin-1'), player_data[id]['key'], 'PKI'):
                print('Invalid signature')
                message['header'] = 'card_cheater'
                message['body'] = id
                del players[id-1]
                del player_cards[id]
                messages_sec.send_message(s, message)
                

                continue

            #verificar o card
            elif not utils.validate_card(player_cards[id][0]) : 
                print('Invalid card from player ', id)
                message['header'] = 'card_cheater'
                message['body'] = id
                del players[id-1]
                del player_cards[id]
                messages_sec.send_message(s, message)
                continue

            # signature = utils_sec.sign_message(data['body'], c_private_key, args.auth_method)
            # player_cards['card_caller_signature_'+str(id)] = signature
            print("Player ", id, "has a valid card!")
                
        


        if len(players) == 2 and len(player_cards) == 2 and start_time == None:
            print("Starting Countdown")
            start_time = time.time()
            
      
    #print(player_cards)
    print("-----------------------------------")
    print("\nCountdown is over. Staring game!")   
    #sen deck/start game
    symKey = utils_sec.generate_symmetric_key()
    first_deck = utils.generate_deck()
    first_deck = utils_sec.shuffle_deck(first_deck)
    first_deck_natural = first_deck
    first_deck = utils_sec.encrypt_deck(first_deck, symKey)
    signature = utils_sec.sign_deck(first_deck, c_private_key, args.auth_method)
    message = {0 : signature, 'header' : 'start', 'body' : first_deck, 'player_cards': player_cards}
    # message[0] = signature
    # message['header'] = 'start'
    # message['body'] = first_deck
    # message['player_cards'] = player_cards
    messages_sec.send_message(s, message)
    winners = []
    flag = False
    final_deck = []
    while True:
        data = messages_sec.receive_message(s)
        flag = False

        if data == None:
            continue

        elif data['header'] == 'final_deck':
            deck = data['body']
            if len(deck) != utils.N or len(set(deck)) != utils.N:
                flag = True
            signature = utils_sec.sign_deck(data['body'], c_private_key, args.auth_method)
            data[00] = signature
            data['header'] = 'final_deck_signed'
            data['sym 0'] = symKey
            #data['player_cards'] = player_cards
            data['flag'] = flag
            messages_sec.send_message(s, data)




        elif data['header'] == 'play_game':
            deck = [x.encode('latin-1') for x in data['body']]
            for i in range(len(players)-1, -1, -1):
                sk = data['sym '+str(i+1)]
                deck = utils_sec.decrypt_deck(deck, sk.encode('latin-1'))
            deck = utils_sec.decrypt_deck_final(deck, symKey)
            if not utils.validate_deck(deck):
                flag = True
            p_cards = {}
            for x in player_cards.keys():
                p_cards
                continue
            winners = utils.get_bingo_winners(deck, player_cards)
            final_deck = deck





        elif data['header'] == 'scores':
            caller_numbers = {}
            for x in players:
                numbers = utils_sec.bingo_numbers(player_cards[x][0], final_deck)
                caller_numbers[str(x)] = numbers

            players_numbers = data['body']
            cheaters = []
            for x in players:
                if players_numbers[str(x)] != caller_numbers[str(x)]:
                    print("Cheater detected with id: ", x)
                    print("Player scores:", players_numbers[str(x)])
                    print("Real scores:", caller_numbers[str(x)])
                    if x in winners:
                        winners.remove(x)

                    cheaters.append(x)
                    del player_cards[x]

                    winners = utils.get_bingo_winners(deck, player_cards)
            if len(cheaters) != 0:        
                message = {}
                message['header'] = 'cheater'
                message['body'] = cheaters
                data['flag'] = flag
                messages_sec.send_message(s, message)


            for x in cheaters:
                players.remove(x)
            print('The 1st phase winners are '+str(winners))
            message['header'] = 'request_winners'
            message['body'] = player_cards
            data['flag'] = flag
            messages_sec.send_message(s, message)





        elif data['header'] == 'verify_winners':




            player_computed = data['body']
            cheaters = []
            for x in player_computed.keys():

                #winners = [str(x) for x in winners]
                winners = [int(x) for x in winners]

                if player_computed[x] != winners:
                    print("Cheater detected with id: ", x)
                    print("Player winners: ", player_computed[x])
                    print("Real Winners: ", winners)
                    if x in winners:
                        winners.remove(x)


                    cheaters.append(x)
                    #messages_sec.send_message(s, message)
                winners = utils.get_bingo_winners(deck, player_cards)

            if len(cheaters) > 0:
                print("Cheaters: ", cheaters)
            for x in cheaters:
                players.remove(int(x))
                del player_cards[int(x)]
            message = {}
            message['header'] = 'cheater'
            message['body'] = cheaters
            if len(cheaters) > 0:
                data['flag'] = flag
                messages_sec.send_message(s, message)
            if len(players) > 0:
                winners = utils.get_bingo_winners(deck, player_cards)
            else:
                winners = "All players cheated"
            print("Winners: ")
            print(winners)
            print("Players at the end of the game: ")
            print(players)
            message['header'] = 'victory'
            message['body'] = winners
            message['players_left'] = [x for x in players if x not in winners]
            message['signature'] = utils_sec.sign_message(message['body'], c_private_key, args.auth_method)
            data['flag'] = flag
            messages_sec.send_message(s, message)
            


       
        


       
        

    
        

    
        
class Caller(Client):
    def __init__(self, nickname, socket, public_key="DUMMY PUBLIC KEY"):
        super().__init__(nickname, socket, public_key)
        self.id = 0
        self.deck = []

    def __str__(self):
        return f'Caller {self.id}: {self.nickname}'

if __name__ == '__main__':
    main()





