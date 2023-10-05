
from com import *


m = Map("02 ooooBoooooBoAAooBooooooooooooooooooo 14")

print(m.piece_coordinates('B'))
print(m.piece_coordinates('A'))
print(m.type_actions('B'))
print(m.type_actions('A'))
coord = m.piece_coordinates('B')














# p = m.piece_coordinates('A')
# print(p)
# print(p[0])
# print(p[-1])
   
    # oooooo
    # ooooBo
    # ooooBo
    # AAooBo
    # oooooo
    # oooooo
    

    # print(m)
# m.move('A', Coordinates(1, 0))
# print(m)
# bigmap = []
# for c in m.grid:
#     bigmap += c
# print(set(bigmap))
