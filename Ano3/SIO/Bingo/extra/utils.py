import random

import json
import os
import sys
sys.path.append(os.path.dirname(os.getcwd())+"/playing_area")
sys.path.append(os.path.dirname(os.getcwd())+"/player")
sys.path.append(os.path.dirname(os.getcwd())+"/extra")
sys.path.append(os.path.dirname(os.getcwd())+"/caller")
N = 75
M = 25
NAMES = ['Ana', 'Alex', 'Alice', 'Amanda', 'Amaro', 'Anita', 'Adao', 'Alberto', 'Bianca', 'Bruno', 'Bernardo', 'Beto', 'Bruna', 'Carlos', 'Catia',   'Diogo', 'Vanessa', 'Diana', 'Delfim', 'Duarte', 'Debora', 'Eva', 'Eduardo', 'Sofia', 'Camila', 'Francisco', 'Sara', 'Victoria', 'Laura', 'Luna', 'Gilberto', 'Carolina', 'Penelope', 'Lia',
         'Rui', 'Xavi', 'Leonor', 'Henrique', 'Maria', 'Hugo', 'Ricardo', 'Vasco', 'Elias', 'Ester', 'Jacinta', 'Natalia', 'Zoe', 'Marcos', 'Mauro', 'Karina', 'Aurora', 'Paula', 'Sonia', 'Tatiana', 'Bela', 'Clara', 'Sky', 'Adriano', 'Giovanna', 'Lucia', 'California', 'NYC', 'Oregon', 'Utah', 'Nuno', 'Emilia', 'Joao', 'Simao']


def generate_deck():
    deck = random.sample(range(1, N+1), N)
    if random.random() < 0.1:
        print("I'm on santas' naughty list! (CHEATING)")
        chance = random.random()
        if chance < 0.5:
            invalid_card = random.randint(N+1, 2*N)
            invalid_deck = deck.copy()
            invalid_deck[random.randint(0, N-1)] = invalid_card
            return invalid_deck
        else:
            return random.sample(range(1, N+1), N) + [random.randint(N+1, 2*N)]
    return deck

def validate_deck(deck):
    if len(set(deck)) != N:
        return False
    if min(deck) != 1 or max(deck) >N:
        return False
    return True


# meter aqui a probabilidade de 10% do enunciado de fazer traquinices acho eu
def generate_card():
    card = random.sample(range(1, N+1), M)
    if random.random() < 0.1:
        chance = random.random()
        #generating invalid cards
        
        if (chance < 0.33): #card tem um tamanho errado
            cardsize = random.randint(int(M*0.8), M)
            card = random.sample(range(1, N+1), cardsize)
        elif chance >= 0.33 and chance < 0.66: # card tem numeros fora do intervalo
            card = random.sample(range(1, N+75), M)
        elif chance >= 0.66:
            valid_numbers = random.sample(range(1, N+1), M)
            invalid_numbers = [random.randint(N+1, N+25) for i in range(M)]
            repeated_numbers = [random.choice(valid_numbers) for i in range(M)]
            card = valid_numbers + invalid_numbers + repeated_numbers

    return card

def validate_card(player_card):
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

def complain_or_ban_cheating(s, cause, id, header="cheating"): 
    # client can be either user or caller
    message = {'header': header, 'body': cause, 'id': id }
    m.send_msg(s, json.dumps(message).encode('UTF-8'))

def shuffle_deck(deck):
    random.shuffle(deck)
    return deck

def subset(playerCard, called_numbers):
    return all(x in called_numbers for x in playerCard)

def play_bingo(deck, user_card):
    '''Play bingo with a deck of cards and a user card
    Returns the number of calls to fill the card'''
    # make full copy of deck
    tmp_deck = deck[:]
    called_numbers = []
    fill_calls = 0

    while True:
        try:
            called_numbers.append(tmp_deck.pop(0))
        except:
            break
        fill_calls += 1

        if subset(user_card, called_numbers):
            # print("\n************BINGO**************")
            # print(f'called_numbers: {called_numbers}')
            # print(f'Bingo with {fill_calls} number calls')
            break

    return fill_calls


def get_bingo_winners(final_deck, player_cards):
    '''Get the winners of the bingo game
    Returns a list of winners'''
    
    players = list(player_cards.keys())
    players_results = [play_bingo(final_deck, player_cards[player][0]) for player in player_cards]

    # return the id of the player(s) with the least number of calls
    return [players[i] for i, x in enumerate(players_results) if x == min(players_results)]
