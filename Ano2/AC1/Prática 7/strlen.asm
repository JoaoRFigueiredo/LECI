



.data

str1: .asciiz "Arquitetura de Computadores I"

.eqv print_int10, 1

.text
.globl main

main:
	addiu $sp, $sp, -4
	sw $ra 0($sp)
	la $t0, str1
	move $a0, $t0
	jal strlen
	
	move $a0, $v0
	li $v0, print_int10
	syscall
	li $v0, 0
	lw $ra, 0($sp)
	addiu $sp, $sp, 4
	
jr $ra

strlen:
	li $t1, 0
	
while:	lb $t0, 0($a0)
	beq $t0, '\0', endwhile
	addiu $a0, $a0, 1
	addi $t1, $t1, 1
	j while
endwhile:
	move $v0, $t1
	jr $ra
	
	
