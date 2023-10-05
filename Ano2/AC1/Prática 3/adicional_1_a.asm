#Mapa de registos:
#$t0 = gray
#$t1 = bin
#$t2 = mask

.data 

str1:	.asciiz "Introduza um n�mero: "
str2:	.asciiz "\nValor em c�digo Gray: "
str3:	.asciiz "\nValor em bin�rio: "

.eqv	read_int,  5
.eqv	print_string, 4
.eqv	print_int16, 34

.text
.globl main

main:
	la $a0, str1
	li $v0, print_string	#print_string("Introduza um n�mero: ");
	syscall
	li $v0, read_int	#gray = read_int()
	syscall
	or $t0, $0, $v0		#$t0 = gray
	srl $t2, $t0, 1		#mask = gray >> 1
	or $t1, $0, $t0		#bin = gray
	
while:	beqz $t2, endwhile

	xor $t1, $t1, $t2	#bin = bin ^ mask; 
	srl $t2, $t2, 1		#mask = mask >> 1;
	j while

endwhile: 	la $a0, str2
		li $v0, print_string	#print_string("\nValor em c�digo Gray: ")
		syscall
		
		or $a0,$0, $t0
		li $v0, print_int16	#print_int16(gray)
		syscall
		
		la $a0, str3
		li $v0, print_string	#print_string("\nValor em c�digo bin�rio: ")
		syscall
		
		or $a0,$0, $t1
		li $v0, print_int16	#print_int16(bin)
		syscall
		
		
jr $ra
		
		
		
		
			
	
	
	
	