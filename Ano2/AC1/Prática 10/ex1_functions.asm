.data


k1:	.float, 1.0

.text
.globl xtoy

xtoy:
	addiu $sp, $sp, -4
	sw $ra, 0($sp)
	li $t0, 0
	l.s $f20, k1	#result = 1.0
	mov.s $f22, $f12
	move $t1, $a1	#$t1 = y
	move $a0, $t1
	jal abs
	move $t2, $v0	#$t2 = abs(y)
for:	bge $t0, $t2, endfor
	
if:	ble $t1, 0, else
	mul.s $f20, $f20, $f12
	j endif
	
else: 
	div.s $f20, $f20, $f22
	
endif:
	addi $t0, $t0, 1
	j for
endfor:

	mov.s $f0, $f20
	lw $ra, 0($sp)
	addiu $sp, $sp, 4
	jr $ra
	

abs:
	move $t4, $a0
if1:	bge $t4, 0, endif1

	mul $t4, $t4, -1
	
endif1:
	move $v0, $t4
	jr $ra
	
	
