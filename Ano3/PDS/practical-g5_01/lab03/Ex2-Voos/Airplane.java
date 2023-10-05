

public class Airplane {
    private int[][] E_seats;
    private int[][] T_seats;
    //private ArrayList<Seat> seats;


    public Airplane(int[][] E_seats, int[][] T_seats){

        this.T_seats = T_seats;
        this.E_seats = E_seats;
    } 

    public int[][] getSeatsE(){
        return E_seats;
    }

    public int[][] getSeatsT(){
        return T_seats;
    }

    public int getNumE(){
        int num = 0;
        if (E_seats != null){
        num = E_seats.length * E_seats[0].length;
        }

        return num;
    }

    public int getNumT(){
        
        return T_seats.length * T_seats[0].length;
        
    }

    public int countAvailableSeats(int[][] rows) {
        int numAvailableSeats = 0;
        for (int i = 0; i < E_seats.length; i++) {
            for (int j = 0; j < E_seats[i].length; j++) {
                if (E_seats[i][j] == 0) {
                    numAvailableSeats++;
                }
            }
        }
        return numAvailableSeats;
    }


    public boolean applyReservation(Reservation r) {
        char seatClass = r.getSeatClass();
        int[][] seats;
        //int numColumns;
        if (seatClass == 'E') {
            if (E_seats == null){
                return false;
            }
            seats = E_seats;
        } else if (seatClass == 'T') {
            seats = T_seats;
            //System.out.println(r.getId());
            
        } else {
            throw new IllegalArgumentException("Invalid seat class: " + seatClass);
        }
    
        int numPassengers = r.getNumPassengers();
    
        // Check if there are enough available seats
        int availableSeats = 0;
        for (int i = 0; i<seats.length; i++){
            for (int j = 0; j<seats[i].length; j++){
                if (seats[i][j] == 0){
                    availableSeats++;
                }
            }
        }


        if (availableSeats < numPassengers) {
            return false; // Reservation cannot be made
        }
    
        //procurar um coluna vazia
        int emptyColumnIndex = -1;
        for (int j = 0; j < seats[0].length; j++) { // iterate over columns
            boolean isEmptyColumn = true;
            for (int i = 0; i < seats.length; i++) { // iterate over rows in column j
                if (seats[i][j] != 0) { // if there's a non-zero value in column j, it's not empty
                    isEmptyColumn = false;
                    break;
                }
            }
            if (isEmptyColumn) {
                emptyColumnIndex = j;
                break;
            }
        }

        // If an empty column is found, fill in the reservation ID
        boolean finished = true;
    if (emptyColumnIndex != -1) {
        
        for (int i = 0; i < seats.length; i++) {
            //System.out.println(r.getId());
            seats[i][emptyColumnIndex] = r.getId();
            numPassengers--;
            if (numPassengers == 0) {
                return true;
            }
        }
        finished = false;
    }
    //showRows(seats);
            if (!finished){
                //falta por passageiros
                //passamos para a coluna seguinte
                while(numPassengers != 0){
                    //System.out.println(emptyColumnIndex);
                    emptyColumnIndex++;
                    for (int j = 0; j < seats.length; j++) {
                        //System.out.println(r.getId());
                        
                        seats[j][emptyColumnIndex] = r.getId();
                        numPassengers--;
                        if (numPassengers == 0) {
                            return true;
                        }
                    }
                }
            }
                
        
    

    // If no empty column is found, fill in empty seats sequentially starting from the first row
    for (int j = 0; j < seats[0].length; j++) {
        for (int i = 0; i < seats.length; i++) {
            if (seats[i][j] == 0) {
                seats[i][j] = r.getId();
                numPassengers--;
                if (numPassengers == 0) {
                    return true;
                }
            }
        }
    }

        

        return true;
    }

    public void showRows(int[][] seats){
        for (int i = 0; i<seats.length; i++){
            for (int j = 0; j<seats[i].length; j++){
                System.out.print(seats[i][j]+" ");
            }
            System.out.println();
        }
    }


    public void printT_rows(){
        for (int j = 0; j < T_seats.length; j++) {
            for (int i = 0; i < T_seats[0].length; i++) {
                System.out.print(T_seats[j][i]+" ");
            }
            System.out.println();
        }
    }

    public void printE_rows(){
        for (int j = 0; j < E_seats.length; j++) {
            
            for (int i = 0; i < E_seats[0].length; i++) {
                System.out.print(E_seats[j][i]+" ");
            }
            System.out.println();
        }
    }

    public void printRows() {
        if (E_seats != null){
        int numRowsT = T_seats.length;
        int numRowsE = E_seats.length;
        int numCols = T_seats[0].length + E_seats[0].length;
            System.out.print("   ");
            
        for (int i = 1; i<=numCols; i++){
            System.out.print(i+"  ");

        }
        System.out.println();
        for (int i = 0; i < Math.max(numRowsT, numRowsE); i++) {
            System.out.print((char)('A'+i)+"  ");
            if (i < numRowsE) {
                for (int j = 0; j < E_seats[0].length; j++) {
                    System.out.print(E_seats[i][j] + "  ");
                }
            } else {
                for (int j = 0; j < E_seats[0].length; j++) {
                    System.out.print("  ");
                }
            }
            if (i < numRowsT) {
                for (int j = 0; j < T_seats[0].length; j++) {
                    System.out.print(T_seats[i][j] + "  ");
                }
            } else {
                for (int j = 0; j < T_seats[0].length; j++) {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
    else{
        System.out.print("   ");
        for (int i = 1; i<=T_seats[0].length; i++){
            System.out.print(i+"  ");

        }
        System.out.println();
        for(int i = 0; i<T_seats.length; i++){
            System.out.print((char)('A'+i)+"  ");
            for(int j = 0; j<T_seats[0].length; j++){
                System.out.print(T_seats[i][j]+"  ");
            }
            System.out.println();
        }
    }
    }

   

    public String toString(){
        return (E_seats != null ? "Filas de executiva: "+E_seats.length+"x"+E_seats[1].length :  "Filas de executiva: 0")
        + " | Filas de Turista: "+T_seats.length+"x"+T_seats[0].length;
        

        
        
        
        // "Filas de executiva: "+E_seats.length+"x"+E_seats[1].length+
        // " /Filas de Turista: "+T_seats.length+"x"+T_seats[1].length;
    }
    
}
