package aula08.Ex2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Ementa {
    private String nome, local;
    private Map<DiaSemana, ArrayList<Prato>> lista;

    public Ementa(String nome, String local){
        this.nome = nome;
        this.local = local;
        this.lista = new HashMap<>();
    }

    public String getNome(){
        return nome;
    }

    public String getLocal(){
        return local;
    }

    public void setLocal(String l){
        this.local = l;
    }

    public void setNome(String n){
        this.nome = n;
    }

    public Map<DiaSemana, ArrayList<Prato>> getLista(){
        return lista;
    }

    

    public boolean addPrato(Prato prato, DiaSemana dia) {
        if (lista.containsKey(dia)) {
            return lista.get(dia).add(prato);
        } else {
            ArrayList<Prato> pratos = new ArrayList<>();
            pratos.add(prato);
            lista.put(dia, pratos);
            return true;
        }
    }

    public String toString() {
        String result = "Ementa: " + this.getNome() + " - " + this.getLocal() + "\n\n";

        for (DiaSemana dia : lista.keySet()) {
            for (Prato prato : lista.get(dia)) {
                result += prato + ", ";
            }

            result += dia + "\n";
        }

        return result;
    }

}
