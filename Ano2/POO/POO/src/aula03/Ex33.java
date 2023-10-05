package aula03;
import java.util.Scanner;
public class Ex33 {

    public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int number, count = 0;
    while(true){
    System.out.print("Insira um número inteiro positivo: ");
    number = sc.nextInt();
    if (number > 0){
        break;
    }
    System.out.println(number+" não é um número inteiro positivo! \nInsira o número outra vez!");
    }
    int num = number;
   do{
       if(number % num == 0){
           count++;
       }
       num--;

   }while(num > 0);
   //System.out.println(count);
   System.out.println((count == 2) ? "É um número primo!" : "Não é um número primo!");
   sc.close();
    }

    }
    

