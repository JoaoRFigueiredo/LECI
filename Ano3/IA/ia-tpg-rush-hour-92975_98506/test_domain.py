from Domain import *
from com import *

#BBBCCo
#ooHIoo
#AAHIoo
#GDDoox
#Gooooo
#oooxoo

#BBBCCoooHIooAAHIoooDDooxGoooooGooxoo
def print_grid(string, size):
    for i in range(0, len(string), size):
        print(string[i:i+size])

d = Domain
grid = Map("1 BBBCCoooHIooAAHIooGDDooxGooooooooxoo 2")
first_grid = "BBBCCoooHIooAAHIooGDDooxGooooooooxoo"
index_A = first_grid.index('D')
print(index_A % 6, index_A // 6 )
#print(d.new_actions("1 BBBCCoooHIooAAHIooGDDooxGooooooooxoo 2"))
moves = d.new_actions("1 BBBCCoooHIooAAHIooGDDooxGooooooooxoo 2")
#print("Antes do moviemnto:", first_grid)
print(moves[0])
print_grid(first_grid, 6)
# g = 'BBBCCoooHIooAAHIooGDDooxGooooooooxoo'
# print_grid(g, 6)
print('----------------Before--------------')
new_grid = d.new_results(first_grid, moves[0])
print_grid(new_grid, 6)


# print("------------------------------------------------------------------")
# print("depois do moviemto:", new_grid)
# print(new_grid == first_grid)
