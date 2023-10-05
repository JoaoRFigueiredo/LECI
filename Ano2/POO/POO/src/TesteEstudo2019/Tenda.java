import java.util.Collection;

public abstract class Tenda implements Expositor{
	private int num;
	private String nome;

	public Tenda(int num, String nome) {
		this.num=num; this.nome=nome;
	}

	public int getNum() {
		return num;
	}

	public String getNome() {
		return nome;
	}

	@Override
	public String toString() {
		return "Tenda [num=" + num + ", nome=" + nome + "]";
	}

	@Override
	public Collection<String> items() {
		return null;
	}
	
	public abstract int totalProdutos();

}
