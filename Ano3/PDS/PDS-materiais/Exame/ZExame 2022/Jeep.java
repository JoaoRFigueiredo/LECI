
public class Jeep implements Product {
    private String code;
    private String description;
    private int points;
    private State state;

    public Jeep(String code, String description, int points) {
        this.code = code;
        this.description = description;
        this.points = points;
        this.state = State.AVAILABLE;

    }

    public Jeep(OldJeep oJeep){
        String total = oJeep.getData();
        String[] split = total.split(";");
        this.code = split[0];
        this.description = split[1];
        this.points = Integer.parseInt(split[2]);
    }

    @Override
    public String code() {
        // TODO Auto-generated method stub
        return null;
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


    @Override
    public String toString() {
        return "Jeep [code=" + code + ", description=" + description + ", points=" + points + "]";
    }

    @Override
    public State getState() {

        return this.state;
    }
    
    
}

    

    


