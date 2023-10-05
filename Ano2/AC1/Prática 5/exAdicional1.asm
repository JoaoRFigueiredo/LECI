.data 
.eqv SIZE, 10
lista: .space 40

.eqv print_string, 4
.eqv print_int10, 1
.eqv read_int, 5

str1:	.asciiz "Introduza um número: "
str2:	.asciiz "Conteudo do array: \n"
str3:	.asciiz "; "


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
#ordenação do array

li $t0, 0
forA: bge $t0, 9, endforA
	addi $t1, $t0, 1
forB:	bge $t1, SIZE, endforB
	la $t2, lista
	sll $t3, $t0, 2
	addu $t2, $t2, $t3	
	lw $t6, 0($t2) #$t2 = lista[i]
	
	la $t4, lista
	sll $t5, $t1, 2
	addu $t4, $t4, $t5	
	lw $t7, 0($t4)	#$t4 = lista[j]
	
if:	ble $t6, $t7, endif
	sw $t6, 0($t4)
	sw $t7, 0($t2)
endif:

	addi $t1, $t1,1
	j forB
	
endforB:
addi $t0, $t0,1
j forA

endforA:


#Imprimir conteudo do array
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
