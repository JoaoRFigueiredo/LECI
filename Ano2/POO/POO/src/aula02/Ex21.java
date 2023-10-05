package aula02;
import java.util.Scanner;
public class Ex21 {
     public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
       double distancia; 
       System.out.println("Insira uma distância(km): ");
       distancia = sc.nextDouble();
       System.out.println("Distancia em km --> "+distancia+"\nDistancia em milhas -->"+distancia/1.609 );
       sc.close();

     }
}

