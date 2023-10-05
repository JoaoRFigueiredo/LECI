<<<<<<< HEAD
// package lab03;
=======
//package lab03;
>>>>>>> 0031b8c6947045583c7ba859f34c76b0a7aca4bd

import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;

public class Voo {
    private String code;
    private Aviao plane;
    private int[][] tour_map, exec_map=null;

    private Map<String,Reserva> reservas = new HashMap<String,Reserva>();
    private int sequencial_num = 1;
    private int empty_touristic_seats, empty_executive_seats;

    public Voo(String code, Aviao plane) {
        this.code = code;
        this.plane = plane;

        this.tour_map = plane.getTouristic();
        this.exec_map = plane.getExecutive();

        this.empty_executive_seats = plane.getExecutive_seats();
        this.empty_touristic_seats = plane.getTouristic_seats();
    }

    public int getEmptySeats(Classe clss) {
        if (clss == Classe.T) {
            return empty_touristic_seats;
        }
        else {
            return empty_executive_seats;
        }
    }

    public int[][] getMap(Classe clss) {
        if (clss == Classe.T) {
            return tour_map;
        }
        else {
            return exec_map;
        }
    }

    public int[][] getExec_map() {
        return exec_map;
    }

    public int[][] getTour_map() {
        return tour_map;
    }

    public int getRows() {
        return tour_map.length + (exec_map != null ? exec_map.length : 0);
    }

    public int getMaxSeatsInRow() {
        int exec_len = (exec_map != null ? exec_map[0].length : 0);
        return tour_map[0].length > exec_len ? tour_map[0].length : exec_len;
    }

    public Aviao getPlane() {
        return plane;
    }


    public Reserva reserve(Classe clss, int num_seats) {
        int[][] seats; int num_seats_backup = num_seats;
        Map<String,int[]> seat_tickets = new TreeMap<String,int[]>();

        if (clss == Classe.T) {
            seats = tour_map;
        }
        else {
            seats = exec_map;
        }

        // In this first loop, we try to find if there are any empty rows
        for (int i = 0; i < seats.length; i++) {
            if (seats[i][0] == 0) {
                int row_seat_num = seats[0].length;
                int j = 0;
                while (num_seats > 0 && i != seats.length) {
                    seats[i][j] = sequencial_num;
                    int [] position = {i,j};

                    seat_tickets.put(String.format("%d%c",i+1,(char) (65 + j)), position); 

                    // When the row fills, start filling next row
                    j++;
                    if (j == row_seat_num) {
                        j = 0; i++;
                    }
                    num_seats--; 
                }
                break;
            }
        }

        // ----------------------------------------------------------

        // If we don't find any, we have to use whatever seats we can
        if (num_seats > 0) {
            for (int i = 0; i < seats.length && num_seats > 0; i++) {
                for (int j = 0; j < seats[0].length && num_seats > 0;j++) {
                    if (seats[i][j] == 0) {
                        seats[i][j] = sequencial_num;
                        int [] position = {i,j};

                        seat_tickets.put(String.format("%d%c",i+1,(char) (65 + j)), position);

                        num_seats--;
                    }
                }
            }
        }
        
        if (clss == Classe.T) {
            empty_touristic_seats -= num_seats_backup;
        }
        else {
            empty_executive_seats -= num_seats_backup;
        }

        
        // Add the reservation to the flight and return it
        Reserva ret_reserva = new Reserva(sequencial_num, num_seats_backup, clss, code, seat_tickets);

        reservas.put(ret_reserva.getCode(),ret_reserva);

        // Update the sequential number
        sequencial_num++;

        return ret_reserva;
    }

    public void cancelReservation(String res_code) {
        Reserva resC = reservas.get(res_code);

        if (resC.getClss() == Classe.T) {
            for (int[] seat : resC.getSeatNums()) { tour_map[seat[0]][seat[1]] = 0; }
            empty_touristic_seats += resC.getQnt();
        }
        else {
            for (int[] seat : resC.getSeatNums()) { exec_map[seat[0]][seat[1]] = 0; }
            empty_executive_seats += resC.getQnt();
        }
    }

    @Override
    public String toString() {
        if (this.empty_executive_seats != 0)
        return "Codigo de Voo " + this.code + ".Lugares disponiveis: "+this.empty_executive_seats+ " em classe Executiva; "+this.empty_touristic_seats+" em classe Turistica.";
        else 
        return "Codigo de Voo " + this.code + ".Lugares disponiveis: "+this.empty_touristic_seats+" em classe Turistica.";
    }
}
