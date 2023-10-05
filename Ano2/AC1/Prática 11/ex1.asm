.data
	
	.eqv off_idNumber, 0
	.eqv off_firstName, 4
	.eqv off_lastName, 22
	.eqv off_grade, 40
	
	.eqv	print_string, 4
	.eqv print_intu10, 36
	.eqv print_char, 11
	.eqv print_float, 2

struct:
	.word 72343
	.asciiz "Napoleao"
	.space 9
	.asciiz "Bonaparte"
	.space 5
	.float 5.1
	
str1:	.asciiz "\nN. Mec: "
str2:	.asciiz "\nNome: "
str3:	.asciiz "\nNota: "

.text
.globl main


main:
	la $t0, struct
	la $a0, str1
	li $v0, print_string
	syscall
	
	lw $a0, off_idNumber($t0)
	li $v0, print_intu10
	syscall
	
	la $a0, str2
	li $v0, print_string
	syscall
	
	addiu $a0, $t0, off_lastName
	li $v0, print_string
	syscall
	
	li $a0, ','
	li $v0, print_char
	syscall
	
	addiu $a0, $t0, off_firstName
	li $v0, print_string
	syscall
	
	la $a0, str3
	li $v0, print_string
	syscall
	
	l.s $f12, off_grade($t0)
	li $v0, print_float
	syscall
	
	jr $ra
	