.data
	
	.eqv off_idNumber, 0
	.eqv off_firstName, 4
	.eqv off_lastName, 22
	.eqv off_grade, 40
	
	.eqv	print_string, 4
	.eqv print_intu10, 36
	.eqv print_char, 11
	.eqv print_float, 2
	.eqv read_int, 5
	.eqv read_string, 8
stg:
	.space 22
	.asciiz "Bonaparte"
	.space 5
	.float 5.1
	
str1:	.asciiz "\nN. Mec: "
str2:	.asciiz "\nNome: "
str3:	.asciiz "\nNota: "
str4:	.asciiz "Primeiro Nome: "
str5:	.asciiz "N. Mec: "


.text
.globl main


main:
	la $t0, stg
	la $a0, str5
	li $v0, print_string
	syscall
	
	li $v0, read_int
	syscall
	
	sw $v0, off_idNumber($t0)
	
	la $a0, str4
	li $v0, print_string
	syscall
	
	addiu $t1, $t0, off_firstName
	move $a0, $t1
	
	li $v0, read_string
	li $a1, 18
	syscall
	
	
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
	
	
	
	
	
	
	
	