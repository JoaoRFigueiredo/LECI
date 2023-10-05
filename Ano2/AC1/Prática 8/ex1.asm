.data
str:	.asciiz "2020 e 2024 sao anos bissextos"
.eqv print_int10, 1


.text
.globl main

main:
	addiu $sp, $sp, -4
	sw $ra, 0($sp)
	la $a0, str
	jal atoi
	move $a0, $v0
	li $v0, print_int10
	syscall
	
	lw $ra, 0($sp)
	addiu $sp, $sp, 4
	
	jr $ra

atoi:
	li $t1, 0
	
	
while:	lb $t2, 0($a0)
	blt $t2, '0', endwhile
	bgt	$t2, '9', endwhile
	
	sub $t0, $t2, '0'
	addiu $a0, $a0, 1
	mul $t1, $t1, 10
	add $t1, $t1, $t0
	
	j while
endwhile:
	move $v0, $t1
	jr $ra