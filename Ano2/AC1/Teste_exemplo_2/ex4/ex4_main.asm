.data
	
	.eqv print_string, 4
	.eqv print_float, 2
.align 2	
std:	.asciiz "Rei Eusebio"
	.space 38
	.word 12345
	.float 17.2
	.byte 'F'
	
	.asciiz "Rainha Amalia"
	.space 36
	.word  23450
	.float 12.5 
	.byte 'C'
	
	
	
	

.text 
.globl main


main:
	addiu $sp, $sp, -4
	sw $ra, 0($sp)
	
	la $a0, std
	li $a1, 2
	jal fun3
	
	mov.s $f12, $f0
	li $v0, print_float
	syscall
	
	lw $ra, 0($sp)
	addiu $sp, $sp, 4
	li $v0, -1
	jr $ra

	