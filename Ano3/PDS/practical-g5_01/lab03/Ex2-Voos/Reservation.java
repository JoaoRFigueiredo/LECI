    public class Reservation {
    private int numPassengers;
    private char seatClass;
    private int id;
    private boolean reserved;


    public Reservation(int numPassengers, char seatClass){
        this.numPassengers = numPassengers;
        this.seatClass = seatClass;
        
    }

    public char getSeatClass(){
        return seatClass;
    }

    public int getId(){
        return id;
    }

    public void setId(int newId){
        this.id = newId;
    }

    public void setSeatClass(char newSeatClass){
        this.seatClass = newSeatClass;
    }

    public boolean getReservedStatus(){
        return reserved;
    }

    public void setReserved(boolean newStatus){
        this.reserved = newStatus;
    }

    public int getNumPassengers(){
        return numPassengers;
    }

    public void setNumPassengers(int newNumPassengers){
        this.numPassengers = newNumPassengers;
    }

    public String toString(){
        return seatClass+" "+numPassengers;
    }
    
}
