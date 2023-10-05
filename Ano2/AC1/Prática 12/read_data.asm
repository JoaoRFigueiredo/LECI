.data
.eqv off_number, 0
	.eqv off_firstName, 4
	.eqv off_lastName, 22
	.eqv off_grade, 40
	.eqv	print_string, 4
	.eqv read_int, 5
	.eqv read_string, 8
	.eqv read_float, 6
	
str1:	.asciiz "N. Mec: "
str2:	.asciiz "Primeiro Nome: "
str3:	.asciiz "Ultimo Nome: "
str4:	.asciiz "Nota: "
.text
.globl read_data

read_data:
	li $t0, 0
	move $t4, $a1
	move $t1, $a0
	
for:	bge $t0, $t4, endfor

	la $a0, str1
	li $v0, print_string
	syscall
	
	li $v0, read_int
	syscall
	
	mul $t2, $t0, 44
	addu $t2, $t1, $t2
	sw $v0, off_number($t2)
	
	la $a0, str2
	li $v0, print_string
	syscall
	
	addiu $a0, $t2, off_firstName
	li $a1, 18
	li $v0, read_string
	syscall
	
	la $a0, str3
	li $v0, print_string
	syscall
	
	addiu $a0, $t2, off_lastName
	li $a1, 15
	li $v0, read_string
	syscall
	
	la $a0, str4
	li $v0, print_string
	syscall
	
	li $v0, read_float
	syscall
	
	addiu $t2, $t2, off_grade
	s.s $f0, 0($t2)
	
	addi $t0, $t0, 1
	j for
	
endfor:
	jr $ra
	
	
	
	
	
