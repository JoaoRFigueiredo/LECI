#Mapa de registos
#n_even = $t0
#n_odd = $t1
# p1 = $t2
# $t3 = N + a
# $t4 = *p1
# $t5 = p2

.data

.eqv N, 3
a:	.space 12
lista:	.space 12


.eqv read_int, 5
.eqv print_int10, 1

.text
.globl main

main:
	li $t0, 0	#n_even = 0
	li $t1, 0	# n_odd = 0
	la $t2, a	#p = a
	li $t3, N
	sll $t3, $t3, 2
	addu $t3, $t3, $t2
	
for1:	bge $t2, $t3, endfor1
	
	li $v0, read_int
	syscall
	
	sw $v0, 0($t2)
	
	addiu $t2, $t2, 4
j for1

endfor1:

	la $t2, a
	la $t5, lista
	li $t3, N
	sll $t3, $t3, 2
	addu $t3, $t3, $t2	#N + a
	
for2:	bge $t2, $t3, endfor2
	lw  $t6, 0($t2)
	rem $s0, $t6, 2
	
	

if:	beqz $s0, else
	lw $t4, 0($t2)
	sw $t4, 0($t5)
	addiu $t5, $t5,4
	addi $t1, $t1, 1
	j endif
	
else:	addi $t0, $t0, 1

endif:

addiu $t2, $t2, 4
j for2

endfor2:

	
	move $t7, $t1
	sll $t7, $t7, 2
	addu $t8, $t7, $t5	#b + n_odd
	la $t5, lista
	
for3:	bge $t5, $t8, endfor3
	
	
	lw $a0, 0($t5)
	li $v0, print_int10
	syscall
	addiu $t5, $t5, 4
	
	j for3
	
endfor3:

jr $ra
	
	





	
	
	
