#Mapa de registos
#i = $t0
#v = $t1
#&(val[0]) = $t2
#$t3 = &(val[i])
#$t4 = val[i]
#$t5 = val[i+size/2]
.data

.eqv SIZE, 8
lista:	.word 8, 4, 15, -1987, 327, -9, 27, 16

str1:	.asciiz "Result is: "

.eqv print_string, 4
.eqv print_int10, 1
.eqv print_char, 11

.text
.globl main

main:
	li $t0, 0
	
do:
	la $t2, lista	#$t2 = &(val[0])
	sll $t3, $t0, 2
	addu $t3, $t2, $t3
	lw $t4, 0($t3)	#$t4 = val[i]
	lw $t5, 16($t3)	#$t5 = val[i+size/2]
	
	move $t1, $t4
	sw $t4, 16($t3)
	sw $t5, 0($t3)
	addi $t0, $t0, 1
while: blt $t0, 4, do
	
	la $a0, str1
	li $v0, print_string
	syscall
	
	li $t0, 0
do2:
	la $t2, lista	#$t2 = &(val[0])
	sll $t3, $t0, 2
	addu $t3, $t2, $t3
	lw $t4, 0($t3)	#$t4 = val[i]
	
	move $a0, $t4
	li $v0, print_int10
	syscall
	
	addi $t0, $t0, 1
	li $a0, ','
	li $v0, print_char
	syscall
	
while2:	blt $t0, SIZE, do2

	jr $ra
	
	
	
	
	