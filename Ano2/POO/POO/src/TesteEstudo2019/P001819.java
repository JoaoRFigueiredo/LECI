import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Notas:
// Não altere o código apresentado
// Deve completar o código da alinea 2
// Deve comentar o código para garantir que vai executando parcialmente

public class P001819 {

	public static void main(String[] args) throws FileNotFoundException {
		PrintStream fl = new PrintStream(new File("POO_1819IN.txt"));
		test(System.out); // executa e escreve na consola
		test(fl); // executa e escreve no ficheiro
		fl.close();
	}

	private static void test(PrintStream out) {
		alinea1(out);
		try {
			alinea2(out);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void alinea1(PrintStream out) {
		out.println("\nAlínea 1) ----------------------------------\n");

		Mercado mercado = new Mercado("O Festival de Petiscos", "Aveiro");

		Bar exp1 = new Bar(102, "MorroDeSede");
		exp1.add(new Bebida("Vinho Branco", 11.5));
		exp1.add(new Bebida("Sumo", 0));
		exp1.add(new Bebida("Infusao", 0));
		exp1.add(new Bebida("Cerveja", 6.3));
		out.println(exp1.getNome() + " tem " + exp1.getLista().size() + " bebidas");
		
		List<Bebida> lista = new ArrayList<>();
		lista.add(new Bebida("Limonada", 0));
		lista.add(new Bebida("Cerveja Trigo", 5.5));
		lista.add(new Bebida("Cerveja IPA", 7.5));
		Bar exp2 = new Bar(100, "PubOO", lista);
		out.println(exp2.getNome() + " tem " + exp2.totalProdutos() + " bebidas");

		Tasquinha pst1 = new Tasquinha(201, "So_Leitao", new String[] {"Sandocha", "PicaPica"} );
		Tasquinha pst2 = new Tasquinha(202, "A_Chicha" );
		pst2.addPrato("Assinhas"); pst2.addPrato("Amburguere");
		
		mercado.add(exp1); mercado.add(exp2); mercado.add(pst1); mercado.add(pst2);
	
		out.println("PRODUTOS DE " + exp1.getNome() + ": " + exp1.items());
		out.println("PRODUTOS DE " + pst1.getNome() + ": " + pst1.items());
		out.println("PRODUTOS DE " + pst2.getNome() + ": " + pst1.items());
		
		out.println("MERCADO: " + mercado);	
		out.println("TOTAL DE PRODUTOS DO MERCADO: " + mercado.totalItems());
			// devolve o numero de produtos disponiveis no mercado - em todas as tendas

	}

	private static void alinea2(PrintStream out) throws IOException {
		out.println("\nAlínea 2) ----------------------------------\n");
		Mercado fest = null;

		// Adicione a seguir o código necessário para a leitura do ficheiro 

		List<String> lines = Files.readAllLines(Paths.get("uafest.txt"));

		String[] cabeçalho = lines.get(0).split(";");
		fest = new Mercado(cabeçalho[0], cabeçalho[1]);
		
		for (int i=1;i<lines.size();i++) {
			String[] params = lines.get(i).split(";");
			if(params[0].equals("1")) {
				fest.add(new Bar(Integer.parseInt(params[1]), params[2]));
			} else if(params[0].equals("2")) {
				fest.add(new Tasquinha(Integer.parseInt(params[1]), params[2], Arrays.copyOfRange(params, 3, params.length)));
			} else {
			}
		}


        // não modifique o metodo a partir daqui. Pode comentar para executar o programa

		if (fest != null) {
			
			out.println("MERCADO: " + fest);
			for (Tenda s: fest.tendas())  // devolve o conjunto de todas as tendas
				out.println(s); 
				out.println("-- LISTA DE PRODUTOS DO MERCADO --");	
			for (String s: fest.getAllItems())  // devolve todos os produtos distintos do mercado, ordenados
				out.print(s+", "); 
				out.println();
	 }
	}

}
