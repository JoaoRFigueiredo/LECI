.data
.eqv off_number, 0
	.eqv off_firstName, 4
	.eqv off_lastName, 22
	.eqv off_grade, 40
	.eqv print_string, 4
	.eqv print_float, 2
	.eqv print_intu10, 36

str1:	.asciiz "\nID: "
str2:	.asciiz "\nPrimeiro Nome: "
str3:	.asciiz "\nUltimo Nome: "
str4:	.asciiz "\nNota: 

.text
.globl print_student



print_student:

	move $t0, $a0
	
	la $a0, str1
	li $v0, print_string
	syscall
	
	
	lw $a0, off_number($t0)
	li $v0, print_intu10
	syscall
	
	la $a0, str2
	li $v0, print_string
	syscall
	
	addiu $a0, $t0, off_firstName
	li $v0, print_string
	syscall
	
	la $a0, str3
	li $v0, print_string
	syscall
	
	addiu $a0, $t0, off_lastName
	li $v0, print_string
	syscall
	
	la $a0, str4
	li $v0, print_string
	syscall
	
	addiu $a0, $t0, off_grade
	l.s $f12, 0($a0)
	li $v0, print_float
	syscall
	
	jr $ra
	
	
	
	
