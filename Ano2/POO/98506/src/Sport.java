public class Sport extends Activity {
    private Modality nome;
    private int num;

    public enum Modality{
        KAYAK, BIKE
    }
    

    public Sport(Modality nome, int num){
        super(nome, num);
    }

    public String getName(){
        return nome.toString();
    }

    public int getNum(){
        return num;
    }
}
