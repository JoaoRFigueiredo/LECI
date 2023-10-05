.data

		.eqv off_str1, 0
	.eqv off_i, 16
	.eqv off_str2, 20
	.eqv off_g, 40
	
	.eqv	print_string, 4
	.eqv print_double, 3
	.eqv print_intu10, 36
	

	
s1:
	.asciiz "Str_1"
	.space 8
	.word 2021
	.asciiz "Str_2"
	.space 11
	.double 2.718281828459045


str1:	.asciiz "\nPrimeira string: "
str2:	.asciiz "\nAno: "
str3:	.asciiz "\nSegunda string: "
str4:	.asciiz "\nNúmero decimal: "

.text
.globl main


main:

	la $t0, s1
	la $a0, str1
	li $v0, print_string
	syscall
	
	la $a0, s1
	li $v0, print_string
	syscall
	
	la $a0, str2
	li $v0, print_string
	syscall
	
	lw $a0, off_i($t0)
	li $v0, print_intu10
	syscall
	
	la $a0, str3
	li $v0, print_string
	syscall
	
	addiu $a0, $t0, off_str2
	li $v0, print_string
	syscall
	
	la $a0, str4
	li $v0, print_string
	syscall
	
	 l.d $f12, off_g($t0)
	 li $v0, print_double
	 syscall
	 
	  mov.d $f0, $f12
	  
jr $ra 
	
	
	