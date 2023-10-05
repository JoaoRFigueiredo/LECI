import argparse
import sys
import itertools
import json
import socket
import os
from extra.utils import NAMES
import random
import extra.messages_sec as messages_sec
from extra.utils import M as M
import extra.utils_sec as utils_sec
import base64
from cryptography.hazmat.primitives.asymmetric import rsa, padding
from cryptography.hazmat.primitives import serialization, hashes
from cryptography.exceptions import InvalidSignature
import extra.utils_sec
import extra.utils as utils
from abc import ABC
from cryptography.hazmat.primitives.serialization import load_pem_public_key
from cryptography.hazmat.primitives.serialization import (
    PublicFormat,
    Encoding,
)

def main():




    print('original deck')
    deck = utils.generate_deck()
    # print(len(deck))
    # print(deck)
    # print(utils.validate_deck(deck))
    # print(max(deck))

    key1 = utils_sec.generate_symmetric_key()
    key2 = utils_sec.generate_symmetric_key()
    print(deck)

    encrypted_deck = utils_sec.encrypt_deck(deck, key1)
    #print(encrypted_deck)
    enc2 = utils_sec.reencrypt_deck(encrypted_deck, key2)
    print('-------------------')
    #print(enc2)
    print('------------------')
    dec_deck = utils_sec.decrypt_deck(enc2, key2)
    #print(dec_deck == encrypted_deck)#true
    print('------------------')
    dec_final = utils_sec.decrypt_deck_final(dec_deck, key1)
    print(dec_final ) # false
    print(dec_final == deck)
    #card = utils.generate_card()
    #print(card)
    #print(utils.validate_card(card))
    #deck.append(150)
    #print(deck)
    # print('-----------Shuffling process---------')
    # for i in range(1, 3):
    #     deck = utils_sec.shuffle_deck(deck)
    #     print(deck)
    # for i in range(1, 3):
    #     deck = utils_sec.unshuffle(deck)
    #     print(deck)
    # valid_numbers = set(range(1, 101))
    # print( valid_numbers)
    # print(set(deck).issubset(valid_numbers))


#     private_key = rsa.generate_private_key(
#         public_exponent=65537,
#         key_size=2048
#     )
#     public_key = private_key.public_key()
#     pbk = public_key.public_bytes(
#     encoding=serialization.Encoding.PEM,
#     format=serialization.PublicFormat.SubjectPublicKeyInfo
#     ).decode()

#     #print(public_key == pbk)

#     pb1 = load_pem_public_key(pbk.encode(), backend=None)
#     print(pb1)
#     print(public_key)
#     print(pb1 == public_key)


   

# # Serialize the public keys as bytes
#     a = public_key.public_bytes(
#         encoding=Encoding.PEM,
#         format=PublicFormat.SubjectPublicKeyInfo
#     )

#     b = pb1.public_bytes(
#         encoding=Encoding.PEM,
#         format=PublicFormat.SubjectPublicKeyInfo
#     )

#     if a == b:
#         print('sim')
#     lst = [1, 2, 3, 4]
    

#     signature = private_key.sign(
#     json.dumps(lst).encode(),
#     padding.PSS(
#         mgf=padding.MGF1(hashes.SHA256()),
#         salt_length=padding.PSS.MAX_LENGTH
#     ),    hashes.SHA256())

#     print(public_key.verify(signature, json.dumps(lst).encode(), padding.PSS(
#         mgf=padding.MGF1(hashes.SHA256()),
#         salt_length=padding.PSS.MAX_LENGTH
#     ),   hashes.SHA256()))

#     print(utils_sec.verify_signature(lst, signature, public_key, 'PKI'))
    pass
   
if __name__ == '__main__':
    main()