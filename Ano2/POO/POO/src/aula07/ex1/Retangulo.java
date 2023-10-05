package aula07.ex1;

public class Retangulo extends Forma {
    private double comprimento;
    private double largura;

    public Retangulo(double comprimento, double largura){
        this.largura = largura;
        this.comprimento = comprimento;
    }

    public Retangulo(double comprimento, double largura, String cor){
        this(comprimento, largura);
        this.setCor(cor);
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

    public boolean isShapeValid(){
        return comprimento > 0 && largura > 0;
    }

    public boolean equals(Retangulo r2){
        return this.comprimento == r2.getCompriemnto() && this.largura == r2.getLargura();
    }

    public String toString(){
        return "Comprimento: "+this.comprimento+
                "\nLargura: "+this.largura+
                "\nArea: "+this.area()+
                "\nPerimetro: "+this.perimetro()+
                "\nCor: "+this.getCor();
    }
}
