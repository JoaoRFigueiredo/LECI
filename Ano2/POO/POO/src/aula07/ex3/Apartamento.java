package aula07.ex3;

public class Apartamento extends Alojamento{
    private int rooms;
    
    public Apartamento(String code, String name, String place, double night, double rating, boolean available, int rooms){
        super(code, name, place, night, rating, available);
        this.rooms = rooms;
    }

    public void setRooms(int r){
        this.rooms = r;
    }

    public int getrooms(){
        return rooms;
    }

    public String toString(){
        return super.toString()+
            "\nNúmero de quartos: "+this.rooms;
    }

    

    
}
