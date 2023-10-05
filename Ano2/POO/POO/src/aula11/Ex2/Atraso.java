package aula11.Ex2;

public class Atraso implements Comparable<Atraso> {
    private int min;
    private String companhia;


    public Atraso(String companhia, int min){
        this.min = min;
        this.companhia = companhia;
    }

    public int getMin(){
        return min;
    }

    public String getCompanhia(){
        return companhia;
    }

    @Override
    public int compareTo(Atraso o) {
        
        if(this.getMin() > o.getMin()){
            return 1;
        }
        else{
            return -1;
        }
    }

    
    
}
