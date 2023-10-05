public class TermicBottle extends Container{
    private Portion p;

    public TermicBottle(Portion p){
        this.p = p;
    }

    @Override
    public String toString(){
        return "Termic Bottle with portion = " + p.toString();
    }   
}