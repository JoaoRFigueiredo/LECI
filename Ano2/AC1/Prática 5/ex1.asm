#Mapa de registos
# $t0 = 1
# $t1 = lista
# $t2 = lista +i

.data


str1:	.asciiz "\nIntroduza um numero: "
.eqv SIZE, 5
.align 2
lista:	.space SIZE
.eqv print_string, 4
.eqv read_int, 5

.text
.globl main

main:
	li $t0, 0
	
for:	bge $t0, SIZE, endfor	#for (int i = 0; i<SIZE; i++)

	la $a0, str1	#$a0 = str1
	li $v0, print_string	#Print_string(str1)
	syscall#
	
	li $v0, read_int
	syscall		#read_int
	
	la $t1, lista
	sll $t2, $t0, 2
	addu $t2, $t2, $t1	#$t2 = lista[i]
	sw $v0, 0($t2)		#lista[i] = read_int
		
	addi $t0, $t0, 1	#i++
	j for
	
endfor:	jr $ra
	
	
	
	
	
