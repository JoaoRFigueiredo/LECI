package aula03;
import java.util.Scanner;

public class Ex37 {
    public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int random ;
    String resposta;
    int guess, attempts;
    
    do{
        System.out.println("Tente adivinhar o número(1-100): ");
        random = (int)(Math.random()*100) + 1;
        attempts = 0;
        do{
            guess = sc.nextInt();
            attempts++;
            if(guess > random){
                System.out.println("A sua tentativa é demasidado alta");
            }
            else if(guess < random){
                System.out.println("A sua tentativa é demasiado baixa");
            }

        }while(guess != random);
        System.out.printf("\nApós %d tentativas, consegui acertar!", attempts);
        System.out.println("Deseja jogar outra vez?");
        resposta = sc.next();
    }while(resposta.equals("S") || resposta.equals("Sim"));
    sc.close();

    }
    
}
