package aula05;

public class Circulo {
    private Ponto centro;
    private double raio;

    public Circulo(double raio){
        this.centro = new Ponto(0, 0);
        this.raio = raio;
    }

    public Circulo(Ponto centro){
        this.centro = centro;
        this.raio = 1.0;
    }


    public Circulo(Ponto centro, double raio){
        this.centro = centro;
        this.raio = raio;
    }

    public Ponto getPonto(){
        return centro;
    }

    public double getRaio(){
        return raio;

    }

    public void setRaio(double newRaio){
        this.raio = newRaio;

    }

    public void setCentro(Ponto newCentro){
        this.centro = newCentro;
    }
    public String toString(){
        return "Centro: "+this.centro.toString()+
                "\nRaio: "+this.raio+
                "\nArea: "+this.area()+
                "\nPerimetro: "+this.perimetro();
    }

    public double area(){
        return Math.PI*Math.pow(this.raio, 2);
    }

    public double perimetro(){
        return Math.PI*2*this.raio;
    }

    public boolean equals(Circulo b){
        return this.raio==b.getRaio();
    }

    public boolean intersect(Circulo c2){
        double d = this.centro.distanceTo(c2.centro);

        if(d < this.raio + c2.raio){
            return true;
        }
        else{
            return false;
        }
    }


}
