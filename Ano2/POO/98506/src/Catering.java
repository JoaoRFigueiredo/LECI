public class Catering extends Activity{

    private String nome;
    private int num;

    public enum Option{
        FULL_MENU, DRINKS_AND_SNACKS, LIGHT_BITES
    }

    public Catering(Option nome, int num){
        super(nome, num);
    }

    public String getName(){
        return nome.toString();
    }

    public int getNum(){
        return num;
    }
    
}
