.data

sum:	.double 0.0




.text
.globl average


average:
	move $t0, $a1	#int i = n
	l.d $f2, sum
	move $t1, $a0
	
for:	ble $t0, $0,  endfor
	addi $t3, $t0, -1
	sll $t3, $t3, 3		#aux = (i-1)*8
	addu $t2, $t3, $t1
	l.d $f4, 0($t2)
	add.d $f2, $f2, $f4
	addi $t0, $t0, -1
	j for
	
endfor:
	mtc1 $a1, $f6
	cvt.d.w $f6, $f6
	div.d $f0, $f2, $f6
	jr $ra  
