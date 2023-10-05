package aula02;
import java.util.Scanner;

public class Ex25 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        double v1, v2, d1, d2;
        System.out.println("Insira a primeira velocidade(km/h): ");
        v1 = sc.nextDouble();
        System.out.println("Insira a primeira distância(km): ");
        d1 = sc.nextDouble();
        System.out.println("Insira a segunda velocidade(km/h): ");
        v2 = sc.nextDouble();
        System.out.println("Insira a segunda distância(km): ");
        d2 = sc.nextDouble();
        double dt = d1+d2;//distancia total
        double t1, t2;
        t1 = d1/v1;
        t2 = d2/v2;

        System.out.println("A velocidade média final foi de "+ dt/(t1+t2)+" km/h" );
        sc.close();



    }
    
}
