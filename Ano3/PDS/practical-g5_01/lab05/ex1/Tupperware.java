public class Tupperware extends Container{
    private Portion p;

    public Tupperware(Portion p){
        this.p = p;
    }

    @Override
    public String toString(){
        return "Tupperware with portion = " + p.toString();
    }
}
