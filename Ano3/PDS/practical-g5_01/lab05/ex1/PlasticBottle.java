public class PlasticBottle extends Container{
    private Portion p;

    public PlasticBottle(Portion p){
        this.p = p;
    }

    @Override
    public String toString(){
        return "Plastic bag with portion = " + p.toString();
    }
}
