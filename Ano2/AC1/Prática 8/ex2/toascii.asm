.data



.text
.globl toascii

toascii:
	addiu $sp, $sp, -4
	sw $ra, 0($sp)
	move $t0, $a0
	addi $t0, $t0, '0'
	
if:	blt $t0, '9', endif
	addi $t0, $t0, 7
	
endif:
	move $v0, $t0
	lw $ra, 0($sp)
	addiu $sp, $sp, 4
	jr $ra
