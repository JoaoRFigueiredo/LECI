

.data
.eqv SIZE, 20
str1: .asciiz "Introduza uma string: "
str2:	.space SIZE
.eqv print_string, 4
.eqv read_string, 8

.text
.globl main

main:	
	la $a0, str1		#
	li $v0, print_string	#
	syscall			#print_string("Introduza uma string: "); 
	
	la $a0, str2		#
	li $a1, SIZE		#
	
	li $v0, read_string	#
	syscall			#read_string(str, SIZE); 
	la $t0, str2		#p = str
	
while:	lb $t1, 0($t0)
	beqz $t1,  endwhile
	sub $t1, $t1, 0x20
	sb $t1, 0($t0)
	addi $t0, $t0, 1
	
	j while
	
endwhile:	
	la $a0, str2
	li $v0, print_string
	syscall
	
	jr $ra
	
	
	
	
	
