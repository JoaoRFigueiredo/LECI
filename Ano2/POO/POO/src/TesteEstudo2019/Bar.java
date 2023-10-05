

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Bar extends Tenda {
	private List<Bebida> lista;

	public Bar(int num, String nome, List<Bebida> lista) {
		super(num, nome);
		this.lista=lista;
	}
	public Bar(int num, String nome) {
		this(num, nome, new ArrayList<>());
	}
	
	public List<Bebida> getLista() {
		return lista;
	}
	
	public void add(Bebida b) {
		this.lista.add(b);
	}
	public int totalProdutos() {
		return this.lista.size();
	}
	
	@Override
	public Collection<String> items() {
		ArrayList<String> newlist = new ArrayList<>();
		for(Bebida b: this.lista) {
			newlist.add(b.toString());
		}
		return newlist;
	}

}
