import java.util.ArrayList;


public class Flight {
    private String code;
    private Airplane av;
    private ArrayList<Reservation> rv; // array para guardar as reservas
    //inicialmente coloco todas aqui, e dps vou vendo se são válidas ou não
    private ArrayList<Reservation> notPossible; 



    public Flight(String code, Airplane av){
        this.code = code;
        this.av = av;
        this.rv = new ArrayList<>();
        this.notPossible = new ArrayList<>();
    }

    //getters and setters
    public Airplane getAirplane(){
        return av;
    }

    public String getCode(){
        return code;
    }

    public void setCode(String newCode){
        this.code = newCode;
    }

    public void setAirplane(Airplane newAirplane){
        this.av = newAirplane;
    }

    public ArrayList<Reservation> getReservationList(){
        return rv;
    }

    public boolean addReservation(Reservation r){
        if (this.av.applyReservation(r)){
            this.rv.add(r);
            return true;
        } 
        else{
            this.notPossible.add(r);
            return false;
        }
         
    }

    public String toString(){
         String str = "Código de voo: "+this.code+
         "\nLugares disponíveis: "+this.av.getNumE()+" lugares em classe Executiva; "+this.av.getNumT()+" lugares em classe Turística"
         +"\nQuantidade de reservas: "+this.rv.size();

        if (this.notPossible.size() > 0){
            str = str + "\nNão foi possível obter lugares para a reserva: ";
            for (Reservation r : this.notPossible){
                str = str + (r.toString()+", ");
            }
        }


         return str;
        
        
        
        
        
        //"-----------------------------------"+
        // "\nFlight: "+code+
        // "\nAirplane Info: "+this.av.toString()+
        // "\nExistem as seguintes reservas: "+rv.toString()+
        // "\n----------------------------------------";

    }
    
}
