.data

.eqv print_double, 3
k1:	.double, 5.0
k2:	.double, 9.0
k3:	.double, 32.0

str1:	.asciiz "Temperatura em Fahrenheit: "
str2:	.asciiz "Temperatura em Celsius: "

.eqv print_string, 4
.eqv read_double, 7


.text
.globl main


main:
	addiu $sp, $sp, -4
	sw $ra, 0($sp)
	
	la $a0, str1
	li $v0, print_string
	syscall
	
	
	li $v0, read_double
	syscall
	mov.d $f12, $f0
	
	jal f2c
	
	la $a0, str2
	li $v0, print_string
	syscall
	
	
	mov.d $f12, $f0
	li $v0, print_double
	syscall
	
	lw $ra, 0($sp)
	addiu $sp, $sp, 4
	jr $ra
	
	
	
	



f2c:
	l.d $f0, k1
	l.d $f2, k2
	l.d $f4, k3
	
	div.d $f8, $f0, $f2
	sub.d $f6, $f12, $f4
	mul.d $f8, $f8, $f6
	
	mov.d $f0, $f8
	jr $ra
	

	