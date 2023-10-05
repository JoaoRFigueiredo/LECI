package aula04;
import java.util.Scanner;
public class Ex43 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Insira um frase: ");
        String frase = sc.nextLine();
        sc.close();
        String acronimo = acronimo(frase);
        System.out.printf("Acrónimo: %s",acronimo);
        
    }

    public static String acronimo(String str){
        String[] arr = str.split("\\s+?");
        String acron = "";
        for(int i = 0; i<arr.length; i++){
            if(arr[i].length() >3){
                acron += arr[i].charAt(0);
            }
        }
        return acron;
    }
    
}
