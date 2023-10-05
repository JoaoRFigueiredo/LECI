package aula02;
import java.util.Scanner;

public class Ex28 {
    public static void main(String[] arsg){
        double a, b, c, angulo;
        Scanner sc = new Scanner(System.in);
        System.out.println("Insira o valor do cateto a:");
        a = sc.nextDouble();
        System.out.println("Insira o valor do cateto b:");
        b = sc.nextDouble();
        c = Math.sqrt(Math.pow(a,2) + Math.pow(b, 2));
        System.out.printf("\nHipotenusa = %.3f cm ", c);
        angulo = Math.asin(b/c);
        angulo = Math.toDegrees(angulo);
        System.out.printf("\nAngulo entre cateto 'a' e hipotenusa = %.3f graus", angulo);
        sc.close();

    }
    
}
