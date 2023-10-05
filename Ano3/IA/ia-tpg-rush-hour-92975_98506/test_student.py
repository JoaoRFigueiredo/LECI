from student import *
from common import *
from Domain import *


d = Domain
m = Map("01 ooooooooooooAAoooooooooooooooooooooo 5")
print(go_to_car('A', m.txt, Coordinates(3, 3) ))
print(Coordinates(3, 3))
print(m.piece_coordinates('B'))
print(m.piece_coordinates('A'))
#print(m.grid)


# ooooBo
# ooooBo
# AAooBo
# oooooo
# oooooo
# oooooo