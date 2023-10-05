.data

.text
.globl strrev




strrev:	addiu $sp, $sp, -16
	sw $ra, 0($sp)
	sw $s0, 4($sp)
	sw $s1, 8($sp)
	sw $s2, 12($sp)
	
	move $s0, $a0 #argumento é passado em $a0
	move $s1, $a0
	move $s2, $a0
	
while:	lb $t0, 0($s2)
	beq $t0, '\0', endwhile
	addiu $s2, $s2, 1
	j while
endwhile:
	addiu $s2, $s2, -1
while2:
	bge $s1, $s2, endwhile2
	move $a0, $s1
	move $a1, $s2
	jal exchange
	addiu $s1, $s1, 1
	addiu $s2, $s2, -1
	j while2
endwhile2:
	move $v0, $s0
	lw $ra, 0($sp)
	lw $s0, 4($sp)
	lw $s1, 8($sp)
	lw $s2, 12($sp)
	addiu $sp, $sp, 16
jr $ra
