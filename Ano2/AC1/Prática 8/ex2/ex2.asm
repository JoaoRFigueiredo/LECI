.data

str:	.space 33
.eqv print_string, 4
.eqv read_int, 5


str1:	.asciiz "\n-----------------------\n"
.text
.globl main

main:
	addiu $sp, $sp, -8
	sw $ra, 0($sp)
	sw $s0, 0($sp)
	
do:
	li $v0, read_int
	syscall
	move $s0, $v0
	
	move $a0, $v0
	li $a1, 2
	la $a2, str
	
	jal itoa
	
	move $a0, $v0
	li $v0, print_string
	syscall
	
	la $a0, str1
	li $v0, print_string
	syscall
	
	#####################
	move $a0, $s0
	li $a1, 8
	la $a2, str
	
	jal itoa
	
	move $a0, $v0
	li $v0, print_string
	syscall
	
	la $a0, str1
	li $v0, print_string
	syscall
	#########################
	move $a0, $s0
	li $a1, 16
	la $a2, str
	jal itoa
	
	move $a0, $v0
	li $v0, print_string
	syscall
	
while:	bnez $s0, do
	li $v0, 0
	
	
	lw $ra, 0($sp)
	lw $s0, 0($sp)
	addiu $sp, $sp, 8
	jr $ra
	
