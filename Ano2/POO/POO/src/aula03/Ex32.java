package aula03;
import java.util.Scanner;
public class Ex32 {
    public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    System.out.print("Insira um número positivo à sua escolha: ");
    int number = sc.nextInt();
    do{
        System.out.println(number);
        number--;

    }while(number >= 0);
    
    sc.close();
    
}
}
