package aula08.Ex1;

public class PesadoPassageiros extends Pesado {
    private int pessoas;


    public PesadoPassageiros(String matr, String marca, String mod, int pot, int quadro, int peso, int pessoas){
        super(matr, marca, mod, pot, quadro, peso);
        this.pessoas = pessoas;
    }

    public int getPessoas(){
        return pessoas;
    }

    public String toString() {
        return "PesadoPassageiros{" + "matricula"+ getMatricula() + ", marca=" + getMarca() + ", modelo=" + getModelo() + ", potencia=" + getPotencia() + ", numeroQuadro=" + getQuadro() + ", peso=" + getPeso() + ", maxpassageiros=" + pessoas + '}';
    }

    
}
