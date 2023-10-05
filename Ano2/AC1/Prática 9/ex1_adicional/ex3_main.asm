.data
	.eqv SIZE, 10
	.eqv print_string, 4
	.eqv print_double, 3
	.eqv read_double, 7
arr:	.space	80
str1:	.asciiz "\nIntroduza um número: "
str2:	.asciiz "\nValor mediano: "
str3:	.asciiz "\nArray ordenado: "
str4:	.asciiz ", "
	.text

.globl main
	
main:
	addiu $sp, $sp, -8
	sw $ra, 0($sp)
	sw $s0, 4($sp)
	la $t1, arr
	move $s0, $t1
	li $t0, 0	#int i = 0
	la $a0, str1
	#####	 PREENCHER O ARRAY ######
	
for:	bge $t0, SIZE, endfor
	
	la $a0, str1
	li $v0, print_string
	syscall
	
	li $v0, read_double
	syscall
	
	sll $t3, $t0, 3
	addu $t2, $t3, $t1
	s.d $f0, 0($t2)
	addi $t0, $t0, 1
	j for
	
endfor:
	lw $ra, 0($sp)
	lw $s0, 4($sp)
	addiu $sp, $sp, 8
	li $v0, 0
	jr $ra