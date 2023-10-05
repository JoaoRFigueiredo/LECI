#Mapa de registos
#val: $t0
#n: $t1
#min: $t2
#max: $t3

.data
.eqv print_string, 4
.eqv read_int, 5
.eqv print_int10, 1
.eqv print_char, 11

str1:	.asciiz "Digite ate 20 inteiros (zero para terminar):"
str2:	.asciiz "Máximo/mínimo são: "
.text
.globl main

main:
	li $t1, 0
	li $t2, 0x7fffffff
	li $t3, 0x80000000
	
	la $a0, str1
	li $v0, print_string
	syscall
	
do:
	li $v0, read_int
	syscall
	move $t0, $v0
if1: beqz $t0, endif1

if2: ble $t0, $t3, if3
	move $t3, $t0

if3:bge $t0, $t2, endif1
	move $t2, $t0
	
endif1:

addi $t1, $t1, 1

	bge $t1, 20, do
while:	bnez $t0, do
	
	la $a0, str2
	li $v0, print_string
	syscall
	
	or $a0, $0, $t3
	li $v0, print_int10
	syscall
	
	li $a0, 0x3a
	li $v0, print_char
	syscall
	
	or $a0, $0, $t2
	li $v0, print_int10
	syscall
	
jr $ra
	
