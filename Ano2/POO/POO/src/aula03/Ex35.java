package aula03;
import java.util.Scanner;

public class Ex35 {
    public static void main(String[] args){
        double montante, taxa;
        Scanner sc = new Scanner(System.in);
        do{
        System.out.println("Insira o montante(positivo e múltiplo de 1000)");
        montante = sc.nextDouble();
        System.out.println("Insira a taxa de juros(percentagem, entre 0 e 5)");
        taxa = sc.nextDouble();
        }while( (montante < 0) && (montante % 1000 != 0) && (taxa < 0) && (taxa > 5));

        for(int i = 0; i< 12; i++){
            montante = montante+ montante*(taxa/100);
            System.out.printf("Após %d meses terá o %.3f euros\n", i+1,  montante);
        }

        

     sc.close();
    }
    
}
