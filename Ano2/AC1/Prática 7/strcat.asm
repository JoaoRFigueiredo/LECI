.data
.text
.globl strcat

strcat:
	addiu $sp, $sp, -8
	sw $ra, 0($sp)
	sw $a0, 4($sp)
	
	move $t0, $a0
	move $t4, $a0
while:	lb $t1, 0($t0)
	beq $t1, '\0', endwhile
	addi $t0, $t0, 1
	j while
	
endwhile:
	move $a0, $t0
	jal strcopy
	move $v0, $t4
	lw $ra, 0($sp)
	lw $a0, 4($sp)
	addiu $sp, $sp, 8
	
jr $ra