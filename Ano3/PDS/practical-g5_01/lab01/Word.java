public class Word {
    private String word;
    private int size;
    private String direction;
    private Coordinates initCoord;


    public Word(String word, int size, String direction, Coordinates initCoord){
        this.word = word;
        this.size = size;
        this.direction = direction;
        this.initCoord = initCoord;
    }

    public int getSize(){
        return size;
    }

    public String getWord(){
        return word;
    }

    public String getDirection(){
        return direction;
    }

    public Coordinates getInitCoord(){
        return initCoord;
    }

    
    public String toString(){

        return String.format("%-15s %-5d %-9s %-9s", this.word, this.size, this.initCoord.toString(), this.direction);
    }
    
}
