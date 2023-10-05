.data

.text
.globl main

main:
	li $t0, 5
	li $t1, 2
	div $t2, $t0, $t1
	
	move $a0, $t2
	li $v0, 1
	syscall
	
	jr $ra