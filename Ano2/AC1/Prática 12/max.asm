.data

	.eqv off_number, 0
	.eqv off_firstName, 4
	.eqv off_lastName, 22
	.eqv off_grade, 40
	
max_grade:	.float -20.0
sum:		.float 0.0


.text
.globl max

max:
	l.s $f2, sum
	l.s $f4, max_grade

	move $t0, $a0
	move $t2, $a2
	move $t4, $a1
	mul $a1, $a1, 44
	addu $t1, $t0, $a1
	li $t3, 0	#pmax = 0
	
for:	bge $t0, $t1, endfor
	l.s $f6, off_grade($t0)
	
	add.s	$f2, $f2, $f6
	
if:	c.lt.s $f6, $f4
	bc1t endif
	mov.s $f4, $f6
	move $t3, $t0
endif:
	addi $t0, $t0, 44
	j for
	
endfor:
	mtc1	$t4, $f8
	cvt.s.w $f8, $f8
	div.s $f10, $f2, $f8
	s.s $f10, 0($t2)
	move $v0, $t3
	jr $ra
