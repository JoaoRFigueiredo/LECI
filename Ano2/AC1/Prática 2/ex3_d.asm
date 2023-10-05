#print_string("Introduza 2 numeros ");
#a = read_int();
#b = read_int();
#print_string("A soma dos dois numeros e': ");
#print_int10(a + b); 

.data 
str1: .asciiz "Introduza 2 numeros "
str2: .asciiz"A soma  dos dois numeros é: "
	.eqv print_string, 4
	.eqv read_int, 5
	.eqv print_int10, 1

.text
.globl main
main:
	la $a0, str1
	ori $v0,$0, print_string 
	syscall#print_string("Introduza 2 numeros ");
	
	ori $v0, $0, read_int
	syscall			#a = read_int();
	or $t0, $0, $v0
	
	ori $v0, $0, read_int
	syscall			#b = read_int();
	or $t1, $0, $v0
	
	la $a0, str2
	ori $v0,$0, print_string 
	syscall					#print_string("A soma dos dois numeros e': ");
	
	add $t2, $t1, $t0
	or $a0, $0, $t2
	ori $v0, $0, print_int10
	syscall 				#print_int10(a+b);
	
	
