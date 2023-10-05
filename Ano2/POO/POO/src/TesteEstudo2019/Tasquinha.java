
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Tasquinha extends Tenda {
	private Set<String> set;

	public Tasquinha(int num, String nome, String[] array) {
		super(num, nome);
		this.set=new HashSet<>();
		for(String s: array) {
			addPrato(s);
		}
	}
	public Tasquinha(int num, String nome) {
		super(num,nome);
		this.set=new HashSet<>();
	}
	
	public Set<String> getSet() {
		return set;
	}
	public void addPrato(String p) {
		this.set.add(p);
	}
	public int totalProdutos() {
		return this.set.size();
	}
	
	@Override
	public Collection<String> items() {
		return set;
	}

}
