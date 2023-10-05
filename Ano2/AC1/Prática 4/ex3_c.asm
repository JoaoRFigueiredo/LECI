#Mapa de registos
#soma = $t0
#i = $t1
#$t2 = size -1
#$t3 = array
#$t4 : array[iultimo]
#$t5 = array[i]
.data

array:	.word 7692, 23, 5, 234
.eqv SIZE, 4
.eqv print_int10, 1
.text
.globl main

main:
	li $t0, 0		# soma = 0
	li $t1, 0		#i = 0
	li $t2, SIZE		#
	sub $t2, $t2, 1		#SIZE -1
	sll $t2, $t2, 2
	la $t3, array
	addu $t4, $t3, $t2
	
while:	la $t3, array
	add $t3, $t3, $t1
	lw $t5, 0($t3)
	
	bgtu $t3, $t4, endwhile
	add $t0, $t0, $t5
	addiu $t1, $t1, 4
	j while
	
	
endwhile:	
	or $a0, $0, $t0
	li $v0, print_int10
	syscall
	jr $ra
	
	
	
