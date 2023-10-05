package aula07.ex1;

public class Triangulo extends Forma{
    private double l1, l2, l3;

    public Triangulo(double l1, double l2, double l3){
        this.l1 = l1;
        this.l2=l2;
        this.l3 = l3;
    }

    public Triangulo(double l1, double l2, double l3, String cor){
        this(l1, l2, l3);
        this.setCor(cor);
    }

    //getters and setters
    public double getL1(){
        return l1;
    }

    public double getL2(){
        return l2;
    }

    public double getL3(){
        return l3;
    }

    public void setl1(double newL1){
        this.l1 = newL1;
    }
    public void setl2(double newL2){
        this.l2 = newL2;
    }

    public void setl3(double newL3){
        this.l3 = newL3;
    }

    public double perimetro(){
        return this.l1+this.l2+this.l3;
    }

    public boolean isShapeValid(){
        return ((l1 + l2 > l3) && (l2 + l3 > l1) && (l3 + l1 > l2));
    }

    public double area(){
        double s = this.perimetro()/2;
        return Math.sqrt(s*(s-this.l1)*(s-this.l2)*(s-this.l3));
    }

    public boolean equals(Triangulo t2){
        return this.l1 == t2.getL1() && this.l2 == t2.getL2() && this.l3 == t2.getL3();
    }

    public String toString(){
        return  "Lado1: "+this.l1+
                "\nLado2: "+this.l2+
                "\nLado3: "+this.l3+
                "\nPerimetro: "+this.perimetro()+
                "\nArea: "+this.area()+
                "\nCor: "+this.getCor();
    }



    


}