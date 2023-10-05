.data

dois: .double 2.0
zero:	.double 0.0



.text
.globl fun1

fun1:
	li $t0, 0	#int k = 0
	l.d $f2, dois	#f2 = 2.0
	l.d $f4, zero	#f4 = 0.0
	move $t1, $a0	# p = a
	move $t2, $a1	#$t2 = N
	move $s0, $a1
	move $t4, $a2
	sll $t2, $t2, 3
	
	addu $t3, $t2, $t1
	
for:	bge $t1, $t3, endfor
	l.d $f6, 0($t1)	#f6 = p*
	div.d $f8, $f6, $f2
	
if:	c.eq.d	$f8, $f4
	bc1t else
	s.d $f6, 0($t4)
	addi $t4, $t4, 8
	j endif
	
else:
	addi $t0, $t0, 1
endif:
	addi $t1, $t1, 8
	j for
endfor:
	sub $v0, $s0, $t0
	jr $ra
	
	
	
	
	
	
	