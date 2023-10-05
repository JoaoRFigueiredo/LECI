.data
	.eqv off_number, 0
	.eqv off_firstName, 4
	.eqv off_lastName, 22
	.eqv off_grade, 40
	.eqv Max_students, 4
	
st_array:	.space  176
.align 2
media:	.space 4

str1:	.asciiz "\nMedia: "
str2:	.asciiz "\n"
	
	.eqv	print_string, 4
	.eqv print_intu10, 36
	.eqv print_char, 11
	.eqv print_float, 2

.text
.globl main

main:	
	addiu $sp, $sp, -8
	sw $ra, 0($sp)
	sw $s0, 4($sp)
	la $a0, st_array
	li $a1, Max_students
	jal read_data
	
	la $a0, st_array
	li $a1, Max_students
	la $a2, media
	jal max
	
	move $s0, $v0		#$s0 = pmax
	
	la $a0, str1
	li $v0, print_string
	syscall
	
	la $t0, media
	l.s $f12, 0($t0)
	li $v0, print_float
	syscall
	
	la	$a0, str2		#	$a0 = "\n"
	li	$v0, print_string	#
	syscall	
	
	move $a0, $s0
	jal print_student
	
	li $v0, 0
	lw $ra, 0($sp)
	lw $s0, 4($sp)
	addiu $sp, $sp, 8
	jr $ra
