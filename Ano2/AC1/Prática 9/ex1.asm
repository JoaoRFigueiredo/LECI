.data

.eqv print_float, 2
.eqv read_int, 5

k1:	.float, 2.59375
k2:	.float, 0.0

.text
.globl main1

main1:
do:
	li $v0, read_int
	syscall
	move $t0, $v0
	mtc1 $t0, $f0		#$f0 = val
	cvt.s.w $f0, $f0	#$f0 = (float)val
	l.s $f2, k1	#$f2 = 2.59375
	mul.s	$f2, $f0, $f2	#$f2 = (float)val * 2.59375
	mov.s $f12, $f2
	li $v0, print_float
	syscall
	l.s $f4, k2	#$f4 = 0.0
while:	c.eq.s $f2, $f4
	bc1f do
	
	li $v0, 0	#return 0
	jr $ra
	
	
	

