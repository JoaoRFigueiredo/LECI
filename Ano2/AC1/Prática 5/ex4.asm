

.data
str1:	.asciiz "\nIntroduza um número: "
str2:	.asciiz "Conteudo do array: "
str3:	.asciiz "; "



.align 2
lista:	.space 40
.eqv FALSE, 0
.eqv TRUE, 1
.eqv SIZE, 10
.eqv print_string, 4
.eqv print_int10, 1
.eqv read_int, 5

.text
.globl main
##INtroduçao de elementos no array
main:	la $t0, lista		#lista = p
	li $t1, SIZE
	sll $t1, $t1, 2
	addu $t2, $t1, $t0	#$t2 = SIZE + lista
	
for1: bgeu $t0, $t2  endfor1	#i>SIZE+lista

	la $a0, str1		#
	li $v0, print_string	#print_string(str1)
	syscall			#
	
	li $v0, read_int	#$v0 = read_int(9
	syscall
	
	move $t3, $v0		#$t3 = $v0 = read_int()
	sw $t3, 0($t0)		#*p = $t3 ou lista[i] = $t3 (caso fosse indexado)
	
	
	addiu $t0, $t0, 4	#p++
	
	j for1
endfor1:

##Ordenaçao do array
la $t1, lista
li $t2, SIZE
subu $t2, $t2, 1
sll $t2, $t2, 2
addu $t2, $t2, $t1

do:
	li $t3, FALSE
	
	
for2: bgeu $t1, $t2, endfor2
	lw $t4, 0($t1)	# $t4 = *p
	lw $t5, 4($t1)	# $t5 = *(p+1)
	
if:	ble $t4, $t5, endif
	sw $t4, 4($t1)	# $t4 = *p
	sw $t5, 0($t1)	# $t5 = *(p+1)
	li $t3, TRUE
endif:
	addiu $t1, $t1, 4
	j for2
endfor2:
enddo: beq $t3, TRUE, do


	

 ##impressao do array
 
 la $a0, str2
 li $v0, print_string
 syscall
 
 li $t0, 0
 for3:	bge $t0, SIZE, endfor3
 	la $t1, lista
 	sll $t2, $t0, 2	#$t2 = i*4
 	addu $t2, $t2, $t1	#$t2 = &(lista[i])
	lw $t3, 0($t2)
	move $a0, $t3
	li $v0, print_int10
	syscall
	 la $a0, str3
	 li $v0, print_string
	 syscall
	 
	 addi $t0, $t0, 1
	 j for3
endfor3:	jr $ra



	