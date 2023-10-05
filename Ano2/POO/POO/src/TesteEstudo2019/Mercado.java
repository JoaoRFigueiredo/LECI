import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Mercado {
	private Set<Tenda> tendas;
	private String nome;
	private String endereço;
	
	public Mercado(String nome, String endereço, Set<Tenda> tendas) {
		this.nome=nome; this.endereço=endereço; this.tendas=tendas;
	}
	public Mercado(String nome, String endereço) {
		this(nome, endereço, new HashSet<>());
	}
	public Set<Tenda> tendas() {
		return tendas;
	}
	public String getNome() {
		return nome;
	}
	public String getEndereço() {
		return endereço;
	}
	
	@Override
	public String toString() {
		return "Mercado "+nome+"\nTendas: ["+tendas+"]";
	}
	public void add(Tenda t) {
		tendas.add(t);
	}
	
	public int totalItems() {
		int p=0;
		for(Tenda t: tendas) {
			p += t.totalProdutos();
		}
		return p;
	}
	
	public ArrayList<String> getAllItems(){
		ArrayList<String> total = new ArrayList<>();
		for(Tenda t: tendas) {
			for(String s: t.items()) {
				total.add(s);
			}
		}
		total.sort((a, b) -> a.compareToIgnoreCase(b));
		return total;
	}

}
