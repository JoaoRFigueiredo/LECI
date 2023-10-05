.data
	.eqv off_str1, 0
	.eqv off_g, 16
	.eqv off_int1, 24
	.eqv off_int2, 28
	.eqv off_char, 32
	.eqv off_floatK, 36


	.eqv	print_string, 4
	.eqv print_double, 3
	.eqv print_intu10, 36
	.eqv print_float, 2
	

s2:
	.asciiz "St1"
	.space 6
	.double 3.141592653589
	.word 291, 756
	.byte 'X'
	.float 1.983
	

str1:	.asciiz "\nFloat: "
 
	 
	
.text
.globl main


main:
	addiu $sp, $sp, -4
	sw $ra, 0($sp)
	
	la $a0, str1
	li $v0, print_string
	syscall
	
	
	jal f2
	
	mov.s $f12, $f0
	li $v0, print_float
	syscall
	

	lw $ra, 0($sp)
	addiu $sp, $sp, 4

jr $ra



f2:
	la $t0, s2
	l.d $f2, off_g($t0)
	
	lw $t1, off_int2($t0)
	
	l.s $f4, off_floatK($t0)
	
	mtc1 $t1, $f6
	cvt.d.w $f6, $f6
	
	mul.d $f2, $f2, $f6
	cvt.s.d $f2, $f2
	
	div.s $f0, $f2, $f4
	
	jr $ra






