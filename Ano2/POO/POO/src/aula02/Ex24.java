package aula02;
import java.util.Scanner;

public class Ex24 {
    public static void main(String[] args){
        double montante, taxa;
        Scanner sc = new Scanner(System.in);
        System.out.println("Insira o montante");
        montante = sc.nextDouble();
        System.out.println("Insira a taxa de juros(percentagem)");
        taxa = sc.nextDouble();

        for(int i = 0; i< 3; i++){
            montante = montante+ montante*(taxa/100);
        }

        System.out.printf("Após 3 meses terá o %.3f euros", montante);

     sc.close();
    }
    
}
