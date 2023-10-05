package aula05;
import java.util.Scanner;
public class Ex52 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Callendar c = new Callendar(7, 2022);
        int option;
        System.out.println("Calendar operations: "
                        +"\n1 - Create new callendar;"
                        +"\n2 - Print callednar month"
                        +"\n3 - Print yearly calendar"
                        +"\n0 - Exit");

        while(true){
            option=sc.nextInt();

            switch(option){
                case 1:
                sc.nextLine();
                System.out.println("Insira o primeiro dia da semana:");
                int newDay = sc.nextInt();
                System.out.println("Insira o ano: ");
                int ano = sc.nextInt();
                c.setWeekDay(newDay);
                c.setYear(ano);

                break;

                case 2:
                    System.out.println("De que mês, deseja imprimir um calendário?");
                    sc.nextLine();
                    int mes = sc.nextInt();
                    c.displayCallendarMonth(mes);
                    break;

                case 3:
                    for (int i = 0; i<12; i++){
                        c.displayCallendarMonth(i+1);
                        System.out.println();
                    }

                    break;

                    default:
                    break;

            }

            if(option == 4){
                break;
            }
        }
        sc.close();
    }
    
}
