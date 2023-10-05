package aula08.Ex1;

public class Veiculo implements KmPercorridosInterface {
    private String matricula, marca, modelo;
    private int potencia;
    private int kmFeitos = 0; // variavél usada para armazenar distância percorrida na última viagem
    private int kmTotais = 0;

    public Veiculo(String matr, String marca, String mod, int pot){
        this.matricula = matr;
        this.marca = marca;
        this.modelo = mod;
        this.potencia = pot;
    }


    public String getMatricula(){
        return matricula;

    }

    public String getMarca(){
        return marca;
    }

    public String getModelo(){
        return modelo;
    }

    public int getPotencia(){
        return potencia;
    }

    public void trajeto(int km){
        kmFeitos = km;
        kmTotais += kmFeitos;
    }

    public int ultimoTrajeto(){
        return kmFeitos;
    }

    public int distanciaTotal(){
        return kmTotais;
    }

    public String toString() {
        return "Veiculo{" + "matricula=" + matricula + ", marca=" + marca + ", modelo=" + modelo + ", potencia=" + potencia + '}';
    }
}
