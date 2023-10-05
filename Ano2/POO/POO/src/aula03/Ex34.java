package aula03;
import java.util.Scanner;

public class Ex34 {
    public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    double total = 1, media, sum = 0;
    
    System.out.println("Insira uma cadeia de números reais, terminando quando inserir o primeiro número pela segunda vez!");
    double number = sc.nextDouble();
    double max = number, min = number, N;
        
    do{
        N = sc.nextDouble();
        if(N > max){
            max = N;
        }
        if( N < min){
            min = N;
        }
        total++;
        sum += N;
        

        
    }while(N != number);
    sc.close();
    media = sum/total;
    System.out.println("Valor máximo: "+max
                        +"\nValor mínimo: "+min
                        +"\nMédia: "+media
                        +"\nTotalidade de números: "+total);

    }
    
}
