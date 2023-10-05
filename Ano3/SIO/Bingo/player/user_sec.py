import argparse
import itertools
import json
import socket
import os
import sys
sys.path.append(os.path.dirname(os.getcwd())+"/playing_area")
sys.path.append(os.path.dirname(os.getcwd())+"/player")
sys.path.append(os.path.dirname(os.getcwd())+"/extra")
sys.path.append(os.path.dirname(os.getcwd())+"/caller")

import random
from utils import NAMES
import messages_sec as messages_sec
import utils_sec as utils_sec
from cryptography.hazmat.primitives.asymmetric import rsa, padding
from cryptography.hazmat.primitives import serialization, hashes
from cryptography.exceptions import InvalidSignature
import utils as utils
from abc import ABC



from utils_sec import is_bingo, play_bingo,generate_card, sign_data


def main():
    # Parse command line arguments
    parser = argparse.ArgumentParser(description='Secure Bingo User')

    parser.add_argument('--auth-method', type=str, help='Authentication method', default='PKI')
    parser.add_argument('--server-ip', type=str, help='IP address of playing area', default='127.0.0.1')
    parser.add_argument('--server-port', type=int, help='Port of playing area', default=5003)
    parser.add_argument('--nickname', type=str,  help='Player nickname', default=random.choice(NAMES))
    args = parser.parse_args()

    player_cards = {}
    players_sym_keys = {}
    # Create socket
    s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    
    # Connect to playing area
    s.connect((args.server_ip, args.server_port))

    # Generate key pair for player
    private_key = rsa.generate_private_key(
        public_exponent=65537,
        key_size=3072
    )
    public_key = private_key.public_key()

    symmetricKey = utils_sec.generate_symmetric_key()
    
   

    # Register player
    message = {
        'header': 'register',
        'body': args.nickname,
        'type': 'player',
        'key': public_key.public_bytes(
    encoding=serialization.Encoding.PEM,
    format=serialization.PublicFormat.SubjectPublicKeyInfo
    ).decode()
    }
    signature = utils_sec.sign_message(message, private_key, args.auth_method)
    message['signature'] = signature
    #print(signature)
    messages_sec.send_message(s, message)
    utils_sec.client_login(s, private_key)

    # Receive and verify player registration

    data = messages_sec.receive_message(s)
    id = data['player_id']

    print('I am player', args.nickname, "with id: " + str(id))

    
  

    if data['header'] == 'error':
         # Print error message and exit
        print(data['body'])
        
    
    # Generate card
    card = utils.generate_card()
    print("My card:")
    print(card)
    


    # Commit card
    if args.auth_method == 'PKI':
    # Sign card and send it to playing area
        signature = private_key.sign(
    json.dumps(card).encode(),
    padding.PSS(
        mgf=padding.MGF1(hashes.SHA256()),
        salt_length=padding.PSS.MAX_LENGTH
    ),
    hashes.SHA256()
)
    
        message = {
            'header': 'card',
            'player_id': data['player_id'],
            'body': card,
            'signature': signature
        }
        
        messages_sec.send_message(s, message)
    elif args.auth_method == 'CC':
        # Use challenge-response to commit card
        # TODO: Implement challenge-response authentication
        message = {'header': 'card', 'player_id': data['player_id'], 'body': card}
        messages_sec.send_message(s, message)
    else:
        raise ValueError('Invalid authentication method')


    final_deck = []
    caller_pbk = None
    #new_message = None
    #who = None
    flag = False
    while True:
        data = messages_sec.receive_message(s)
        if data != None:
            print(data['header'])
        if data == None:
            continue
        
        
        
        elif data['header'] == 'start':
            #print(data.keys())
            player_cards = data['player_cards']
            #caller_pbk = data['caller_pbk'] # para guardar a chave publica do caller
            #print(player_cards)
            deck = [x.encode('latin-1') for x in data['body']]
            #print(deck)
            if (len(set(deck))) != utils.N:
                    print("Deck has been tampered!")
                    flag = True
            data['body'] = utils_sec.reencrypt_deck(deck, symmetricKey)
            data['body'] = utils_sec.shuffle_deck(data['body'])
            signature = utils_sec.sign_deck(data['body'], private_key, args.auth_method)
            if(random.random() < 0.05):
                print("I'm on santas' naughty list! (CHEATING) || ASSINATURA")
                signature = "assinatura falsa"
            data[id] = signature
            data['flag'] = flag
            messages_sec.send_message(s, data)

        
            

        elif data['header'] == 'final_deck_signed':
            data['sym '+str(id)] = symmetricKey
            signature = utils_sec.sign_message(data['body'], private_key, args.auth_method)
            data['signature'] = signature
            messages_sec.send_message(s, data)



        
        elif data['header'] == 'play_game':
            deck = [x.encode('latin-1') for x in data['body']]
            count = len([key for key in data if key.startswith('sym')])
            for i in range(count-1, -1, -1):
                if i == 0:
                    break
                sk = data['sym '+str(i)]
                deck = utils_sec.decrypt_deck(deck, sk.encode('latin-1'))
            deck = utils_sec.decrypt_deck_final(deck, data['sym 0'].encode('latin-1'))
            print(deck)
            final_deck = deck
            chance = random.randint(0, 9)
            numbers_to_win = utils_sec.bingo_numbers(card, deck)
            if chance  == 0:
                numbers = utils_sec.generate_random_number()
                while numbers == numbers_to_win:
                    numbers = utils_sec.generate_random_number()
                numbers_to_win = numbers
                print("I'm on santas' naughty list! (CHEATING)")
            message = {'header': 'score', 'body': numbers_to_win, 'id': id }
            signature = utils_sec.sign_message(data['body'], private_key, args.auth_method)
            data['signature'] = signature
            messages_sec.send_message(s, message)


        elif data['header'] == 'cheater':
            print(data['body'])

       



        elif data['header'] == 'request_winners':
            #player_cards = data['body']
            x = random.randint(0, 9) 
            winners = utils.get_bingo_winners(final_deck, player_cards)
            winners = [int(s) for s in winners]
            
            if id not in winners and x in [0, 1]:
                print("I'm on santas' naughty list! (CHEATING)")
                winners.append(id)
                winners = [int(s) for s in winners]
                winners.sort()
            winners = [int(s) for s in winners]
            print("Here are my computed winners ",winners)
            message['header'] = 'request_winners'
            message['body'] = winners
            signature = utils_sec.sign_message(message['body'], private_key, args.auth_method)
            message['signature'] = signature
            messages_sec.send_message(s, message)



            
        
        elif data['header'] == 'victory':
            print(data['body'])
  
                    


class Client(ABC):  # Abstract Base Class
    def __init__(self, nickname, socket, public_key="PBK"):
        self.id = -1
        self.socket = socket
        self.nickname = nickname
        self.public_key = public_key

    def __str__(self):
        return f'Client {self.id}: {self.nickname}'

    def __eq__(self, other):
        return self.id == other.id


class Player(Client):

    #id_iter = itertools.count(start=1)  # sequential id

    def __init__(self, nickname, socket, pbk="PBK"):
        super().__init__(nickname, socket, pbk)
        self.id = None
        self.card = []

    def __str__(self):
        return f'Player {self.id}: {self.nickname}'


if __name__ == '__main__':
    main()






