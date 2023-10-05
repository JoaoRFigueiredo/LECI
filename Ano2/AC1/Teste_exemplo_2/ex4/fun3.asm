.data

	.eqv off_name, 0
	.eqv off_num, 52
	.eqv off_grade, 56
	.eqv off_type, 60
	.eqv print_string, 4
	.eqv print_float, 2
sum:	.float 0.0
two:	.float 2.0
str1:	.asciiz "\n"
.text
.globl fun3

fun3:
	li $t0, 0
	l.s $f2, sum
	l.s $f4, two
	
	
	
for:	bge $t0, $a1, endfor
	mul $t1, $t0, 64
	addu $t1, $t1, $a0
	
	addiu $a0, $t1, 0
	li $v0, print_string
	syscall
	
	addiu $t1, $t1, off_grade
	l.s $f12, 0($t1)
	li $v0, print_float
	syscall
	
	add.s $f2, $f2, $f12
	addi $t0, $t0, 1
	
	la $a0, str1
	li $v0, print_string
	syscall
	
	j for
	
endfor:

	
	div.s $f0, $f2, $f4
	
	
	
	jr $ra
	