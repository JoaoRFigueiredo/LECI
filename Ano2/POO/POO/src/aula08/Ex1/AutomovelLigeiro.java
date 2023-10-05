package aula08.Ex1;

public class AutomovelLigeiro extends Veiculo {
    private int quadro, capacidade;
    
    public AutomovelLigeiro(String matr, String marca, String mod, int pot, int quadro, int capacidade){
        super(matr, marca, mod, pot);
        this.quadro = quadro;
        this.capacidade = capacidade;
    }

    public int getQuadro(){
        return quadro;
    }

    public int getCapacidade(){
        return capacidade;
    }

    public String toString() {
        return "Automovel{" + "matricula"+ getMatricula() + ", marca=" + getMarca() + ", modelo=" + getModelo() + ", potencia=" + getPotencia() + ", numeroQuadro=" + quadro + '}';
    }
}
