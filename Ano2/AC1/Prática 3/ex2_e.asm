 # int flag;
 #unsigned int value, bit, i;
# print_string("Introduza um numero: ");
# value = read_int();
# print_string("\nO valor em binário e': "); 
#do
 #{
  #  bit = value >> 31;
   # if(flag == 1 || bit != 0)
    #{
     #   flag = 1;
      #  if((i % 4) == 0)
       #     print_char(' ');
        #    print_char(0x30 + bit);
        # }
   # value = value << 1;
 #}while(i < 32)
 
 #Mapa de registos:
 #$t0 = value
 #$t1 = bit
 #$t2 = i
 #$t3 = rem
 #$t4 = flag
 
 	.data
 str1:	.asciiz "Introduza um número "
 str2: .asciiz "\nO valor em binário é: "
 	.eqv print_string,4
 	.eqv read_int, 5
 	.eqv print_char, 11
 	.text
 	.globl main 
 	
 main:	li $t2, 0	#i = 0;
 	li $t3, 0	#flag = 0;
 	
 	 la $a0, str1
	ori $v0, $0, print_string	#print_string("Introduza um número");
	syscall
	
	ori $v0, $0, read_int		
	syscall
	or $t0, $0, $v0			#value = read_int()
	
	la $a0, str2
	ori $v0, $0, print_string	#print_string("\nO valor em binário é: ");
	syscall

do:	bge, $t2, 32, enddo
	srl $t1, $t0, 31		#bit = value >> 31
	rem $t4, $t2, 4			#$t4 = i%4 (resto da divisao inteira de $t2 por 4)

if:	beq $t3, 1, if3
	

if2:	beq $t1, 0, endwhile
	

if3:	bne $t4, 0, endif3
	li $t3, 1	
	li $a0, ' '
	ori $v0, $0, print_char
	syscall
	
endif3:	
	addi $a0, $t1, '0'	#$a0 = 0x30 + bit // ou $a0 = '0' + bit
	ori $v0, $0, print_char		#print_char($a0);
	syscall
	j endwhile
	
endwhile:	
	sll $t0, $t0, 1	
	addi $t2, $t2, 1
	j do
	
enddo:	jr $ra
	 
 