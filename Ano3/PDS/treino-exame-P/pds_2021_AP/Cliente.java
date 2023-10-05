
public class Cliente extends Utilizador{

    public Cliente(String nome, String localidade, int idade) {
        super(nome, localidade, idade);
    }

    public String toString() {
        return "Cliente: " + super.toString();
    }

    public String getNome() {
        //return name of utilizador
        return super.getNome();
    }



}
