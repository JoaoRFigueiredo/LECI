package v3;

public class lent implements State {

	public lent() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void regista(Livro l) {
		System.err.println("Operação não suportada");
	}

	@Override
	public void requisita(Livro l) {
		System.err.println("Operação não suportada");
	}

	@Override
	public void devolve(Livro l) {
		l.setState(new avaiable());
	}

	@Override
	public void cancelaReserva(Livro l) {
		System.err.println("Operação não suportada");
	}

	@Override
	public void reserva(Livro l) {
		System.err.println("Operação não suportada");
	}

	public String toString() {
		return "[Emprestado]";
	}
}