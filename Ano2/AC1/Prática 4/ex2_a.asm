#Mapa dos registos
#num	:	$t0
#p	:	$t1
#*p	:	$t2

.data

.eqv SIZE, 20
.eqv read_string, 8
.eqv print_int10, 1

str:	.space SIZE
.text
.globl main

main:	li $t0, 0		#num = 0
	la $a0, str
	li $a1, SIZE 
	la $t1, str
	li $v0, read_string
	syscall

while:	lb $t2, 0($t1)
	beq $t2, '\0', endwhile
	blt $t2, '0', endif
	bgt $t2, '9', endif
	addi $t0, $t0, 1
	
endif:	addi $t1, $t1 ,1
	j while
	
endwhile:
	or $a0, $0, $t0
	li $v0, print_int10
	syscall
	
	 jr $ra 
	
	
