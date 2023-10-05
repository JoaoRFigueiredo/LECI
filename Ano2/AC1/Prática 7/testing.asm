.data
str1:	.asciiz	"Arquitetura de "
str2:	.space	50
str4:	.asciiz "Computadores I"
str3:	.asciiz "\n"

	.text
	.globl main
	
main: 
	addiu	$sp, $sp, -4
	sw	$ra, 0($sp)
	
	la	$a0, str2
	la	$a1, str1
	jal	strcpy
	
	move	$a0, $v0
	li	$v0, 4
	syscall
	
	la	$a0, str3
	li	$v0, 4
	syscall
	
	la	$a0, str2
	la	$a1, str4
	jal	strcat
	move	$a0, $v0
	li	$v0, 4
	syscall
	
	li	$v0, 0
	lw	$ra, 0($sp)
	addiu	$sp, $sp, 4
	jr	$ra
	
strcat:						# char *strcat(char *dst, char *src) {
	addiu	$sp, $sp, -8			# 	reservar espaco na pilha
	sw	$ra, 0($sp)			# 	salvaguardar $ra
	sw	$s0, 4($sp)			#
	move	$s0, $a0				#	$t0 = &(dst)
while:	lb	$t0, 0($a0)			#	*p = dst[0]
	beq	$t0, '\0', endw			#	while(*p != '\0') {
	addiu	$a0, $a0, 1			#		p++;
	j	while				#	}
endw:						#
	jal	strcpy				#	strcpy(&dst[fim], src)	
	move	$v0, $s0				#
	lw	$ra, 0($sp)			#	repor $ra na pilha
	lw	$s0, 4($sp)			#	
	addiu	$sp, $sp, 8			#	restabelecer tamanho da pilha
	jr	$ra				# } fim do programa
	
strcpy:					# char *strcpy(char *dst char *src) {
	move	$t2, $a0		#
do:					#	do {
	lb	$t1, 0($a1)		#		$t1 = src[i];
	sb	$t1, 0($a0)		#		dts[i] = src[i];
	addiu	$a0, $a0, 1
	addiu	$a1, $a1, 1
while2:	bne	$t1, '\0', do		#	} while(src[i] != '\0');
	move	$v0, $t2		#	return dst;
	jr	$ra	