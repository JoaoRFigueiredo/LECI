# Mapa de registos
# p: $t0
# *p: $t1
# lista+Size: $t2 

.data
.eqv SIZE, 10
lista:	.word 8, -4, 3, 5, 124, -15, 87, 9, 27, 15
str1:	.asciiz "\nConteúdo do Array: "
str2:	.asciiz "; "

.eqv print_string, 4
.eqv print_int10, 1

.text
.globl main

main:	la $a0, str1#
	li $v0, print_string#
	syscall#	print_string("\nConteudo do array: ");
	
	la $t0, lista#$t0= p
	li $t2, SIZE#
	sll $t2, $t2, 2
	addu $t2, $t2, $t0
	
for:	bgeu $t0, $t2, endfor
	lw $t1, 0($t0)
	
	or $a0, $0, $t1
	li $v0, print_int10
	syscall
	
	la $a0, str2
	li $v0, print_string
	syscall
	
	addiu $t0, $t0, 4
	j for
	
endfor:
	jr $ra
