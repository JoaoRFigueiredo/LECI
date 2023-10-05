# Mapa de Registos:
# $t0 - res
# $t1 - i
# $t2 - mdor
# $t3 - mdo

	.data
str1:	.asciiz	"Introduza dois numeros: "
str2:	.asciiz "Resultado: "
	.eqv	print_string, 4
	.eqv	read_int, 5
	.eqv	print_int10, 1
	.text
	.globl 	main
	
main:	li	$t0, 0			# res = 0
	li	$t1, 0			# i = 0
	la	$a0, str1		# $a0 = str1
	li	$v0, print_string	# $v0 = 4
	syscall				# print_string(str1);
	li	$v0, read_int		# 
	syscall				# read_int()
