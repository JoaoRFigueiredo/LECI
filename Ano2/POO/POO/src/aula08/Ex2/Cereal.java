package aula08.Ex2;

public class Cereal extends Alimento implements Vegetariano {
    private String nome;

    public Cereal( String nome, double proteinas, double calorias, double peso){
        super(proteinas, calorias, peso);
        this.nome = nome;
    }

    public String getNome(){
        return nome;
    }
    public String toString() {
        return "Cereal{" + "nome=" + nome + '}';
    }
}
