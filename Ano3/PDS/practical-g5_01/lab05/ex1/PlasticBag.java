public class PlasticBag extends Container{
    private Portion p;

    public PlasticBag(Portion p){
        this.p = p;
    }

    @Override
    public String toString(){
        return "Plastic bag with portion = " + p.toString();
    }
}
