package aula08.Ex1;

public class Taxi extends AutomovelLigeiro{
    private int licenca;

    public Taxi(String matr, String marca, String mod, int pot, int quadro, int capacidade, int lic){
        super(matr, marca, mod, pot, quadro, capacidade);
        this.licenca = lic;
    }

    public int getLic(){
        return licenca;
    }

    public String toString() {
        return "Taxi{" + "matricula"+ getMatricula() + ", marca=" + getMarca() + ", modelo=" + getModelo() + ", potencia=" + getPotencia() + ", numeroQuadro=" + getQuadro() + ", capacidade=" + getCapacidade() + ", licenca=" + licenca + '}';
    }
}
