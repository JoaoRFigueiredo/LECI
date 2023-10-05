package aula02;
import java.util.Scanner;
public class Ex26 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int segundos, horas , minutos ;
        System.out.println("Insira um valor temporal(segundos):");
        int valor = sc.nextInt();

        horas = valor/3600;
        minutos = (valor/60)%60;
        segundos = valor%60;
        
        System.out.printf("%d:%d:%d", horas, minutos, segundos);
        sc.close();
        

    }
    
}
