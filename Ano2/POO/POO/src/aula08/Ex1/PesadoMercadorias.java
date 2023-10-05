package aula08.Ex1;

public class PesadoMercadorias extends Pesado{
    private int cargaMax;

    public PesadoMercadorias(String matr, String marca, String mod, int pot, int quadro, int peso, int carga){
        super(matr, marca, mod, pot, quadro, peso);
        this.cargaMax = carga;
    }

    public int getCarga(){
        return cargaMax;
    }

    public String toString() {
        return "PesadoMercadorias{" + "matricula"+ getMatricula() + ", marca=" + getMarca() + ", modelo=" + getModelo() + ", potencia=" + getPotencia() + ", numeroQuadro=" + getQuadro() + ", peso=" + getPeso() + ", cargamax=" + cargaMax + '}';
    }

}