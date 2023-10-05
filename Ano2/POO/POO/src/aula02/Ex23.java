package aula02;
import java.util.Scanner;


public class Ex23 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        double agua, Tinicial, Tfinal, energia;
        System.out.println("Insira os valores da água(Quilogramas), temperatura inicial(Celsius), temperatura final(Celsius), todos separados por um espaço");
        String valores = sc.nextLine();
        String[] arr = valores.split(" ");
        agua = Double.parseDouble(arr[0]);
        Tinicial = Double.parseDouble(arr[1]);
        Tfinal = Double.parseDouble(arr[2]);
        energia = agua * (Tfinal - Tinicial)*4184;
        System.out.printf("Será necessária a seguinte energia %.3f joules", energia);
        sc.close();
    }
}
