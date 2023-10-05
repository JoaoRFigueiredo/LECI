.data

.eqv STR_MAX_SIZE, 30

str1:	.asciiz "I serodatupmoC ed arutetiuqrA"
str2:	.space 31
str3:	.asciiz "\n"
str4:	.asciiz #String to long: "

.eqv print_string, 4
.eqv print_int10, 1

.text
.globl main

main:
	addiu $sp, $sp, -4
	sw $ra, 0($sp)
	la $a0, str1
	jal strlen
	move $t0, $v0
	
if:	bgt $t0, STR_MAX_SIZE, else
	la $a0, str2
	la $a1, str1
	jal strcopy
	
	
	move $a0, $v0
	li $v0, print_string
	syscall
	
	la $a0, str3
	li $v0, print_string
	syscall
	
	la $a0, str2
	jal strrev
	move $a0, $v0
	li $v0, print_string
	syscall
	
	li $v0, 0
	j endif
else:
	la $a0, str4
	li $v0, print_string
	syscall
	
	la $a0, str1
	jal strlen
	move $a0, $v0
	li $v0, print_int10
	syscall
	
	li $v0, -1

endif:
	
	lw $ra, 0($sp)
	addiu $sp, $sp, 4
	
jr $ra

strlen:
	li $t1, 0
	
while1:	lb $t0, 0($a0)
	beq $t0, '\0', endwhile1
	addiu $a0, $a0, 1
	addi $t1, $t1, 1
	j while1
endwhile1:
	move $v0, $t1
	jr $ra
	
strcopy:
	li $t0, 0
do1:

	add $t1, $t0, $a0	#dst[i]
	add $t2, $t0, $a1	#src[i]
	
	lb $t3, 0($t2)
	sb $t3, 0($t1)
	
	addi $t0, $t0, 1
	
while:	bne $t3, '\0', do1
	move $v0, $a0
	
	jr $ra
	
strrev:	addiu $sp, $sp, -16
	sw $ra, 0($sp)
	sw $s0, 4($sp)
	sw $s1, 8($sp)
	sw $s2, 12($sp)
	
	move $s0, $a0 #argumento é passado em $a0
	move $s1, $a0
	move $s2, $a0
	
while3:	lb $t0, 0($s2)
	beq $t0, '\0', endwhile3
	addiu $s2, $s2, 1
	j while3
endwhile3:
	addiu $s2, $s2, -1
while4:
	bge $s1, $s2, endwhile4
	move $a0, $s1
	move $a1, $s2
	jal exchange
	addiu $s1, $s1, 1
	addiu $s2, $s2, -1
	j while4
endwhile4:
	move $v0, $s0
	lw $ra, 0($sp)
	lw $s0, 4($sp)
	lw $s1, 8($sp)
	lw $s2, 12($sp)
	addiu $sp, $sp, 16
jr $ra

exchange:
	lb $t1, 0($a0)
	lb $t2, 0($a1)
	sb $t1, 0($a1)
	sb $t2, 0($a0)
jr $ra

	
	
