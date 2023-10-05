import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

// Notas:
// Não altere o código apresentado na alinea 1
// Deve completar o código das alineas 2 e 3
// Pode comentar código para garantir que vai executando parcialmente

public class PDS2021 {

	public static void main(String[] args) throws FileNotFoundException {
		PrintStream fl = new PrintStream(new File("pds2021.txt"));
		test(System.out); // executa e escreve na consola
		fl.println(System.getProperty("user.dir"));
		test(fl); // executa e escreve no ficheiro
		fl.close();
	}

	private static void test(PrintStream out) {
		//alinea1(out);
		
		alinea2(out);
		/*
		alinea3(out);
		*/
	}

	private static void alinea1(PrintStream out) {
		out.println("\nAlínea 1) ----------------------------------\n");
		BasicCamperService onwheels = new BasicCamperService();

		Cliente c1 = new Cliente("Marco Silva", "Setúbal", 32);
		Cliente c2 = new Cliente("Joana Inácio", "Viseu", 54);
		Cliente c3 = new Cliente("Carolina Marques", "Vila Real", 27);
		Cliente c4 = new Cliente("Telmo Sousa", "Coimbra", 51);

		ICamper h1 = onwheels.registaCamper(4, "MotorHome com quatro lugares, 3 camas, cozinha, mesa, WC.");
		ICamper h2 = onwheels.registaCamper(4, "Camper van com quatro lugares, 2 camas, mesa.");
		ICamper h3 = onwheels.registaCamper(2, "Camper van com dois lugares, 1 cama, cozinha, mesa, WC.");
		ICamper h4 = onwheels.registaCamper(2, "Tenda de tejadilho para duas pessoas, de montagem rápida.");

		out.println("\n--- Campers disponíveis :" );

		for (ICamper camper : onwheels.getCampersDisponiveis())
			out.println(camper);
		out.println("\n" );
		
		out.println(onwheels.registaAluguer(c1, h1));
		out.println(onwheels.registaAluguer(c2, h3));

		out.println("\n--- Campers disponíveis :" );
		for (ICamper camper : onwheels.getCampersDisponiveis())
			out.println(camper);	
		out.println("\n" );

		out.println(onwheels.terminaAluguer(c1, h1));

		out.println("\n--- Campers disponíveis :" );
		for (ICamper camper : onwheels.getCampersDisponiveis())
			out.println(camper);
		out.println("\n" );

	}


	private static void alinea2(PrintStream out) {
		out.println("\n\nAlínea 2 (exemplo de output) ----------------------------------\n");
		CamperService broker = new CamperService();
		//Create 4 owners
		Owner o1 = new Owner("Manuel Silva", "Setúbal", 32);
		Owner o2 = new Owner("Joaquim Inácio", "Viseu", 54);
		Owner o3 = new Owner("Carmim Marques", "Vila Real", 27);
		Owner o4 = new Owner("Teresa Sousa", "Coimbra", 51);

		//Create 4 Clientes
		Cliente c1 = new Cliente("Marco Silva", "Setúbal", 32);
		Cliente c2 = new Cliente("Joana Inácio", "Viseu", 54);
		Cliente c3 = new Cliente("Carolina Marques", "Vila Real", 27);
		Cliente c4 = new Cliente("Telmo Sousa", "Coimbra", 51);

		//Create 4 campers
		ICamper h1 = broker.registaCamper(o1 ,4, "MotorHome com quatro lugares, 3 camas, cozinha, mesa, WC.");
		ICamper h2 = broker.registaCamper(o2 ,4, "Camper van com quatro lugares, 2 camas, mesa.");
		ICamper h3 = broker.registaCamper(o3 ,2, "Camper van com dois lugares, 1 cama, cozinha, mesa, WC.");
		ICamper h4 = broker.registaCamper(o4 ,2, "Tenda de tejadilho para duas pessoas, de montagem rápida.");

		out.println("\n--- Campers disponíveis :" );

		for (ICamper camper : broker.getCampersDisponiveis())
			out.println(camper);
		out.println("\n" );

		//Create 4 Pedido
		String p1 = broker.registaPedido(c1, h1);
		String p2 = broker.registaPedido(c2, h3);
		String p3 = broker.registaPedido(c3, h4);
		String p4 = broker.registaPedido(c4, h2);

		out.println("\n--- Pedidos :" );
		//print pedidos
		out.println(p1);
		out.println(p2);
		out.println(p3);
		out.println(p4);


		out.println();


		//Aceita p1, p2 e p3
		out.println(broker.aceitaPedido(c1, h1));
		out.println(broker.aceitaPedido(c2, h2));
		out.println(broker.aceitaPedido(c3, h3));

		//Rejeita p4
		out.println(broker.rejeitaPedido(c4, h4));

		out.println("\n--- Campers disponíveis :" );

		for (ICamper camper : broker.getCampersDisponiveis())
			out.println(camper);
		out.println("\n" );

		//Devolve p1
		out.println(broker.registaDevolucao(c1, h1));

		out.println("\n--- Campers disponíveis :" );

		for (ICamper camper : broker.getCampersDisponiveis())
			out.println(camper);
		out.println("\n" );

	}
	
	/*
	private static void alinea3(PrintStream out) {
		out.println("\n\nAlínea 3) ----------------------------------\n");
		// Completar
	}
*/
}
