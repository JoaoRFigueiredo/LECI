
public class Motorcycle implements Product {

    private String code;
    private String description;
    private int points;
    private State state;

    public Motorcycle(String code, String description, int points) {
        this.code = code;
        this.description = description;
        this.points = points;
        this.state = State.AVAILABLE;
    }

    @Override
    public String code() {
        //return code
        return this.code;
    }

    @Override
    public String description() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public double points() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void setState(State s) {
        // TODO Auto-generated method stub
        
    }

    //To string
    @Override
    public String toString() {
        return "Motorcycle [code=" + code + ", description=" + description + ", points=" + points + "]";
    }

    @Override
    public State getState() {

        return this.state;
    }

    
}
