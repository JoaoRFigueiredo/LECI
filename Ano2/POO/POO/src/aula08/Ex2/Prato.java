package aula08.Ex2;

import java.util.ArrayList;

public class Prato {
    private ArrayList<Alimento> composicao;
    private String nome;

    public Prato(String nome){
        this.nome = nome;
        this.composicao = new ArrayList<>();
    }

    public boolean addIngrediente(Alimento a){
        return this.composicao.add(a);
    }

    public void setNome(String n){
        this.nome = n;
    }

    public String getNome(){
        return nome;
    }

    public String toString() {
        return "Prato{" + "nome=" + nome + ", composição=" + composicao + '}';
    }
    
}
