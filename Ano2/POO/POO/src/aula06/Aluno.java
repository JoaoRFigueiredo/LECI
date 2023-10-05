package aula06;

public class Aluno extends Pessoa {
    private Date DataIncs;
    private int nmec;
    private static int counter = 100;

    public Aluno(String nome, int cc, Date dataNascimento, Date DataIncs){
            super(nome, cc, dataNascimento);
            this.nmec = counter++;
            this.DataIncs = DataIncs;
    }

    public Aluno(String nome, int cc, Date dataNascimento){
        super(nome, cc, dataNascimento);
        this.DataIncs = new Date(); // data atual
        this.nmec = counter++;

    }

    public Date getDataIncs(){
        return DataIncs;
    }

    public int getNmec(){
        return nmec;
    }

    @Override
    public String toString(){
        return this.getName()+"\nNmec: "+this.getNmec()+"\nData de inscrição: "+this.getDataIncs();
    }
}
