package aula07.ex4;

public class Bola extends ObjetoMovel{
    private String cor;
	
	public Bola(int x, int y, double maxv) {
		super(x, y, maxv);
		this.cor = "Branca";
	}
	
	public Bola(int x, int y, double maxv, String cor) {
		super(x, y, maxv);
		this.cor = cor;
	}

	public String getCor() {
		return cor;
	}
}
