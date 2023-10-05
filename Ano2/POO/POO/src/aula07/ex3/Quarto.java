package aula07.ex3;

public class Quarto extends Alojamento{
    private String type;

    private void validate(String eng){
        if (!eng.toLowerCase().equals("single") && !eng.toLowerCase().equals("double") && !eng.toLowerCase().equals("twin") && !eng.toLowerCase().equals("triple") ){
            throw new IllegalArgumentException("Tipo de quarto inválida!");
        }
    }

    public Quarto(String code, String name, String place, double night, double rating, boolean available, String type){
        
        super(code, name, place, night, rating, available);
        validate(type);
        this.type = type;
    }

    public void setType(String t){
        this.type = t;
    }

    public String getType(){
        return type;
    }

    public String toString(){
        return super.toString()+
        "\nTipo de Quarto: "+this.type;   
    }
}
