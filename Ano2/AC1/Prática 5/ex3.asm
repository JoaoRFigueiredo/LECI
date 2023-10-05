

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
	la $t6, lista
do:	li $t4, FALSE

	li $t0, 0	# i = 0 // $t0 = i
for2:   bge $t0, 9, endfor2
	sll $t5, $t0, 2	#$t5 = i*4
	addu $t5, $t5, $t6
	lw $t7, 0($t5)	#$t7 = lista[i]
	lw $t8, 4($t5)	#$t8 = lista[i+1]
	
if:	ble $t7, $t8, endif
	sw $t7, 4($t5)
	sw $t8, 0($t5)
	li $t4, FALSE
	
endif:
	addi $t0, $t0, 1
	j for2
endfor2:
	beq $t4, TRUE, do
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



	


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
