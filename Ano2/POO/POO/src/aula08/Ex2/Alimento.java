package aula08.Ex2;

public class Alimento {
    private double proteinas, peso, calorias;


    public Alimento(double proteinas, double calorias, double peso){
        this.proteinas = proteinas;
        this.calorias = calorias;
        this.peso = peso;


    }

    public double getPeso(){
        return peso;
    }

    public void setPeso(double p){
        this.peso = p;
    }

    public double getCalorias(){
        return calorias;
    }

    public void setCalorias(double p){
        this.calorias = p;
    }

    public double getProteinas(){
        return proteinas;
    }

    public void setProteinas(double p){
        this.proteinas = p;
    }

    public String toString() {
        return "Alimento{" + "proteinas=" + proteinas + ", calorias=" + calorias + ", peso=" + peso + '}';
    }

    
}
