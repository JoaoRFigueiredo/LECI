package aula04;
import java.util.Scanner;


public class Ex42 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Insira uma string: ");
        String frase = sc.nextLine();
        sc.close();
        System.out.println("Número de dígitos na string: "+countDigits(frase));
        System.out.println("Número de espaços na string: "+countSpaces(frase));
        System.out.println("Possui só mínusculas? "+lower(frase));
        System.out.println("Retiando todos os espaços a mais: "+replaceMultipleSpaces(frase));
        System.out.println("É um palíndromo? "+palindromo(frase));

    }


    public static int countDigits(String str){
        int count = 0;
        for (int i = 0; i< str.length(); i++){
            if(Character.isDigit(str.charAt(i))){
                count++;

            }
        }
        return count;
    }

    public static int countSpaces(String str){
        int count = 0;
        for (int i = 0; i< str.length(); i++){
            if(Character.isWhitespace(str.charAt(i))){
                count++;

            }
        }
        return count;
    }

    public static boolean lower(String str){
        boolean min = true;
        for ( int i = 0; i< str.length(); i++){
            if (!Character.isLowerCase(str.charAt(i))){
                min = false;
                break;
            }
        }
        return min;
    }

    public static String replaceMultipleSpaces(String str){
        String ans = str.replaceAll("\\s+", " ");
        ans = ans.trim();
        return ans;

    }

    public static boolean palindromo(String str){
        str = replaceMultipleSpaces(str);
        str = str.toLowerCase();
        boolean check = true;
        int half = str.length()/2;
        char[] arr1 = str.toCharArray();
        for (int i = 0, j = arr1.length-1; i<half && (str.length()%2 == 0 ? j>= half : j < half); i++, j--){
            if(arr1[i] != arr1[j]){
                check = false;
            }
        }
        return check;


    }
}
