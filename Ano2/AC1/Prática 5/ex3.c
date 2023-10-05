/******************************************************************************

                            Online C Compiler.
                Code, Compile, Run and Debug C program online.
Write your code in this editor and press "Run" button to compile and execute it.

*******************************************************************************/

#include <stdio.h>

#define SIZE 10
#define TRUE 1
#define FALSE 0
void main(void)
{
 static int lista[SIZE];
 int houveTroca, i, aux;
 int *p;
 p = lista;
 // inserir aqui o código para leitura de valores e
 // preenchimento do array
 for(p = lista; p<lista+SIZE; p++)
 {
 printf("\nIntroduza um número: ");
 scanf("%d", p);
 
 }
 do
 {
 houveTroca = FALSE;
 for (i=0; i < SIZE-1; i++)
 {
 if (lista[i] > lista[i+1])
 {
 aux = lista[i];
 lista[i] = lista[i+1];
 lista[i+1] = aux;
 houveTroca = TRUE;
 }
 }
 } while (houveTroca==TRUE);
 // inserir aqui o código de impressão do conteúdo do array
 printf("Conteudo do array: ");
 for(i = 0; i<SIZE; i++)
 {
    printf("%d; ", lista[i]);
 }
} 
