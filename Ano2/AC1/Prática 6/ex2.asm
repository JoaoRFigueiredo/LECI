.data
.eqv SIZE, 3
array:	.word str1, str2, str3
str1:	.asciiz "Array"
str2:	.asciiz "de"
str3:	.asciiz "Ponteiros"

.eqv print_string, 4
.eqv print_char, 11

.text
.globl main

main:
	la $t1, array	#p = array
	li $t0, SIZE	#$t0 = SIZE
	sll $t0, $t0, 2
	addu $t2, $t0, $t1#pultimo = array + SIZE
	
for:	bge $t1, $t2, endfor	#p < pultimo
	lw $a0, 0($t1)
	li $v0, print_string
	syscall
	
	li $a0, '\n'
	li $v0, print_char
	syscall
	
	addi $t1, $t1, 4
	j for
	
endfor:
	jr $ra
	
	