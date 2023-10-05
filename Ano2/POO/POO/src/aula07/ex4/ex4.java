package aula07.ex4;
import java.util.Scanner;
public class ex4 {
    static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Equipa slb = makeBenfica();
		Equipa fcp = makePorto();
		Robo jonas = new Robo(0, 5, 27, 10, "Jonas", "Avançado");
		Robo marega = new Robo(0, 5, 27, 11, "Marega", "Avançado");
		slb.addjogador(jonas);
		fcp.addjogador(marega);
		Jogo jg = new Jogo(slb,fcp, new Bola(0,0,60), 25);
		
		jg.start();
		System.out.println(jg);
		System.out.println("---------------");
		esperar(jg);
		jg.golo1(10);
		System.out.println(jg);
		System.out.println("---------------");
		esperar(jg);
		marega.move(20, 40);
		jg.golo2(33);
		System.out.println(jg);
		System.out.println("---------------");
		esperar(jg);
		jonas.move(50, 20);
		jg.golo1(10);
		jg.golo1(21);
		System.out.println(jg);
		System.out.println("---------------");
		esperar(jg);
		jg.golo2(11);
		System.out.println(jg);
		System.out.println("---------------");
		
		
		
	}
	
	public static Equipa makeBenfica() {
		Equipa slb = new Equipa("Benfica", "Bruno Lage");
		Robo r4 = new Robo(0, 5, 28, 99, "Odyseas", "GuardaRedes");
		Robo r3 = new Robo(0, 5, 28, 33, "Jardel", "Defesa");
		Robo r2 = new Robo(0, 5, 28.5, 21, "Pizzi", "Médio");
		slb.addjogador(r2);
		slb.addjogador(r3);
		slb.addjogador(r4);
		return slb;
	}
	
	public static Equipa makePorto() {
		Equipa fcp = new Equipa("Porto", "Sérgio Conceição");
		Robo r4 = new Robo(0, 5, 28, 1, "Casillas", "GuardaRedes");
		Robo r3 = new Robo(0, 5, 28, 33, "Pepe", "Defesa");
		Robo r2 = new Robo(0, 5, 28.5, 22, "Danilo", "Médio");
		fcp.addjogador(r2);
		fcp.addjogador(r3);
		fcp.addjogador(r4);
		return fcp;
	}
	
	public static void esperar(Jogo jg) {
		String s;
		do {
			System.out.println("Continuar? (s)");
			s = sc.nextLine();
		}while(!s.equals("s"));
		jg.update();
	}
}
