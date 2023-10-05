import java.util.Stack;
import java.util.Scanner;


public class ex3 {

private static Stack<Double> pilha = new Stack<>();

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        while(sc.hasNext()){

            if (sc.hasNextDouble()){
                double d = sc.nextDouble();
                pilha.push(d);
                printStack(pilha);
            }

            else if (sc.hasNext("[-+*/]") ){
                if (pilha.size() < 2){
                    error("Error: one operand missing!");
                }
                String op = sc.next();
                double op2 = pilha.pop();
                double op1 = pilha.pop();
                double result = 0;
                switch(op){
                    case "+":
                    result = op1 + op2;
                    break;

                    case "-":
                    result = op1 - op2;
                    break;

                    case "*":
                    result = op1 * op2;
                    break;

                    case "/":
                    result = op1 / op2;
                    break;

                }
                pilha.push(result);
                printStack(pilha);
            }
            
            
            
        }

        sc.close();

    }

    public static void error(String message){
        System.err.println(message);
        System.exit(0);
    }


    public static void printStack(Stack<Double> st){
        System.out.println("Stack: "+st);
    }
    
}
