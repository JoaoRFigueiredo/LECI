package ExercicioAdicional;

public class Aluno implements Comparable<Aluno>{
    private String nome;
    private int cc;
    private DateYMD dataNascimento;
    private DateYMD DataIncs;
    private int nmec;
    

    public Aluno(String nome, int cc, int nmec, DateYMD dataNascimento, DateYMD DataIncs){
            this.nome = nome;
            this.cc = cc;
            this.nmec = nmec;
            this.dataNascimento = dataNascimento;
            this.DataIncs = DataIncs;
    }

    

    public DateYMD getDataIncs(){
        return DataIncs;
    }
    public String getNome(){
        return nome;
    }

    public int getcc(){
        return cc;
    }

    public DateYMD getDataNasc(){
        return dataNascimento;
    }

    public int getNmec(){
        return nmec;
    }

    @Override
    public String toString(){
        return this.nome+","+this.cc+","+this.nmec+","+this.dataNascimento+","+this.DataIncs;
    }



    @Override
    public int compareTo(Aluno a1) {
        if(this.nmec < a1.nmec){
            return -1;
        }
        else{
            return 1;
        }
        
    }



    
}
