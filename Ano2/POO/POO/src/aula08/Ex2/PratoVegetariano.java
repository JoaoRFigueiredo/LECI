package aula08.Ex2;

import java.util.ArrayList;

public class PratoVegetariano extends Prato implements Vegetariano {
    private ArrayList<Vegetariano> composicao;

    public PratoVegetariano(String nome){
        super(nome);
        this.composicao = new ArrayList<>();
    }

    public ArrayList<Vegetariano> getComposicao(){
        return composicao;
    }

    public void addAlimento(Vegetariano a){
        this.composicao.add(a);
    }
    public String toString() {
        return "PratoVegetariano{" + "composição=" + composicao + '}';
    }
}
