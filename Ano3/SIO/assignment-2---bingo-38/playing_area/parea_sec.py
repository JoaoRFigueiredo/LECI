import json
import socket
import logging
import hashlib
import os
import sys
import hmac
import time
sys.path.append(os.path.dirname(os.getcwd())+"/playing_area")
sys.path.append(os.path.dirname(os.getcwd())+"/player")
sys.path.append(os.path.dirname(os.getcwd())+"/extra")
sys.path.append(os.path.dirname(os.getcwd())+"/caller")
from cryptography.hazmat.primitives.asymmetric import rsa, padding
from cryptography.hazmat.primitives import serialization, hashes
from cryptography.exceptions import InvalidSignature
import utils, utils_sec as utils_sec
import messages_sec as messages_sec, messages
import selectors
from caller_sec import Caller
from user_sec import Player

import MyLogger


# Load the public key from a file
with open("public_key.pem", "rb") as key_file:
    public_key_data = key_file.read()

# Deserialize the public key
public_key = serialization.load_pem_public_key(public_key_data)

clients = {}
secrets = {}

def main():
    # Create socket
    sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    sock.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1)
    sock.bind(('',5003))
    sock.listen(5)

    selector = selectors.DefaultSelector()

    pa_private_key = rsa.generate_private_key(
            public_exponent=65537,
            key_size=3072
        )

    pa_public_key = pa_private_key.public_key()


    game_ongoing = False
    ran_once = False

    sock.setblocking(False)
    selector.register(sock, selectors.EVENT_READ, data=None)
    print('Starting Playing Area\n')
    last_kicked_id = 1
    while True:
        events = selector.select(timeout=None)
        for key, mask in events:
            # Check for a new client connection

            if key.fileobj == sock:
                clt_socket, clt_addr = sock.accept()
                clt_socket.setblocking(True)

                # Add it to the sockets under scrutiny
                if clt_socket._closed:
                    selector.unregister(clt_socket)
                selector.register(clt_socket, selectors.EVENT_READ, data=None)

            else:
                data = messages_sec.receive_message(key.fileobj)
                MyLogger.logger.info(f"Received: {data}", data)
                #print(data)


                if data is None:  # Socket closed
                    # remove client from clients dictionary
                    for id in list(clients):  # has to be list(dict) to avoid RuntimeError
                        if clients[id].socket == key.fileobj:
                            print(f'Client {clients[id]} disconnected')
                            del clients[id]
                    unregister_and_close_client(selector, key.fileobj)
                    continue

                #data = json.loads(data.decode())
                if (type(data) == str):
                    data = json.loads(data)

                #print(f"Received: {data}")
                
                # register new clients
                if data['header'] == 'register':
                    if game_ongoing:
                        print("Client connection error: Game already started\nClient removed")
                        unregister_and_close_client(selector, key.fileobj)
                        continue

                    
                    authenticated = utils_sec.challenge(key.fileobj, data['key'], pa_public_key, pa_private_key)
                    if not authenticated:
                        print("Client/Caller failed challenge-response.\nEntity removed!")
                        unregister_and_close_client(selector, key.fileobj)
                        continue

                    print("Client passed challenge-response!")

                    nickname = data['body']
                    if data['type'] == 'caller':

                       

                        if 0 not in clients:
                            clients[0] = Caller(nickname, key.fileobj)
                            print(f"{clients[0]} registered\n")
                            continue

                        else:
                            print("Caller connection error: Caller already connected\nClient removed")
                            unregister_and_close_client(selector, key.fileobj)
                            continue

                    if data['type'] == 'player':
                        player = Player(nickname, key.fileobj)
                        player.id = last_kicked_id
                        clients[player.id] = player
                        clients[player.id].pbk = data['key']
                        print(f"{player} registered\n")
                        #send data to caller
                        message = {'header': 'player_register', 'player_id': player.id, 'nickname': player.nickname, 'public_key': player.pbk}
                        messages_sec.send_message(clients[0].socket, message)
                        MyLogger.logger.info(f"Received: {message}", message)
                        last_kicked_id += 1



                elif data['header'] == 'signed_data':
                    player_id = data['player_id']
                    if player_id not in clients:
                        print(f"Client {player_id} not registered")
                        continue
                    clients[player_id].signed_data = data['body']
                    print(f"Received signed data from {clients[player_id]}")
                    messages_sec.send_message(clients[player_id].socket, data)
                    MyLogger.logger.info(f"Received: {data}", data)



                elif data['header'] == 'card':
                    #print(data['signature'].encode('latin-1'))
                    id = data['player_id']
                    if not utils_sec.verify_signature(data['body'], data['signature'].encode('latin-1'), clients[id].pbk, 'PKI'):
                        print('Invalid signature')
                        return
                    messages_sec.send_message(clients[0].socket, data)
                    MyLogger.logger.info(f"Received: {data}",data)



                elif data['header'] == 'start':
                    #print(data)
                    message = data
                    #message['header'] = 'start'
                    #message['body'] = data['body']
                    ids = list(clients.keys())
                    for x in ids:
                        if(x != 0):
                            messages_sec.send_message(clients[x].socket, message)
                            MyLogger.logger.info(f"Received: {message}",message)
                            #receive client's shuflfed deck
                            message = messages_sec.receive_message(clients[x].socket)
                            MyLogger.logger.info(f"Received: {message}",message)
                            #print(message['body'])
                    message['header'] = 'final_deck'
                    messages_sec.send_message(clients[0].socket, message)
                    MyLogger.logger.info(f"Received: {message}", message)



                elif data['header'] == 'final_deck_signed':
                    ids = list(clients.keys())
                    for x in ids:
                        if (x != 0):
                            messages_sec.send_message(clients[x].socket, data)
                            MyLogger.logger.info(f"Received: {data}",data)
                            data = messages_sec.receive_message(clients[x].socket)
                            MyLogger.logger.info(f"Received: {data}",data)
                    data['header'] = 'play_game'
                    moves = {}
                    for x in ids:
                        messages_sec.send_message(clients[x].socket, data)
                        MyLogger.logger.info(f"Received: {data}",data)
                        if x != 0:
                            message = messages_sec.receive_message(clients[x].socket)
                            MyLogger.logger.info(f"Received: {message}", message)
                            #print(message)
                            moves[message['id']] = message['body']
                    
                    if (len(moves.keys()) == len(clients)-1):
                        message['header'] = 'scores'
                        message['body'] = moves
                        del(message['id'])
                        messages_sec.send_message(clients[0].socket, message)
                        MyLogger.logger.info(f"Received: {message}",message)



                elif data['header'] == 'request_winners':
                    winners = {}
                    ids = clients.keys()
                    #print(ids)
                    for x in ids:
                       # print(x)
                        if x != 0:
                            #print(x)
                            messages_sec.send_message(clients[x].socket, data)
                            MyLogger.logger.info(f"Received: {data}",data)
                            message = messages_sec.receive_message(clients[x].socket)
                            MyLogger.logger.info(f"Received: {message}",message)
                            #print('this message was received:', message)
                            #print(message)
                            winners[str(x)] = message['body'] 
                    message = {}
                    message['header'] = 'verify_winners'
                    message['body'] = winners
                    messages_sec.send_message(clients[0].socket, message)
                    MyLogger.logger.info(f"Received: {message}",message)


                elif data['header'] == 'verify_winner':
                    pass
                
                
                elif data['header'] == 'card_cheater':
                    cheater_id = data['body']
                    clients[int(cheater_id)].socket.close()
                    selector.unregister(clients[int(cheater_id)].socket)
                    del (clients[int(cheater_id)])
                    last_kicked_id = cheater_id



                elif data['header'] == 'cheater': 
                    print(data)
                    kicked_id = data['body']
                    print('These users will be kicked ',kicked_id)
                    for client in kicked_id:
                        clients[int(client)].socket.close()
                        del (clients[int(client)])
                    ids = clients.keys()
                    
                    
                    data['body'] = 'Players '+ str(kicked_id) +' has been caught cheating, and therefore, has been kicked!'
                    for x in ids:
                        #print(x)
                        if x not in kicked_id and x != 0:
                           # print(x)
                            messages_sec.send_message(clients[x].socket, data)
                            MyLogger.logger.info(f"Received: {data}",data)




                elif data['header'] == 'victory':
                    winners = data['body']
                    players_left = data['players_left']
                    
                    if len(winners)== 0:
                        break
                    victory_message = "These players "+str(winners)+" have won!"
                    if len(players_left )> 0:
                        victory_message = victory_message +"\nPlayers "+str(players_left)+", despite losing, have reached the end of the game with a clean game!"
                    message['header'] = 'victory'
                    message['body'] = victory_message
                    ids = clients.keys()
                    for x in ids:
                        messages_sec.send_message(clients[x].socket, message)
                        MyLogger.logger.info(f"Received: {message}",message)

                    
                    
                            
                    
                    


            
if __name__ == '__main__':
    main()   



###### functions other than main go here, so that everything's more organzied

def get_id_by_socket(key):
    for id in clients:
        if clients[id].socket == key.fileobj:
            return id

def unregister_and_close_client(selector, key):
    selector.unregister(key)
    key.close()






