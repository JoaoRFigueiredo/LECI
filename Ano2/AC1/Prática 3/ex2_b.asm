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
	bne $t3, 0, if			#if (i %4 != 0)
	li $a0, ' '			
	ori $v0, $0, print_char 	#print_char(' ');
	syscall
	
if:	beq $t1, 0, else	#if(bit != 0)
	li $a0, '1'
	ori $v0, $0, print_char	#print_char('1');
	syscall
	j endif

	
			
else:	#else
	li $a0, '0'		
	ori $v0, $0, print_char		#print_char('0');
	syscall
	j endif
	
endif:	sll $t0, $t0, 1
	addi $t2, $t2, 1
	j for

endfor:	jr $ra

	