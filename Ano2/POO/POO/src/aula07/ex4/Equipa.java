package aula07.ex4;

public class Equipa {
    private String nome, treinador;
	private int gm=0, gs=0;
	private Robo[] jogadores = new Robo[11];
	
	//Constructor
	
	public Equipa(String nome, String treinador) {
		this.nome = nome; this.treinador = treinador;
	}
	
	//Getters & Setters
	
	public String getNome() {
		return nome;
	}

	public String getTreinador() {
		return treinador;
	}

	public int getGm() {
		return gm;
	}

	public int getGs() {
		return gs;
	}
	
	public Robo getjogador(int id) {
		for(int i=0; i<11; i++) {
			if(jogadores[i].getId() == id) {
				return jogadores[i];
			}
		}
		return null;
	}
	
	//Outras funções
	
	public void marcou() {
		gm++;
	}
	public void sofreu() {
		gs++;
	}

	@Override
	public String toString() {
		String s = "";
		for(int i=0; i<11; i++) {
			if(jogadores[i]==null) {
				break;
			} else {
				s+=(jogadores[i].toString() + "\n");
			}
		}
		return nome + ":\n" + "Treinador: " + treinador + "\n" + s;
	}
	
	public String addjogador(Robo r) {
		for(int i=0; i<11; i++) {
			if(jogadores[i]==null) {
				jogadores[i] = r;
				return "Jogador adicionado com sucesso.";
			}
		}
		return "Equipa cheia!";
	}
    
}
