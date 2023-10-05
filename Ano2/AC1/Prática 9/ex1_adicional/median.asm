.data
.eqv true, 1
.eqv false, 0

.text
.globl median


median:
	move $t0, $a0	#t0 = array
	move $t1, $a1	#t1 = nval

do:
	li $t2, false	#houvetroca = 0
	li $t3, 0
	addi $t4, $t1, -1
	sll $t4, $t4, 3
for:	bge $t3, $t4, endfor
	addu $t5, $t3, $t0
	l.d $f2, 0($t5)
	l.d $f4, 8($t5)

if:
	c.le.d $f2, $f4
	bc1t endif
	mov.d $f6, $f2
	s.d $f4, 0($t5)
	s.d $f6, 8($t5)
	li $t2, true
	
endif:
	addi $t3, $t3, 8
	j for
endfor:
	
while: beq $t2, true, do
	
	rem $t8, $t1, 2

if2:	beqz $t8, endif2
	addi $t1, $t1, 1
endif2:
	sll $t1, $t1, 3
	srl $t1, $t1, 1
	addu $t6, $t1, $t0
	l.d $f0, 0($t6)
	jr $ra







































	
	
