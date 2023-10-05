import java.util.*;

public class ex1 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Operation (number or operand): ");
        double op1 = 0, op2 = 0, result = 0;
        String op = "";
        
        if(!sc.hasNextDouble()){
            System.err.println("Wrong element, should have been a number!");
            System.exit(1);
        }

        op1 = sc.nextDouble();

        op = sc.next();


        if(!sc.hasNextDouble()){
            System.err.println("Wrong element, should have been a number!");
            System.exit(1);
        }

        op2 = sc.nextDouble();
        

        

        switch (op){

            case "+":
            result = op1+op2;
            break;

            case "-":
            result = op1-op2;
            break;

            case "*":
            result = op1*op2;
            break;

            case "/":
            result = op1/op2;
            break;

            default:
            System.err.println("Wrong operand: "+op);
            System.exit(1);
            break;


        }

        System.out.printf("%.5f %s %.5f = %.5f\n", op1, op, op2, result);
        
        
        sc.close();
    }
    
}
