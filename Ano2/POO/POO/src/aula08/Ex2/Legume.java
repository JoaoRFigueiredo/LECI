package aula08.Ex2;

public class Legume extends Alimento implements Vegetariano {
    private String nome;

    public Legume(String nome, double proteinas, double calorias, double peso){
        super(proteinas, calorias, peso);
        this.nome = nome;
    }

    public String getNome(){
        return nome;
    }

    public String toString() {
        return "Legume{" + "nome=" + nome + '}';
    }
}
