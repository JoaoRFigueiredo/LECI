.data

k1:	.double, 1.0
k2:	.double, 0.0
k3:	.double, 0.5


.text
.globl sqrt

#mapa de registos
# f2 = aux
# f4 = xn
# t0 = i
# f12 = val
# f6 = temp
# f8 = 0.5 * (xn + val/xn)


sqrt:
	l.d $f4, k1	#xn = 1.0
	li $t0, 0 	#i = 0
	l.d $f6, k2	#f6 = 0.0
if:
	c.le.d $f12, $f6
	bc1t else
	
do:
	mov.d $f2, $f4
	div.d $f8 $f12, $f4 #val/xn
	add.d $f8 $f4, $f8	#xn + val/xn
	l.d $f10, k3
	mul.d $f4, $f10, $f8	#0.5*(xn + val/xn)
	
while:
	c.eq.d $f2, $f4
	bc1t endif
	addi $t0, $t0, 1
	bge $t0, 25, endif
	j do
else:
	l.d $f4, k2
	
endif:
	mov.d $f0, $f4
	jr $ra

	
	

	
