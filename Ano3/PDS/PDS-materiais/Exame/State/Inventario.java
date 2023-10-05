package v3;

public class Inventario implements State{

	public Inventario() {
	}

	@Override
	public void regista(Livro l) {
		l.setState(new avaiable());
	}

	@Override
	public void requisita(Livro l) {
		System.err.println("Operação não suportada");
	}

	@Override
	public void devolve(Livro l) {
		System.err.println("Operação não suportada");
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
		return "[Inventário]";
	}

}