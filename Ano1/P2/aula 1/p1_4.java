import java.util.*;

public class p1_4 {
	
	static Scanner sc = new Scanner(System.in);
	public static void main (String[] args) {
		System.out.println("linha: ");
		String linha = sc.nextLine();
		String linha1 = linha.toLowerCase();
		System.out.println("So com minisculas: "+linha1);
		
		String linha2 = linha1.replace("r", "");
		String linha3 = linha2.replace("l", "u");
		System.out.println("Com a substituicao dos caracteres feita: "+linha3);
	
		
		
		
	
	}
}

