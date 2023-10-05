.data

.text
.globl max

max:
	move $t0, $a0
	move $t1, $a1
	addi $t1, $t1, -1
	sll $t1, $t1, 3
	addu $t2, $t0, $t1
	l.d $f0, 0($t0)
	addiu $t0, $t0, 0
	
for:	bgt	$t0, $t2, endfor
	l.d $f2, 0($t0)
	
if:	c.lt.d	$f2, $f0
	bc1t endif
	mov.d $f0, $f2
endif:
	addi $t0, $t0, 8
	j for
endfor:
	jr $ra
	
