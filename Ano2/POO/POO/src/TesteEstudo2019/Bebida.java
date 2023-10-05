
public class Bebida {
	private String nome;
	private double teorAlc;
	
	public Bebida(String nome, double teorAlc) {
		this.nome=nome; this.teorAlc=teorAlc;
	}

	public String getNome() {
		return nome;
	}

	public double getTeorAlc() {
		return teorAlc;
	}

	@Override
	public String toString() {
		return "Bebida [nome=" + nome + ", teorAlc=" + teorAlc + "]";
	}

}
