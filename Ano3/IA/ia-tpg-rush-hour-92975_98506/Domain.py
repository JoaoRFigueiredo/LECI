import math
import sys
from com import *


#domínio do jogo
#Aqui estão as funções responsáveis por calcular os movimentos possíveis dos carros,
#  os custos, o custo heuristico e se uma dado movimento é possível
class Domain:
    def __init__(self):
        pass
        

    def actions(grid):
        #Inicialmente passamos a grid como string com tamanho  de x². Sabemos que representa uma grelha do jogo de x*x
        #muitos níveis tem o tamanho de 36, logo a grid vai ser 6x6 (por exemplo)
        #Esta função tem a responsabilidade de obter todos os movimentos possíveis para um dado estado da grid
        #Ou seja, que carros podem andar e em que direções/sentidos
        car_actions = []
        m = Map(grid)
        bigmap = []
        for c in m.grid:
            bigmap += c
        mapa = set(bigmap)
        dimension = int(math.sqrt(len(grid)))

        for carro in mapa:
            if carro in ('o', 'x'):
                continue

            movement = m.type_actions(carro)
            if not movement:
                continue

            for c in movement:
                car_index = grid.index(c[0])
                direction = c[1]
                size = c[2]

                if size == 2:
                    if direction in ('d', 'a'):
                        indices = car_index, car_index + 1
                    elif direction in ('w', 's'):
                        indices = car_index, car_index + dimension
                else:
                    if direction in ('d', 'a'):
                        indices = car_index, car_index + 1, car_index + 2
                    elif direction in ('w', 's'):
                        indices = car_index, car_index + dimension, car_index + dimension * 2

                cm = c[0], c[1], size, indices
                car_actions.append(cm)

        return car_actions 




    #A função result, pega numa grid, numa lista de ações e forma uma nova grid
    #Ou seja, se mexer o carro D (por exemplo) num sentido possível, a grelha vai ficar diferente
    #portanto, tenho de devolcer uma grid transformada
    #No fundo, estamos a gerar nós na árvore.
    #Se de um nó, há 4 actions possíveis, esta função devolverá 4 transformações da grid do mesmo nó
    #action = tuplo com a letra do carro que pode andar e para onde"
    #o sentido é identificado com uma letra, w --> cima, s --> baixo, a --> esquerda, d --> direita; movimentos de uma unidade
    #não preciso de me preocupar em validar o movimento, pois o actions já o está a fazer
    def result(grid, action):
        grid = list(grid[0])
        car, direction, size, indices = action
        grid_size = int(math.sqrt(len(grid)))
        car_index = grid.index(car)

        if direction == 'd':
            offset = size
            grid[car_index], grid[car_index + offset] = 'o', car
        elif direction == 'a':
            offset = size
            grid[car_index - 1], grid[car_index + offset - 1] = car, 'o'
        elif direction == 's':
            offset = grid_size
            grid[car_index], grid[car_index + offset * size] = 'o', car
        elif direction == 'w':
            offset = grid_size
            grid[car_index - offset], grid[car_index + offset * (size - 1)] = car, 'o'

        car_index = grid.index(car)
        car_positon_cursor = (car_index % grid_size, car_index // grid_size)
        return ''.join(grid), car_positon_cursor

    

    def cost(action, node, cursor):
        # devolve o custo de um nó
        # custo é igual ao nº de carros na grid + o numero de moves que são necessárias para chegar a um estado a partir de um inicial
        grid, _, _, _, _, _ = node
        cost = 1 # each move costs 1
        num_cars = len([c for c in grid if c.isupper()])
        num_moves = abs(cursor[0] - node[5][0]) + abs(cursor[1] - node[5][1])
        cost = cost + num_cars + num_moves 
        return cost
        #return 0
    
    

    def heuristic( node, state, goal_state, dimensions, heuristic ):
        #temos 2 heurísticas, desnevolvidas:
        # se == 1, heuristica é igual à distância de manhattan
        # se == 2, heuristica é igual ao número de blocking cars
        if heuristic == 1:
            row_goal, col_goal = goal_state // dimensions[0], goal_state % dimensions[0]
            #print(row_goal, col_goal)
            cursor = state.index("A")
            row_cursor, col_cursor = cursor // dimensions[0], cursor % dimensions[0]
            return abs(row_goal - row_cursor) + abs(col_goal - col_cursor)
        elif heuristic == 2:
            grid, _, _, _, _, _ = node
            row_length = int(len(grid) ** 0.5)
            start_index = grid.index('AA')
            row = start_index // row_length
            #print(row)
            row_start = row * dimensions[0]
            row_end = row_start + dimensions[0]
            row = grid[row_start:row_end]
            blocking_cars = len([c for c in row[row.index("AA") + 2:] if c.isupper()])
            return blocking_cars

   
    