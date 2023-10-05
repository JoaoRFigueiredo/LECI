.data
.eqv size, 10
a:	.sapce 80
.eqv read_int, 5
.eqv print_double, 3

.text
.globl main
	
main:
	addiu $sp, $sp, -4
	sw $ra, 0($sp)
	la $t1, a
	li $t0, 0	#int i = 0
	
for:	bge $t0, size, endfor
	sll $t2, $t0, 3
	addu $t3, $t2, $t1
	
	li $v0, read_int
	syscall
	
	mtc1 $v0, $f2
	cvt.d.w $f2, $f2
	s.d $f2, 0($t3)
	
	addi $t0, $t0, 1
	
	j for
	
endfor:

	la $a0, a
	li $a1, size
	jal average
	
	mov.d $f12, $f0
	li $v0, print_double
	syscall
	
	la $a0, a
	li $a1, size
	jal max
	
	mov.d $f12, $f0
	li $v0, print_double
	syscall
	
	li $v0, 0
	lw $ra, 0($sp)
	addiu $sp, $sp, 4
	
	jr $ra
	
	
