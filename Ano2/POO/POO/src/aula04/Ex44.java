package aula04;
import java.util.Scanner;
public class Ex44 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        int[] values = readValues();
        int diasMes = daysMonth(values[0], values[1]);
        display(values[0], values[1], diasMes, values[2]);


    }

    public static int[] readValues(){
         Scanner sc = new Scanner(System.in);
        
        System.out.println("Insira o mês: ");
        int mes = sc.nextInt();
        System.out.println("Insira o ano: ");
        int ano = sc.nextInt();
        System.out.println("Insira o dia da semana: ");
        int dia = sc.nextInt();
        sc.close();
        int[] values = {mes, ano, dia};
        return values;

    }

    public static int daysMonth(int mes, int ano){
        int dias;
        switch(mes){
            case 4:
            case 6:
            case 9:
            case 11:
                dias = 30;
                break;
            case 2:
                if((ano % 4 == 0 && ano %100 != 0) || (ano % 400 == 0)){
                    dias = 29;
    
                }
                else{
                    dias = 28;
                }
                break;
            default:
                dias = 31;
                break;
        }
        return dias;
    }

    public static void display(int mes, int ano, int diasMes, int dia){
        String[] meses = {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};
        System.out.println("\t\t\t"+meses[mes-1]+" "+ano);
        System.out.println("Su\tMo\tTu\tWe\tTh\tFr\tSa");
        int d = 1;
        
        for (int l = 0; l<6; l++){//percorrer as linhas do calendário
            System.out.println();
            
            for (int c = 0; c<7; c++){//percorrer as colunas do calendário
            
                if((l == 0 && c < dia%7 ) || (l>0 && d > diasMes)){
                    System.out.printf("%s\t", " ");
                }
                else{
                    System.out.printf("%d\t", d);
                    d++;
                }

                 
                 
        }
        
        
        
        }
    }
}
    

