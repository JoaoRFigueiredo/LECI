package aula11.Ex2;



public class Cidade implements Comparable<Cidade> {
    private String nome;
    private int sum = 0;

    public Cidade(String nome){
    this.nome = nome;
    }
    
    public int getSum(){
        return this.sum;
    }

    public String getName(){
        return nome;
    }
    public void increment(){
        this.sum++;
    }

    @Override
    public int compareTo(Cidade o) {
        if(this.getSum() < o.getSum()){
            return 1;
        }
        else{
            return -1;
        }
    }

    @Override
    public boolean equals(Object obj){
        if(obj != null){
            Cidade ci = (Cidade) obj;
            if(ci.getName().equals(this.nome)){
                return true;
            }
        }
        return false;

    }

    public String toString(){
        return this.getName()+"/"+this.getSum();
    }

}
