<<<<<<< HEAD
// package lab03;
=======
//package lab03;
>>>>>>> 0031b8c6947045583c7ba859f34c76b0a7aca4bd

import java.util.Map;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;

public class Reserva {
    private int qnt;
    private Classe clss;
    private String code;
    private Map<String,int[]> seats;
    
    public Reserva(int seq_num, int qnt, Classe clss,String flight_code, Map<String,int[]> seats) {
        this.qnt = qnt;
        this.clss = clss;
        this.code = flight_code + ":" + seq_num;
        this.seats = seats;
    }

    public int getQnt() {
        return qnt;
    }

    public Classe getClss() {
        return clss;
    }

    public String getCode() {
        return code;
    }
    
    public Set<String> getSeatNames() {
        return seats.keySet();
    }

    public List<int[]> getSeatNums() {
        return new ArrayList<int[]>(seats.values());
    }

    public Map<String,int[]> getSeats() {
        return seats;
    }

    @Override
    public String toString() {
        return code + " = " + String.join(" | ", seats.keySet());
    }

}
