package aula08.Ex1;

public class Pesado extends Veiculo {
    private int quadro, peso;

    public Pesado(String matr, String marca, String mod, int pot, int quadro, int peso){
        super(matr, marca, mod, pot);
        this.quadro = quadro;
        this.peso = peso;
    }

    public int getPeso(){
        return peso;
    }

    public int getQuadro(){
        return quadro;
    }

    public String toString() {
        return "Pesado{" + "matricula"+ getMatricula() + ", marca=" + getMarca() + ", modelo=" + getModelo() + ", potencia=" + getPotencia() + ", numeroQuadro=" + getQuadro() + ", peso=" + peso + '}';
    }
}
