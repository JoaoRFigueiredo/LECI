.data

.text
.globl fun2

fun2:
	addiu $sp, $sp, -12
	sw $ra, 0($sp)
	sw $s0, 4($sp)
	sw $s1, 8($sp)
	li $t0, 0	#$t0 = n = 0
	move $t1, $a0
	lw $s0, 0($t1)
	move $s1, $a1
	
	

while:	lw $s0, 0($t1)
	move $s1, $a1
	beq $s0, $s1, endwhile
	move $a0, $s0
	move $a1, $s1
	
	jal funk
	
	addi $t0, $t0, $v0
	addi $t1, $t1, 4
	
	j while
endwhile:
	lw $ra, 0($sp)
	lw $s0, 4($sp)
	lw $s1, 8($sp)
	addiu $sp, $sp, 12
	move $v0, $t0
	
	jr $ra
	
	