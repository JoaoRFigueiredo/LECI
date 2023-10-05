package aula08.Ex2;

import java.util.ArrayList;

public class PratoDieta extends Prato{
    private double maxCalorias;
    ArrayList<Alimento> composicao;
    
    public PratoDieta(String nome, double maxCalorias){
        super(nome);
        this.maxCalorias = maxCalorias;
        this.composicao = new ArrayList<>();
    }

    public double getMaxCalorias(){
        return maxCalorias;
    }

    
}
