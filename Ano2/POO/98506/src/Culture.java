public class Culture extends Activity  {

    private Option name;
    private int num;

    public enum Option{
        ARCHITECTURAL_TOUR, RIVER_TOUR, WINE_TASTING
    }

    public Culture(Option name, int num){
        super(name, num);
    }

    public String getName(){
        return name.toString();
    }

    public int getNum(){
        return num;
    }

    
}
