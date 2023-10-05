# Mapa de registos:
# $t0 – value
# $t1 – bit
# $t2 - i
 	.data
str1: .asciiz "Introduza um numero: "
str2: .asciiz "\nO valor em binário é: "
 	.eqv print_string,4
 	.eqv read_int, 5
 	.eqv print_char, 11
 	.text
 	.globl main
 	
main: 	li $t2, 0	#i = 0;

	la $a0, str1
	ori $v0, $0, print_string	#print_string("Introduza um número");
	syscall
	
	ori $v0, $0, read_int		
	syscall
	or $t0, $0, $v0			#value = read_int()
	
	la $a0, str2
	ori $v0, $0, print_string	#print_string("\nO valor em binário é: ");
	syscall
	
	
for:	bge $t2, 32, endfor
	rem $t3, $t2, 4
	
	andi $t1, $t0, 0x80000000	#bit = value & 0x80000000; 
	srl $t1, $t1, 31
	bne $t3, 0, endif			#if (i %4 != 0)
	li $a0, ' '			
	ori $v0, $0, print_char 	#print_char(' ');
	syscall
	
		

	
endif:	addi $a0, $t1, '0'	#$a0 = 0x30 + bit // ou $a0 = '0' + bit
	ori $v0, $0, print_char		#print_char($a0);
	syscall
	sll $t0, $t0, 1		#value = value << 1
	addi $t2, $t2, 1	#i++
	j for

endfor:	jr $ra