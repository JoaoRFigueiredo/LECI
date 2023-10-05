package aula07.ex4;

public class Jogo {
    private long limit;			//Tempo do jogo em segundos
	private long start;			//Tempo real de inicio
	private long current;		//Tempo de jogo atual
	private Bola bola;
	private Equipa eq1, eq2;
	private boolean done = false;

	public Jogo(Equipa eq1, Equipa eq2, Bola bola, long limit) {
		this.eq1 = eq1; this.eq2 = eq2; this.bola = bola; this.limit = limit;
	}
	
	public void start() {
		start = (System.currentTimeMillis()/1000);
	}
	
	public void update() {
		current = (System.currentTimeMillis()/1000) - start;
		if(current>=limit) {
			done = true;
		}
	}
	
	public void golo1(int id) {
		if(!done) {
			eq1.marcou();
			eq2.sofreu();
			eq1.getjogador(id).marcar();
		} else {
			System.out.println("Jogo terminado, não é possivél marcar golos");
		}
		
	}
	public void golo2(int id) {
		if(!done) {
			eq2.marcou();
			eq1.sofreu();
			eq2.getjogador(id).marcar();
		} else {
			System.out.println("Jogo terminado, não é possivél marcar golos");
		}
	}

	@Override
	public String toString() {
		return eq1 + "\n" + eq2 + "\nTempo Decorrido: " + current + " segundos\n" + eq1.getNome()+" "+eq1.getGm()+"-"+eq2.getGm()+" "+eq2.getNome() + "\nBola do jogo: " + bola.getCor() + "\n";
	}
}
