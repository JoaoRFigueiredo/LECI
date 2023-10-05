import argparse
import collections
import json

import select
import socket
import threading
import uuid
import os
import sys
sys.path.append(os.path.dirname(os.getcwd())+"/playing_area")
sys.path.append(os.path.dirname(os.getcwd())+"/player")
sys.path.append(os.path.dirname(os.getcwd())+"/extra")
sys.path.append(os.path.dirname(os.getcwd())+"/caller")
import messages
import utils

from cryptography.hazmat.primitives import serialization
from cryptography.hazmat.primitives.asymmetric import rsa, padding
from cryptography.hazmat.primitives import hashes
from cryptography.exceptions import InvalidSignature


def broadcast(message,connections):
    """
    Broadcasts a message to all players.
    """
    for conn in connections:
        utils.send_message(conn, message)

def broadcast_numbers(conn, deck,connections):
    """
    Broadcasts numbers from the deck to all players except the sender.
    """
    for number in deck:
        message = {'header': 'next', 'body': number}
        for conn_ in connections:
            if conn_ == conn:
                continue
            utils.send_message(conn_, message)

def player_thread(conn, player_id, player_cards, args):
    # Receive and verify player messages
    while True:
        data = utils.receive_message(conn)
        if data['header'] == 'error':
            # Print error message and exit
            print(data['body'])
            return
        elif data['header'] == 'card':
            # Process card
            if data['player_id'] != player_id:
                # Reject invalid player
                message = {'header': 'error', 'body': f'Invalid player {data["player_id"]}'}
                utils.send_message(conn, message)
                continue
            if args.auth_method == 'PKI':
                # Verify PKI signature
                try:
                    public_key = serialization.load_pem_public_key(
                        data['key'].encode(),
                        
                    )
                    public_key.verify(
                        data['signature'],
                        json.dumps(data['body']).encode(),
                        padding.PSS(
                            mgf=padding.MGF1(hashes.SHA256()),
                            salt_length=padding.PSS.MAX_LENGTH
                        ),
                        hashes.SHA256()
                    )
                    player_cards[player_id] = data['body']
                except InvalidSignature:
                    # Reject invalid signature
                    message = {'header': 'error', 'body': f'Invalid signature for player {player_id}'}
                    utils.send_message(conn, message)
                    continue
            elif args.auth_method == 'CC':
                # Verify challenge-response authentication
                # TODO: Implement challenge-response authentication
                player_cards[player_id] = data['body']
            else:
                raise ValueError('Invalid authentication method')
            # Send confirmation
            message = {'header': 'card_accepted', 'player_id': player_id}
            utils.send_message(conn, message)
        elif data['header'] == 'bingo':
            # Process bingo
            if data['player_id'] != player_id:
                # Reject invalid player
                message = {'header': 'error', 'body': f'Invalid player {data["player_id"]}'}
                utils.send_message(conn, message)
                continue
            # End game
            winners = [player_id]
            message = {'header': 'end', 'body': winners}
            utils.send_message(conn, message)
            broadcast(message)
            game_in_progress = False
            current_player = None

            
        else:
            # Unknown message, ignore
            continue

def main():
    # Create socket
    sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    sock.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1)
    sock.bind(('',5000))

    sock.listen(5)

    # Initialize variables
    connections = []
    players = []
    player_cards = {}
    game_in_progress = False
    current_player = None
    final_deck = []

    # Main loop
    while True:
        # Wait for connection
        conn, addr = sock.accept()
        connections.append(conn)

        # Wait for player name
        data = utils.receive_message(conn)
        if data['header'] == 'error':
            # Print error message and exit
            print(data['body'])
            return
        elif data['header'] == 'name':
            # Process player name
            player_id = data['body']
            players.append(player_id)
            player_cards[player_id] = None
            # Send confirmation
            message = {'header': 'name_accepted', 'player_id': player_id}
            utils.send_message(conn, message)
        else:
            # Unknown message, ignore
            continue

        # Start game
        if not game_in_progress:
            # Generate deck
            deck = utils.generate_deck()
            final_deck = deck
            # Send deck to players
            broadcast_numbers(conn, deck,connections)
            # Send start message to current player
            message = {'header': 'start', 'body': deck}
            utils.send_message(conn, message)
            game_in_progress = True
            current_player = 0
        # Start player thread
        thread = threading.Thread(target=player_thread, args=(conn, player_id, player_cards))
        thread.start()



if __name__ == '__main__':
    main()



    

    
