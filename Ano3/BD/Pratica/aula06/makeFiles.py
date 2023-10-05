import os

for i in range(1, 23):
    file_name = 'ex_6_1_' + chr(ord('a') + i) + '.sql'

    with open(file_name, 'w') as f:
        f.write('-- SQL script goes here')