.data



.text
.globl main





strcopy:
	li $t0, 0
do:

	add $t1, $t0, $a0	#dst[i]
	add $t2, $t0, $a1	#src[i]
	
	lb $t3, 0($t2)
	sb $t3, 0($t1)
	
	
			
	
	addi $t0, $t0, 1
	addi $t4, $t2, 1
while:	bne $t4, '\0', do
	move $v0, $t1
	
	jr $ra
	
	
