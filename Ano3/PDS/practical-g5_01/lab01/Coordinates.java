public class Coordinates {
    private int x; // row
    private int y; // collumn

    public Coordinates(int x, int y){
        this.x = x;
        this.y = y;

    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public void setX(int newX){
        this.x = newX;
    }

    public void setY(int newY){
        this.y = newY;
    }

    public String toString(){
        return "("+(this.x+1)+", "+(this.y+1)+")";
    }
    
}
