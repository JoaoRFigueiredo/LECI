import java.util.*;

public class operacoes {
	
	static Scanner sc = new Scanner(System.in);
	public static void main (String[] args) {
		int operacao;
		double a, b, c;
		System.out.println("Insira dois numeros.");
		a = sc.nextDouble();
		b = sc.nextDouble();
		System.out.println("1-Adicao");
		System.out.println("2-Subtracao");
		System.out.println("3-Multiplicacao");
		System.out.println("4-Divisao");
		System.out.println("Que operacao deseja fazer?");
		operacao = sc.nextInt();
		switch(operacao){
			case 1:
			c = a + b;
			System.out.printf("%.2f + %.2f = %.2f", a, b, c);
			break;
			
			case 2:
			c = a-b;
			System.out.printf("%.2f - %.2f = %.2f", a, b, c );
			break;
			
			case 3:
			c = a*b;
			System.out.printf("%.2f * %.2f = %.2f", a, b, c );
			break;
			
			case 4:
			c = a/ b;
			System.out.printf("%.2f / %.2f = %.2f", a, b, c);
			break;
		}
		
		
	}
	
	
	
}

