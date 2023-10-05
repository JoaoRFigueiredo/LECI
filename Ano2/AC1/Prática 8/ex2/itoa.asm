.data




.text
.globl itoa, exchange



itoa:
	addiu $sp, $sp, -20
	sw $ra, 0($sp)
	sw $s0, 4($sp)
	sw $s1, 8($sp)
	sw $s2, 12($sp)
	sw $s3, 16($sp)
	
	move $s0, $a0	#$s0 = n
	move $s1, $a1	#$s0 = b
	move $s2, $a2	#$s0 = s
	move $s3, $a2	#$s0 = s
	
	
do:
	rem $t0, $s0, $s1
	div $s0, $s0, $s1
	move $a0, $t0
	jal toascii
	sb $v0, 0($s3)
	addiu $s3, $s3, 1
	
while:	bgt $s0, 0, do
	
	sb $0, 0($s3)
	move $a0, $s2
	jal strrev
	move $v0, $s2
	
	lw $ra, 0($sp)
	lw $s0, 4($sp)
	lw $s1, 8($sp)
	lw $s2, 12($sp)
	lw $s3, 16($sp)
	addiu $sp, $sp, 20
	jr $ra

	

exchange:
	lb $t1, 0($a0)
	lb $t0, 0($a1)
	sb $t1, 0($a1)
	sb $t0, 0($a0)
jr $ra
	
