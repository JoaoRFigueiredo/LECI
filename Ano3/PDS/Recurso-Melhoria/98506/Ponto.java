
public class Ponto extends Entity implements Geometria {
    private double x;
    private double y;

    public Ponto(double x, double y){
        this.x = x;
        this.y = y;
        
    }

    


    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    @Override
    public void draw() {
        // TODO Auto-generated method stub
        System.out.println("Drawing a Point (x="+x+", y="+y+")");
    }

    @Override
    public boolean isValid() {
        // TODO Auto-generated method stub
        return (x >=0 && y >=0 );
    }

    @Override
    public String toString(){
        return "Point (x="+x+", y= "+y+")";
    }


    @Override
    public void traverse() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'traverse'");
    }

    
    
}
