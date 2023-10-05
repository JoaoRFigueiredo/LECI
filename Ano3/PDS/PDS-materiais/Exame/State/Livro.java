package v3;

public class Livro {
	String titulo, autor;
	int isbn, ano;
	State state;
	public Livro(String titulo, String autor, int isbn, int ano) {
		this.ano=ano;
		this.autor=autor;
		this.isbn=isbn;
		this.titulo=titulo;
		this.state=new Inventario();
	}
	
	public void setState(State s) {
		state=s;
	}
	
	public void regista() {
		state.regista(this);
	}
	
	public void requisita() {
		state.requisita(this);
	}
	
	public void reserva() {
		state.reserva(this);
	}
	
	public void cancelaReserva() {
		state.cancelaReserva(this);
	}
	
	public void devolve() {
		state.devolve(this);
	}

	public String titulo() {
		return this.titulo;
	}
	
	public String autor() {
		return this.autor;
	}
	
	public int ano() {
		return this.ano;
	}
	
	public int isbn() {
		return this.isbn;
	}
	
	public String estado() {
		return this.state.toString();
	}
	
}