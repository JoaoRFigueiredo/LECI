package aula07.ex3;

public class Alojamento {
    private String code, name, place;
    private double night, rating;
    private boolean available;
    


    public Alojamento(String code, String name, String place, double night, double rating, boolean available){
        validate(rating);
        this.code = code;
        this.name = name;
        this.place =place;
        this.night = night;
        this.rating = rating;
        this.available = available;
    }

    private void validate(double r){
        if(r< 1.0 || r >5.0 ){
            throw new IllegalArgumentException("Avaliação inválida! \nDeve ser entre 1.0 e 5.0");
        }
    }
    // setters and getters

    public void setName(String n){
        this.name = n;
    }

    public void setCode(String c){
        this.code = c;
    }

    public void setPlace(String p){
        this.place = p;
    }
    
    public void setNight(double n){
        this.night = n;
    }

    public void setRating(double r){
        validate(r);
        this.rating = r;
    }

    public void setAvailable(boolean a){
        this.available = a;
    }

    public String getName(){
        return name;
    }

    public String getCode(){
        return code;
    }

    public String getPlace(){
        return place;

    }

    public double getNight(){
        return night;
    }

    public double getRating(){
        return rating;
    }

    public boolean getAvailable(){
        return available;
    }

    

    //

    public void checkIn(){
        this.available = false;
    }

    public void checkOut(){
        this.available = true;
    }
    
    public String toString(){
        return "Nome: "+this.name+
               "\nCódigo: "+this.code+
               "\nLocal: "+this.place+
               "\nPreço por 1 noite: "+this.night+
               "\nDisponibilidade: "+(this.available ? "Disponível" : "Indisponível")+
               "\nAvaliação: "+this.rating;

    }
    

    
}
