package aula08.Ex1;

public class AutomovelLigeiroEletrico extends AutomovelLigeiro implements VeiculoEletrico{
    private int carga, autonomia;

    public AutomovelLigeiroEletrico(String matr, String marca, String mod, int pot, int quadro, int capacidade,  int autonomia, int carga){
        super(matr, marca, mod, pot, quadro, capacidade);
        if(carga< 0 && carga > 100 ) throw new IllegalArgumentException("Carga inválida");
        this.autonomia = autonomia;
        this.carga = carga;
    }

    public int getCarga(){
        return carga;
    }

    

    public void carregar(int percentagem){ // carregar até percentagem
        while(true){
            if (this.carga >= percentagem){System.out.println("A bateria já possui "+percentagem);break;}
            this.carga++;
        }
    }

    public void consumir(int percentagem){
        this.carga = this.carga - percentagem;
        if (this.carga < 0 ) this.carga = 0;
    }

    @Override
    public int autonomia() {
        return autonomia * (carga/100);
    }

    public String toString() {
        return "AutomovelLigeiroEletrico{" + "matricula"+ getMatricula() + ", marca=" + getMarca() + ", modelo=" + getModelo() + ", potencia=" + getPotencia() + ", numeroQuadro=" + getQuadro() + ", capacidade=" + getCapacidade() + ", autonomia_maxima=" + autonomia + ", carga=" + carga + '}';
    }
    
}
