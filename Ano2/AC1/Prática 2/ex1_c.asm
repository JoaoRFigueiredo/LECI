.data
.text
.globl main 

#objetivo: executar negação bit a bit

main: ori $t0,$0,0xE543  #$t0 = valor indicado (2º operando)
	nor $t1, $t0, $0
	jr $ra #fim do programa