.data 

str1:	.asciiz "Arquitetura de "
str2:	.space 50
str3:	.asciiz "\n"
str4:	.asciiz  "Computadores I"

.eqv print_string, 4
.text
.globl main

main:
	addiu $sp, $sp, -4
	sw $ra, 0($sp)
	la $a0, str2
	la $a1, str1
	jal strcopy
	
	move $t0, $v0
	move $a0, $v0
	li $v0, print_string
	syscall
	
	la $a0, str3
	li $v0, print_string
	syscall
	
	move $a0, $t0
	la $a1, str4
	jal strcat
	move $a0, $v0
	li $v0, print_string
	syscall
	
	li $v0, 0
	lw $ra, 0($sp)
	addiu $sp, $sp, 4
jr $ra

strcat:
	addiu $sp, $sp, -8
	sw $ra, 0($sp)
	sw $a0, 4($sp)
	
	move $t0, $a0
	move $t4, $a0
	
while1:	lb $t1, 0($t0)
	beq $t1, '\0', endwhile1
	addi $t0, $t0, 1
	j while1
	
endwhile1:
	move $a0, $t0
	jal strcopy
	move $v0, $t4
	
	lw $ra, 0($sp)
	lw $a0, 4($sp)
	addiu $sp, $sp, 8
	
jr $ra
	
strcopy:
	move $t0, $a0	#*p1 = dst
	move $t1, $a1	#*p2 = src
do1:

	lb $t3, 0($t1)
	sb $t3, 0($t0)
	addiu $t0, $t0, 1
	addiu $t1, $t1, 1
	
while2:	bne $t3, '\0', do1
	move $v0, $a0
	
	jr $ra
	
	