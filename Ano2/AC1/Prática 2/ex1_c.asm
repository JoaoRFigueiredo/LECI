.data
.text
.globl main 

#objetivo: executar nega��o bit a bit

main: ori $t0,$0,0xE543  #$t0 = valor indicado (2� operando)
	nor $t1, $t0, $0
	jr $ra #fim do programa