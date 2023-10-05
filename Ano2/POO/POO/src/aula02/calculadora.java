package aula02;
import java.util.Scanner;

public class calculadora {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Eis uma mini-calculadora!");
        System.out.println("Insere 2 operandos e 1 operador no seguinte formato: operando1 operador operando2");
        String str = sc.nextLine();
        String[] arr = str.split(" ");
        double op1 = Double.parseDouble(arr[0]);
        double op2 = Double.parseDouble(arr[2]);
        char operador = arr[1].charAt(0);
        double resultado = 0;

        switch (operador){
            case '+':
            resultado = op1 + op2;
            break;

            case '-':
            resultado = op1 - op2;
            break;

            case '/' :
            case ':':
            resultado = op1 / op2;
            break;

            case 'x':
            case '*':
            resultado = op1 * op2;
            break;
        }

        System.out.printf("\nResultado = %.3f", resultado);
        sc.close();
    }
    
}
