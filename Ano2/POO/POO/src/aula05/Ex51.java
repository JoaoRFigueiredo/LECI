package aula05;
import java.util.Scanner;
public class Ex51 {
    public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int option;
    Date d1 = new Date();
    while(true){
    
    System.out.println("Date operations:\n1 - Create new Date"+
    "\n2 - Show current Date;"+
    "\n3 - increment Date;"+
    "\n4 - decrement Date;"+
    "\n0 - exit");
    System.out.println();
    option = sc.nextInt();
   
    switch(option){
        //create date
        case 1:
       
            System.out.println("Define a nova data (day-month-year): ");
            sc.nextLine();
            String data = sc.nextLine();
            String[] arr = data.split("-");
            d1 = new Date(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]), Integer.parseInt(arr[2]));
        break;
        //show current date
        case 2:
        System.out.println("\n"+d1);
        break;
        case 3:
        System.out.println("Quantos dias deseja avançar?");
        sc.nextLine();
        int frente = sc.nextInt();
        for(int i = 0; i<frente; i++){
        d1.increment();
        }  
        break;

        case 4:
        System.out.println("Quantos dias deseja recuar?");
        sc.nextLine();
        int atras = sc.nextInt();
        for(int i = 0; i<atras; i++){
        d1.decrement();
        }
        break;

        default :
        break;
    }
    if(option == 0){
        break;
    }
    
        
    
}
sc.close();

}

}
