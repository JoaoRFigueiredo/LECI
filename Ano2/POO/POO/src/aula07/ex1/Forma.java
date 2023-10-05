package aula07.ex1;

public abstract class Forma {
    private String cor;

    protected abstract double area();
    protected abstract double perimetro();
    public abstract boolean isShapeValid();
    
    public void setCor(String newCor){
        this.cor = newCor;
    }

    public String getCor(){
        return cor;
    }

    
}
