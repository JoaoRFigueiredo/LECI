package aula11.Ex2;

public class Tempo {
    private int minutos;

    public Tempo(int hora, int min){
        this.minutos = hora*60 + min;
    }

    public Tempo(){
        this.minutos = 0;
    }

    public Tempo(int minutos){
        this.minutos = minutos;
    }

    public Tempo(String time){
        String[] arr = time.split(":");
        this.minutos= Integer.parseInt(arr[0])*60 + Integer.parseInt(arr[1]);
    }

    

    public static Tempo timeDelay(Tempo t1, Tempo t2){ // devolve um novo tempo, já com o atraso
        int minAtraso = t1.Minutos() + t2.Minutos();
        return new Tempo(minAtraso);
    }

    public int getMin(){
        return minutos;
    }

    public int Minutos(){
        return this.minutos;
    }

    @Override
    public String toString(){
        return String.format("%02d:%02d", this.Minutos()/60, this.Minutos()%60);
    }
    
}
