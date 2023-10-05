package aula07.ex3;

public class Viatura {
    private char classe;
    private String engine;
    private boolean carTaken;

    private void validate(char c){
        if(c != 'A' && c != 'B' && c != 'C' && c != 'D' && c != 'E' && c != 'F'){
            throw new IllegalArgumentException("Classe Inválida");
        };
    }

    private void validate(String eng){
        if (!eng.toLowerCase().equals("gasolina") && !eng.toLowerCase().equals("diesel") && !eng.toLowerCase().equals("hibrido") && !eng.toLowerCase().equals("eletrico") ){
            throw new IllegalArgumentException("Tipo de motorização inválida!");
        }
    }

    public Viatura(char classe, String engine){
        validate(classe);
        validate(engine);
        this.classe = classe;
        this.engine = engine;
        this.carTaken = false;
    }

    public String getFuel(){
        return engine;
    }

    public void setFuel(String f){
        this.engine = f;
    }

    public void setClasse(char c){
        this.classe = c;
    }

    public char getClasse(){
        return classe;
    }

    public void takeCar(){
        this.carTaken = true;
    }
    public boolean getCarTakenState(){
        return carTaken;
    }

    public void returnCar() throws Exception{

        if(this.carTaken)this.carTaken = false;
        else{throw new Exception("O carro não foi emprestado!");}
    }

    public String toString(){
        return "Classe: "+this.classe+
               "\nMotorização: "+this.engine; 
    }



}
