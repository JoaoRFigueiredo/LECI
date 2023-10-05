atoi_c:
	li $t1, 0
	
	
while:	lb $t2, 0($a0)
	blt $t2, '0', endwhile
	bgt	$t2, '1', endwhile
	
	sub $t0, $t2, '0'
	addiu $a0, $a0, 1
	mul $t1, $t1, 10
	add $t1, $t1, $t0
	
	j while
endwhile:
	move $v0, $t1
	jr $ra
	
