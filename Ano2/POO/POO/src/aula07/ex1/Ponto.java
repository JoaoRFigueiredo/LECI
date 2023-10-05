package aula07.ex1;

public class Ponto {
    private double x;
    private double y;

    public Ponto(double x, double y){
        this.x = x;
        this.y = y;
    }

    //getters
    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }

    public String toString(){
        return "("+x+"; "+y+")";
    }

    public void setX(double newX){
        this.x = newX;
    }

    public void setY(double newY){
        this.y = newY;

    }

    //Distância entre 2 pontos
    public double distanceTo(Ponto p2){
        return Math.sqrt( Math.pow(p2.x - this.x, 2) + Math.pow(p2.y - this.y, 2));
    }

    public boolean equals(Ponto p2){
        return this.x == p2.getX() && this.y == p2.getY();
    }
}
