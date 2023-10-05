
.data
.eqv print_string, 4
.eqv print_int10, 1

str1:	.asciiz "Nr. de parametros: "
str2:	.asciiz "\nP"
str3:	.asciiz ": "


.text
.globl main

main:
	li $t0, 0
	move $t1, $a0
	move $t2, $a1
	
	la $a0, str1
	li $v0, print_string
	syscall
	
	move $a0, $t1
	li $v0, print_int10
	syscall
	
for: 	bge $t0, $t1, endfor
	la $a0, str2
	li $v0, print_string
	syscall
	
	or $a0, $0, $t0
	li $v0, print_int10
	syscall
	
	la $a0, str3
	li $v0, print_string
	syscall
	
	sll $t3, $t0, 2
	addu $t4, $t2, $t3
	lw $t4, 0($t4)
	
	move $a0, $t4
	li $v0, print_string
	syscall
	
	addi $t0, $t0, 1
	
	j for
endfor:
	jr $ra
	
	
	