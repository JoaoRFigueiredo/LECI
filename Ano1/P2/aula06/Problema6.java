/*  Aula 6 - Recursividade
 *  NMEC: 		NOME:
 *  
 *  Descubra o que faz a função F, implementada de forma iterativa. 
 *  Determine o caso base para o problema e a relação de recursividade
 *  de forma a implementar a função H de forma recursiva.
 * 
 */
import java.util.*;
import java.lang.*;
public class Problema6 {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Uso: java -ea Problema6  <n>");
            System.exit(1);
        }
        int n = Integer.parseInt(args[0]);

        System.out.printf("F(%d) = %f\n", n, F(n));
        System.out.printf("H(%d) = %f\n", n, H(n));
        System.out.printf("fatorial(%d) = %d\n", n, fact(n));
    }

    // O que faz a função F?
    public static double F(int n) {
        assert n >= 1;
        double r = 1.0;
        for (int i = 2; i <= n; i++) {
            r += 1.0/i;
        }
        return r;
    }

    // Implementação recursiva da função: ?
    // caso base: ?
    // relação de recursividade: ?
    // somatorio( 1 a infinito) de 1/n
    public static double H(int n) {
       if (n == 1) return 1;
        return (1/n + H(n-1));
}

static int fact(int n)
{
    if (n <= 1) // base case
        return 1;
    else    
        return n*fact(n-1);    
}

}
