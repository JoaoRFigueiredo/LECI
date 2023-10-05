package aula03;
import java.util.Scanner;
public class Ex36 {
    public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int  mes, ano;
    
    do{
    System.out.println("Insira uma data (mes-ano)");
    String data = sc.nextLine();
    String[] arr = data.split("-");
    mes = Integer.parseInt(arr[0]);
    ano = Integer.parseInt(arr[1]);
    }while( (mes <1 || mes > 12) && (ano < 0));
    sc.close();
    switch(mes){
        case 4:
        case 6:
        case 9:
        case 11:
            System.out.println("Este mês tem 30 dias");
            break;
        case 2:
            if((ano % 4 == 0 && ano %100 != 0) || (ano % 400 == 0)){
                System.out.println("Este mês tem 29 dias!");

            }
            else{
                System.out.println("Este mês tem 28 dias!");
            }
            break;
        default:
            System.out.println("Este mês tem 31 dias!");
            break;
    }
    }
    
}
