package aula07.ex4;

public class Robo extends ObjetoMovel {


    private String tipo, nome;
	private int golos = 0;
	private int id;

	//Contructors
	
	public Robo(int x, int y, double maxv, int id, String nome, String tipo) {
		super(x, y, maxv);
		this.id = id; this.tipo = tipo; this.nome = nome;
	}
	
	public Robo(int x, int y, int id, String nome, String tipo) {
		super(x, y, 30);
		this.id = id; this.tipo = tipo; this.nome = nome;
	}
	
	//Getters & Setters
	
	public int getId() {
		return id;
	}

	public String getTipo() {
		return tipo;
	}

	public int getGolos() {
		return golos;
	}
	
	//Outras funções
	
	@Override
	public String toString() {
		return id + " " + nome + ": " + tipo + "; Golos marcados: " + golos + "; Distância percorrida: " + super.getDist() + "; Velocidade máxima: " + super.getMaxv();
	}

	public void marcar() {
		golos++;
	}
    
}
