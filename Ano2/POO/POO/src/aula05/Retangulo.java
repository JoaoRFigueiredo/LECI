package aula05;

public class Retangulo {
    private double comprimento;
    private double largura;

    public Retangulo(double comprimento, double largura){
        this.largura = largura;
        this.comprimento = comprimento;
    }

    //getters and setters
    public void setComprimento(double newComprimento){
        this.comprimento = newComprimento;
    }

    public void setLargura(double newLargura){
        this.largura = newLargura;
    }

    public double getCompriemnto(){
        return comprimento;
    }

    public double getLargura(){
        return largura;
    }

    public double area(){
        return this.largura*this.comprimento;
    }

    public double perimetro(){
        return 2*this.largura + 2*this.comprimento;
    }

    public boolean equals(Retangulo r2){
        return this.comprimento == r2.getCompriemnto() && this.largura == r2.getLargura();
    }

    public String toString(){
        return "Comprimento: "+this.comprimento+
                "\nLargura: "+this.largura+
                "\nArea: "+this.area()+
                "\nPerimetro: "+this.perimetro();
    }
}
