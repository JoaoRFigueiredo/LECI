.data
.text
.globl main
main: ori $t0, $0, 15 # $t0 = numero em gray
srl $t1, $t0, 4 # num >> 4 
xor $t0, $t0, $t1# num xor (num>>4)
srl $t1, $t0, 2 # num >> 2 
xor $t0, $t0, $t1# num xor (num>>2)
srl $t1, $t0, 1 # num >> 1 
xor $t0, $t0, $t1# num xor (num>>1)

