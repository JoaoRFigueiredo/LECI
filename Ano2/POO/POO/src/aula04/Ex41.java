package aula04;
import java.util.Scanner;
public class Ex41 {
    public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    String frase = sc.nextLine();
    sc.close();
    String f1 = frase.toLowerCase();
    char last = frase.charAt(f1.length()-1);
    String f2 = frase.substring(0, 3);
    System.out.println(f1);
    System.out.println(last);
    System.out.println(f2);
    System.out.println(frase.equals("universidade de aveiro"));
    System.out.println(frase.compareTo("universidade de aveiro"));
    System.out.println(frase.contains("xpto"));
    }
    
}
