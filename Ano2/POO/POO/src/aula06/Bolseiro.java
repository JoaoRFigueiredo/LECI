package aula06;

public class Bolseiro extends Aluno{
    private int bolsa;

    public Bolseiro(String nome, int cc, Date dataNascimento, int bolsa){
        super(nome, cc, dataNascimento);
        this.bolsa = bolsa;
    }

    public int getBolsa(){
        return bolsa;
    }

    public void setBolsa(int b ){
        this.bolsa = b;
    }

    @Override
    public String toString(){
        return "Nome: "+this.getName()+"; Nmec: "+this.getNmec()+"; Data de inscrição: "+this.getDataIncs()+"; Valor da bolsa: "+this.getBolsa();
    }
    
}
