package aula02;
import java.util.Scanner;

public class Ex27 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        double x1, x2, y1, y2;
        System.out.println("Insira as cordenadas do ponto1 (x1, y1)");
        System.out.println("Insira x1:");
        x1 = sc.nextDouble();
        System.out.println("Insira y1:");
        y1 = sc.nextDouble();

        System.out.println("Insira as cordenadas do ponto2 (x2, y2)");
        System.out.println("Insira x2:");
        x2 = sc.nextDouble();
        System.out.println("Insira y2:");
        y2 = sc.nextDouble();

        double distancia = Math.sqrt(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2) );
        System.out.println("Distancia entre p1 e p2 é igual a "+distancia);
        sc.close();
    }
    
}
