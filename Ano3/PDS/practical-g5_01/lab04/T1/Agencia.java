//package lab03;
import java.util.Map;
import java.util.HashMap;

public class Agencia {
    
    Map <String, Voo> voos_agencia;

    public Agencia() {
        this.voos_agencia = new HashMap <String, Voo>();
    }

    public Map<String, Voo> getVoos() {
        return voos_agencia;
    }

    public void addVoo(String codigo_voo, Voo voo) {
        this.voos_agencia.put(codigo_voo, voo);
    }

    public void showVoo(String flight_code) {
        Voo flight = voos_agencia.get(flight_code);
        int row_max = flight.getRows(); int seat_max = flight.getMaxSeatsInRow();
        int[][] touristic = flight.getTour_map(); int[][] executive = flight.getExec_map();
        int mid_point = executive != null ? executive.length : 0;

        System.out.print("  ");
        for (int i=1; i <= row_max; i++) {
            System.out.printf("%2d ",i);
        }
        System.out.println();

        char c = 'A';
        for (int i=0;i < seat_max; i++) {
            System.out.print(c + " ");
            if (mid_point != 0) {
                if (i < executive[0].length) {
                    for (int j = 0; j < executive.length;j++) {
                        System.out.printf("%2d ",executive[j][i]);
                    }
                }
                else {
                    System.out.print("   ".repeat(executive.length));
                }
            }
            
            if (i < touristic[0].length){
                for (int j = 0; j < touristic.length;j++) {
                    System.out.printf("%2d ",touristic[j][i]);
                }
            }

            c++;
            System.out.println();
        }
    }

    public Reserva reserve(String flight_code,Classe clss, int qnt) {
        if (voos_agencia.get(flight_code).getEmptySeats(clss) - qnt < 0) {
            System.out.println("Não foi possível obter lugares para a reserva: " + clss.name() + " " + String.valueOf(qnt));
            return null;
        }
        return voos_agencia.get(flight_code).reserve(clss, qnt);
    }

    public void cancelReservation(String flight_code, String res_code) {
        voos_agencia.get(flight_code).cancelReservation(res_code);
    }

    @Override
    public String toString() {
        return "Agencia [voos=" + voos_agencia + "]";
    }

    
}
