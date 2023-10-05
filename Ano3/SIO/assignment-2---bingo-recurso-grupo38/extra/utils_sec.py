import json
import pickle
import os
import sys
import hmac
import time
import secrets
sys.path.append(os.path.dirname(os.getcwd())+"/playing_area")
sys.path.append(os.path.dirname(os.getcwd())+"/player")
sys.path.append(os.path.dirname(os.getcwd())+"/extra")
sys.path.append(os.path.dirname(os.getcwd())+"/caller")
import extra.messages_sec
from Crypto.Cipher import AES
from cryptography.hazmat.primitives.asymmetric import rsa, padding
from cryptography.hazmat.primitives import serialization, hashes
from cryptography.exceptions import InvalidSignature
from cryptography.hazmat.primitives.serialization import load_pem_public_key
from cryptography.hazmat.backends import default_backend
from cryptography.hazmat.primitives.ciphers import Cipher, algorithms, modes
import random



N = 75
M = 25

def client_login(server_sock, client_pvk):

    # Receive the challenge from the server
    desafio_encrypted = messages_sec.receive_message(server_sock)
    messages_sec.send_message(server_sock, '')
    server_pbk = messages_sec.receive_message(server_sock)
    server_pbk = server_pbk['server_pbk']
    server_pbk = load_pem_public_key(server_pbk.encode(), backend=default_backend())
    desafio = json.loads(client_pvk.decrypt(desafio_encrypted.encode('latin-1'), padding.OAEP(mgf=padding.MGF1(algorithm=hashes.SHA256()), algorithm=hashes.SHA256(), label=None)))


    # Extract the necessary information from the challenge
    client_challenge = desafio['client_challenge']
    timestamp = desafio['timestamp']
    nonce = desafio['nonce']
    secret = desafio['secret']


    # Calculate the response
    client_response = hmac.new(secret.encode(), (nonce+client_challenge).encode(), digestmod='sha256').hexdigest()
    #print(client_response)
    signature = sign_message(client_response, client_pvk, 'PKI')
    #print(sys.getsizeof(signature))
    response = {'client_response' : client_response}
    sign = {'response_signature' : signature.decode('latin-1')}
    #print(response)
    #print(signature)
    #print(sys.getsizeof(response))
    #encrypt answer and send it back to the server
    #signature_bytes = bytes(json.dumps(sign), 'UTF-8')
    #print(sys.getsizeof(signature))
    #signature_encrypted = server_pbk.encrypt(signature_bytes,padding.OAEP(mgf=padding.MGF1(algorithm=hashes.SHA256()), algorithm=hashes.SHA256(), label=None))
    response_bytes = bytes(json.dumps(response), 'UTF-8')
    answer_encrypted = server_pbk.encrypt(response_bytes, padding.OAEP(mgf=padding.MGF1(algorithm=hashes.SHA256()), algorithm=hashes.SHA256(), label=None))
    messages_sec.send_message(server_sock, answer_encrypted)
    messages_sec.send_message(server_sock, sign)

# A function to generate a new shared secret for a client
def generate_secret():
    secret = os.urandom(32).hex() # 32 bytes of random data
    return secret

def generate_challenge():
    challenge = os.urandom(32).hex()
    #adicionar o timestamp
    #challenge += str(time.time())
    return challenge

def challenge(client_sock, client_pbk, server_pbk, server_private_key):
    tempoaceitavel = 5
    nonce = generate_nonce()
    secret = generate_secret()
    client_challenge = generate_challenge()
    desafio = {"client_challenge" : client_challenge, "timestamp" : time.time(), "nonce" : nonce, "secret" : secret}
    server_key = {'server_pbk' : server_pbk.public_bytes(
    encoding=serialization.Encoding.PEM,
    format=serialization.PublicFormat.SubjectPublicKeyInfo
    ).decode()}
    pbk = load_pem_public_key(client_pbk.encode(), backend=default_backend())
    

    #encriptar o desafio com a chave publica do cliente
    desafio_json = json.dumps(desafio)
    desafio_bytes = bytes(desafio_json, 'utf-8')
    desafio_encrypted = pbk.encrypt(desafio_bytes, padding.OAEP(mgf=padding.MGF1(algorithm=hashes.SHA256()), algorithm=hashes.SHA256(), label=None))

    #enviar ao cliente
    messages_sec.send_message(client_sock, desafio_encrypted)
    messages_sec.receive_message(client_sock)
    messages_sec.send_message(client_sock, server_key)
    answer = messages_sec.receive_message(client_sock)
    response_signature = messages_sec.receive_message(client_sock)
    #print(response_signature['response_signature'].encode('latin-1'))
    answer = json.loads(server_private_key.decrypt(answer.encode('latin-1'), padding.OAEP(mgf=padding.MGF1(algorithm=hashes.SHA256()), algorithm=hashes.SHA256(), label=None)))

    # Calculate the expected response
    expected_response = hmac.new(secret.encode(), (nonce+client_challenge).encode(), digestmod='sha256').hexdigest()
    ass = response_signature['response_signature'].encode('latin-1')
    #print(sys.getsizeof(ass))
    #print(answer['client_response'])
    #print(verify_signature(answer['client_response'],ass,client_pbk,'PKI'))
    if answer['client_response'] == expected_response and time.time()-desafio['timestamp'] < tempoaceitavel and verify_signature(answer['client_response'],ass,client_pbk,'PKI'):
        # The client's response is valid
        print('tá dentro!')
        return True
    else:
        # The client's response is invalid
        return False



def sign_data(sequence_number, nickname, public_key, private_key, auth_method):
    """
    Signs the provided data using the specified authentication method.
    """
    data = {
        'seq': sequence_number,
        'nick': nickname,
        'key': public_key
    }
    if auth_method == 'PKI':
        # Use PKI to sign data
        
        signature = private_key.sign(
            json.dumps(data).encode(),
            padding.PSS(
                mgf=padding.MGF1(hashes.SHA256()),
                salt_length=padding.PSS.MAX_LENGTH
            ),
            hashes.SHA256()
        )
        data['signature'] = signature

        return data
  
def sign_message(data, private_key, auth_method):
    """
    Signs the provided data using the specified authentication method.
    """
    #print(data)
    if auth_method == 'PKI':
        # Use PKI to sign data
        
        signature = private_key.sign(
            json.dumps(data).encode(),
            padding.PSS(
                mgf=padding.MGF1(hashes.SHA256()),
                salt_length=padding.PSS.MAX_LENGTH
            ),
            hashes.SHA256()
        )
        #data['signature'] = signature

        return signature

def sign_deck(deck, private_key, auth_method):
    """
    Signs the provided data using the specified authentication method.
    """

    try:
        deck_bytes = b''.join(deck)
    except:
        deck_bytes = b''.join([bytes(s, 'utf-8') for s in deck])
    
   
    if auth_method == 'PKI':
        # Use PKI to sign data
        
        signature = private_key.sign(
            deck_bytes,
                        padding.PSS(
                mgf=padding.MGF1(hashes.SHA256()),
                salt_length=padding.PSS.MAX_LENGTH
            ),
            hashes.SHA256()
        )
        #data['signature'] = signature

        return signature

def verify_deck_signature(deck, signature, public_key, auth_method):
    try:
        deck_bytes = b''.join(deck)
    except:
        deck_bytes = b''.join([bytes(s, 'utf-8') for s in deck])

    public_key = load_pem_public_key(public_key.encode(), backend=default_backend())

    if auth_method == 'PKI':
        try:
            public_key.verify(
                signature,
                deck_bytes,
                padding.PSS(
                    mgf=padding.MGF1(hashes.SHA256()),
                    salt_length=padding.PSS.MAX_LENGTH
                ),
                hashes.SHA256()
            )
            return True
        except Exception:
            return False
    else:
        raise ValueError('Invalid authentication method')

def verify_signature(data, signature, public_key,  auth_method):
    """
    Verifies the provided signature using the specified authentication method.
    """
    public_key = load_pem_public_key(public_key.encode(), backend=default_backend())
    #print(json.dumps(data).encode())
    #print(type(data))
    #print(json.dumps(data))
    #print(type(signature))
    if auth_method == 'PKI':
        # Use PKI to verify signaturd
        try:
            public_key.verify(
                signature,
                json.dumps(data).encode(),
                padding.PSS(
                    mgf=padding.MGF1(hashes.SHA256()),
                    salt_length=padding.PSS.MAX_LENGTH
                ),
                hashes.SHA256()
            )
            return True
        except Exception:
            #print("exception ocurred!")
            return False
    elif auth_method == 'CC':
        # Use challenge-response to verify signature
        # TODO: Implement challenge-response authentication
        raise NotImplementedError('Challenge-response authentication not implemented')
    else:
        raise ValueError('Invalid authentication method')


def verify_signature_bytes(data, signature, public_key,  auth_method):
    """
    Verifies the provided signature using the specified authentication method.
    """
    public_key = load_pem_public_key(public_key.encode(), backend=default_backend())
    #print(json.dumps(data).encode())
    #print(data)
    print(signature)
    if auth_method == 'PKI':
        # Use PKI to verify signaturd
        try:
            public_key.verify(
                signature,
                data,
                padding.PSS(
                    mgf=padding.MGF1(hashes.SHA256()),
                    salt_length=padding.PSS.MAX_LENGTH
                ),
                hashes.SHA256()
            )
            return True
        except Exception:
            return False
    elif auth_method == 'CC':
        # Use challenge-response to verify signature
        # TODO: Implement challenge-response authentication
        raise NotImplementedError('Challenge-response authentication not implemented')
    else:
        raise ValueError('Invalid authentication method')

def generate_deck():
    """
    Generates a deck of bingo numbers.
    """
    return random.sample(range(1, N+1), N) 

def shuffle_deck1(deck):

    """
    Shuffles the provided deck of bingo numbers.
    """
    random.shuffle(deck)
    return deck


def shuffle_deck(deck):
    
    n = len(deck)
    for i in range(n - 1, 0, -1):
        j = random.randint(0, i)
        deck[i], deck[j] = deck[j], deck[i]
    return deck

def unshuffle(shuffled_deck):
    # Create a new list with the same number of cards as the shuffled deck
    unshuffled_deck = [N] * len(shuffled_deck)
    
    # Iterate over the shuffled deck and add each card to the unshuffled deck
    # in the same position as it was in the original deck
    for i, card in enumerate(shuffled_deck):
        unshuffled_deck[i] = card
    
    return unshuffled_deck


def get_bingo_winners(players, player_cards):
    """
    Gets the bingo winners from the provided player cards.
    """
    winners = []
    min_numbers = float('inf')
    for player in players:
        player_card = player_cards[player]
        if len(player_card) < min_numbers:
            winners = [player]
            min_numbers = len(player_card)
        elif len(player_card) == min_numbers:
            winners.append(player)
    return winners

def play_bingo(player_cards):
    """
    Plays bingo with the provided player cards and returns the final state of the cards.
    """
    final_cards = {}
    for player,card in player_cards.items():
        final_cards[player] = card

        for number in card:
            if number not in final_cards[player]:
                final_cards[player].append(number)
    return final_cards

def complain_or_ban_cheating(players,winners):
    """
    Complains or bans cheating players.
    """
    for player in players:
        if player not in winners:
            if is_cheating(player):
                ban_player(player)
            else:
                complain_player(player)


def validate_card(card,public_key,signature,auth_method):
    """
    Validates the provided card using the provided authentication method.
    """
    if auth_method == 'PKI':
        # Use PKI to validate card
        try:
            public_key.verify(
                signature,
                json.dumps(card).encode(),
                padding.PSS(
                    mgf=padding.MGF1(hashes.SHA256()),
                    salt_length=padding.PSS.MAX_LENGTH
                ),
                hashes.SHA256()
            )
        except InvalidSignature:
            return False
        return True
    elif auth_method == 'CC':
        # Use challenge-response to validate card
        return True
    else:
        raise ValueError('Invalid authentication method')

def commit_card(conn, auth_method, card, private_key):
    """
    Commits a card to the playing area using the specified authentication method.
    """
    if auth_method == 'PKI':
        # Sign card and send it to playing area
        signature = private_key.sign(
            json.dumps(card).encode(),
            padding.PSS(
                mgf=padding.MGF1(hashes.SHA256()),
                salt_length=padding.PSS.MAX_LENGTH
            ),
            hashes.SHA256()
        )
        message = {'header': 'card', 'body': card, 'signature': signature}
        send_message(conn, message)
    elif auth_method == 'CC':
        # Use challenge-response to commit card
        # TODO: Implement challenge-response authentication
        message = {'header': 'card', 'body': card}
        send_message(conn, message)
    else:
        raise ValueError('Invalid authentication method')

def is_valid_card(player_card):
    # if any (1 > number > N for number in player_card)
    #    return False
    for number in player_card:
        if number > N or number < 1:
            return False

    if len(set(player_card)) != len(player_card):
        return False

    if len(player_card) != M:
        return False
    
    return True

def is_bingo(card,deck):
    """
    Checks if the provided card is bingo.
    """
    return len(card) == 0

def complain_player(player_id):
    """
    Complains about the provided player.
    """
    print('Complaining about player', player_id)

def ban_player(player_id):
    """
    Bans the provided player.
    """
    print('Banning player', player_id)

def is_cheating(player_id):
    """
    Checks if the provided player is cheating.
    """
    return random.randint(0, 9) == 0


def generate_card():
    # meter aqui a probabilidade de 10% do enunciado de fazer traquinices acho eu
    return random.sample(range(1, N+1), M)

def verify_data(player_id, signed_data, pbk,  auth_method):
    """Verify signed data from a player.
    
    Parameters:
        player_id (int): The ID of the player.
        signed_data (bytes): The signed data.
        auth_method (str): The authentication method used. Must be 'PKI' or 'CC'.
        
    Returns:
        tuple: The extracted data (sequence_number, nickname, public_key, auth_method) if the signature is valid,
               or None if the signature is invalid.
    """
    if auth_method == 'PKI':
        # Load player's public key from file
        

        data = signed_data['data']
        signature = signed_data['signature']
       
        # Verify signature
        try:
            pbk.verify(
                pickle.dumps(data),
                signature.encode(),
                padding.PSS(
                    mgf=padding.MGF1(hashes.SHA256()),
                    salt_length=padding.PSS.MAX_LENGTH
                ),
                hashes.SHA256()

            )

        except Exception as e:
            raise ValueError ('Invalid signature')

        data = data.decode().split(',')
        if len(data) != 3:
            raise ValueError('Invalid data')

        sequence_number, nickname, auth_method = data
        try:
            sequence_number = int(sequence_number)
            if auth_method not in ['PKI', 'CC']:
                raise ValueError('Invalid authentication method')
        except ValueError:
            raise ValueError('Invalid data')
        return sequence_number, nickname, pbk, auth_method
    elif auth_method == 'CC':
        # Use challenge-response to verify data
        pass
    else:
        raise ValueError('Invalid authentication method')




def generate_symmetric_key():
    # Generate a 32-byte symmetric key
    return os.urandom(32)

def encrypt_deck(deck, symmkey):
    ## this functions encrypts the initial deck
    encrypted_deck = []
    for x in deck:
        iv = secrets.token_bytes(16)
        x = int.to_bytes(x, 16, 'little')
        x = iv + x
        

        cipher = Cipher(algorithms.AES(symmkey), modes.CBC(iv))
        encryptor = cipher.encryptor()

        x = encryptor.update(x) + encryptor.finalize()
        encrypted_deck.append(x)
        #print(iv)
    return encrypted_deck


def reencrypt_deck(deck, symmkey):
    encrypted_deck = []
    for x in deck:

        iv = secrets.token_bytes(16)
        x = iv + x
        
        cipher = Cipher(algorithms.AES(symmkey), modes.CBC(iv))
        encryptor = cipher.encryptor()

        x = encryptor.update(x) + encryptor.finalize()

        encrypted_deck.append(x)
    return encrypted_deck


def decrypt_deck(deck, symmKey):
    decrypted_deck = []

    for x in deck:
        iv = x[:16]
        dec = x[16:]

        cipher = Cipher(algorithms.AES(symmKey), modes.CBC(iv))
        decryptor = cipher.decryptor()

        dec = decryptor.update(dec) + decryptor.finalize()
        decrypted_deck.append(dec)
        #print(iv)
    return decrypted_deck

def decrypt_deck_final(deck, symmKey):
    decrypted_deck = []

    for x in deck:
        iv = x[:16]
        dec = x[16:]

        cipher = Cipher(algorithms.AES(symmKey), modes.CBC(iv))
        decryptor = cipher.decryptor()

        dec = decryptor.update(dec) + decryptor.finalize()
        dec = int.from_bytes(dec, 'little')
        decrypted_deck.append(dec)
    return decrypted_deck

def generate_nonce():
    return os.urandom(32).hex()

def generate_random_number():
    x = random.randint(1, N)
    return x

def bingo_numbers(card, final_deck):
    # Create a set of the numbers on the player's card
    card_set = set(card)

    # Initialize a counter for the number of numbers called
    count = 0

    # Iterate over the called numbers
    for number in final_deck:
        # Increment the counter
        count += 1

        # If the number is on the player's card, remove it from the set
        if number in card_set:
            card_set.remove(number)

        # If the set is empty, the player has won
        if not card_set:
            return count

    # If the loop finishes without returning, the player did not win
    return -1
