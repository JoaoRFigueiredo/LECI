



public class Activity {
    private int num;
    private String nome;
    private Culture.Option op;
    private Sport.Modality mo;
    private Catering.Option cat;


    public Activity(Culture.Option op, int num){
        this.op = op;
        this.num = num;
    }
    

    public Activity(Sport.Modality mo, int num){
        this.mo = mo;
        this.num = num;
    }
    

    public Activity(Catering.Option cat, int num){
        this.cat = cat;
        this.num = num;
    }

    public int getNum(){
        return num;
    }

    public String toString(){
        return this.getClass().toString() + " "+this.getNum();
    }
    
    
    
    
}
