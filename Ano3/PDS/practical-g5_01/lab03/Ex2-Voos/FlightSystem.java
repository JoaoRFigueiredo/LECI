import java.util.*;
import java.io.*;


public class FlightSystem {

    private static ArrayList<Flight> flights;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        flights = new ArrayList<>();
        boolean working = true;
        String option = "";

        //Dashboard
        String menu = "Menu - List of commands:"
        //+"\n (H) -> Shows available commands"
        +"\n (I filename)"
        +"\n (M flight_code)"
        +"\n (F flight_code num_seats_executive num_seats_tourist)"
        +"\n (R flight_code class number_seats)"
        +"\n (C reservation_code)"
        +"\n Q -> Quit";

        
        //se args.length > 0, then a file may have been provied

        if (args.length > 0){
            Flight fl = obtainFlight(args[0]);
            flights.add(fl);
            System.out.println(fl.toString());

        }





        while(working){
            System.out.println("Choose an option: (H for help)");
            option = sc.nextLine();

           switch (option.toLowerCase().substring(0, 1)){ 
            case "h":
            System.out.println(menu);
            break;

            case "s":
            show();
            break;

            case "m":
            String[] arr = option.split(" ");
            for (Flight f : flights){
                if (f.getCode().equals(arr[1])){                
                f.getAirplane().printRows();
                }
            }
            break;

            case "i": //a file with flight information is provided
            Flight fl = obtainFlight(option.substring(2));
            flights.add(fl);
            System.out.println(fl.toString());
            break;

            case "f":
            
            Flight f1 = obtainFlightFromString(option);
            flights.add(f1);
            break;

            case "r":
            addReservation(option);
            break;

            case "c":
            cancelReservation(option);
            break;


            case "q":
            System.out.println("Exiting...");
            System.exit(0);
           }

        }
        
        sc.close();


}


public static void cancelReservation(String message){
    String[] arr = message.split(" ");
    String[] info = arr[1].split(":");
    String code = info[0];
    int id = Integer.parseInt(info[1]);
    for (Flight f : flights){
        if (f.getCode().equals(code)){
            int tamanho = f.getReservationList().size();
            if (id > tamanho){
                System.out.println("Reserva não existe!");
            }
            else{
                
                int[][] E_seats = null;
                int[][] T_seats= f.getAirplane().getSeatsT();
                if (f.getAirplane().getSeatsE() != null){
                E_seats = f.getAirplane().getSeatsE();
                }
                if (E_seats != null){
                    for (int i = 0; i<E_seats.length; i++){
                        for (int j = 0; j<E_seats[0].length; j++){
                            if (E_seats[i][j] == id){
                                E_seats[i][j] = 0;                   
                             }
                        }
                    }
                }
                

                
                    for (int i = 0; i<T_seats.length; i++){
                        for (int j = 0; j<T_seats[0].length; j++){
                            if (T_seats[i][j] == id){
                                T_seats[i][j] =0;
                            }
                        }
                    }
                System.out.println("Reserva cancelada!");
                
            }
        }
    }
}

public static void addReservation(String message){
    boolean accepted = false;
    String[] arr = message.split(" ");
    String code = arr[1];
    char classe = arr[2].charAt(0);
    int numPassengers = Integer.parseInt(arr[3]);
    Reservation r = new Reservation(numPassengers, classe);
    int last_id = 0;


    for (Flight f : flights){
        if (f.getCode().equals(code)){
            last_id = f.getReservationList().size()+1;
            r.setId(last_id);
            accepted = f.addReservation(r);
            if (accepted){


                int[][] E_seats = null;
                int[][] T_seats= f.getAirplane().getSeatsT();
                if (f.getAirplane().getSeatsE() != null){
                E_seats = f.getAirplane().getSeatsE();
                }
                String info = code+":"+last_id+" ";



                if (classe == 'E'){
                    for (int i = 0; i<E_seats.length; i++){
                        for (int j = 0; j<E_seats[0].length; j++){
                            if (E_seats[i][j] == last_id){
                                char c = (char)('A'+i); 
                                info = info +" "+c+""+(j+1)+" | ";                           
                             }
                        }
                    }
                }

                if (classe == 'T'){
                    for (int i = 0; i<T_seats.length; i++){
                        for (int j = 0; j<T_seats[0].length; j++){
                            if (T_seats[i][j] == last_id){
                                char c = (char)('A'+i); 
                                info = info +" "+c+""+(j+1)+" | ";
                            }
                        }
                    }
                }

                System.out.println(info);
                break;

            }
            else{
                System.out.println("Reserva não pode ser efetuada!");
                break;
            }
        }
    }

    
}

public static Flight obtainFlight(String fileName) {
    Flight fl = null;

    try (Scanner fsc = new Scanner(new File(new StringBuilder(fileName).append(".txt").toString()))) {
        int k = 1;
        int[][] E_seats = null;
        int[][] T_seats = null;

        while (fsc.hasNext()) {
            String line = fsc.nextLine();

            // Obtain airplane and flight information
            if (line.startsWith(">")) {
                String[] arr = line.substring(1).split(" ");

                if (arr.length == 2) {
                    String[] seats = arr[1].split("x");
                    T_seats = new int[Integer.parseInt(seats[1])][Integer.parseInt(seats[0])];
                } else { // == 3
                    String[] seats = arr[1].split("x");
                    E_seats = new int[Integer.parseInt(seats[1])][Integer.parseInt(seats[0])];

                    seats = arr[2].split("x");
                    T_seats = new int[Integer.parseInt(seats[1])][Integer.parseInt(seats[0])];
                }

                fl = new Flight(arr[0], new Airplane(E_seats, T_seats));
            } else { // Add reservations
                String[] arr = line.split(" ");
                Reservation r = new Reservation(Integer.parseInt(arr[1]), arr[0].charAt(0));
                r.setId(k);
                if (fl.addReservation(r)){
                    k++;
                }
                
                
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
        throw new RuntimeException("Something happened, Bye!");
    }

    return fl;
}


public static Flight obtainFlightFromString(String message) {
    Flight fl = null;

   
        
        int[][] E_seats = null;
        int[][] T_seats = null;

      
            String line = message;

            // Obtain airplane and flight information
        
            
                String[] arr = line.split(" ");
                if (arr.length == 3) {
                    String[] seats = arr[2].split("x");
                    T_seats = new int[Integer.parseInt(seats[1])][Integer.parseInt(seats[0])];
                } else { // == 3
                    String[] seats = arr[2].split("x");
                    E_seats = new int[Integer.parseInt(seats[1])][Integer.parseInt(seats[0])];

                    seats = arr[3].split("x");
                    T_seats = new int[Integer.parseInt(seats[1])][Integer.parseInt(seats[0])];
                }

                fl = new Flight(arr[1], new Airplane(E_seats, T_seats));
              
              return fl;
        }
    




public static void show(){
    for (Flight f : flights){
        //System.out.println(f.getAirplane().toString());
        System.out.println(f.toString());
    }
}
    
}
