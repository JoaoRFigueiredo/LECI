package aula02;

import java.util.Scanner;
public class Ex22 {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        double temp;
        System.out.println("Insira um valor de temperatura(Celsius): ");
        temp = sc.nextDouble();
        System.out.printf("Temperatura = %.2f ºC = %.2f ºF", temp, 1.8*temp + 32);
        sc.close();
    }
    
}
