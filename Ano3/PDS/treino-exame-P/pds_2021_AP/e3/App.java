package e3;

public class App {
    public static void main(String[] args) {
        CampService cs = new CampService();
        Cliente c1 = new Cliente("João", "Aveiro", 20);
        Cliente c2 = new Cliente("Maria", "Aveiro", 20);
        Cliente c3 = new Cliente("Pedro", "Aveiro", 20);

        cs.registaCliente(c1);
        cs.registaCliente(c2);
        cs.registaCliente(c3);

        Owner o1 = new Owner("Manuel", "Porto", 55);
        Owner o2 = new Owner("Henrique", "Porto", 55);
        Owner o3 = new Owner("Mário", "Porto", 55);

        Camper ca1 = new Camper(4, "MotorHome com quatro lugares, 3 camas, cozinha, mesa, WC.");
        Camper ca2 = new Camper(2, "Camper van com dois lugares, 1 cama, cozinha, mesa, WC.");
        Camper ca3 = new Camper(2, "Tenda de tejadilho para duas pessoas, de montagem rápida.");
        Camper ca4 = new Camper(6, "Tenda de tejadilho para 6 pessoas, de montagem rápida.");

        cs.registaCamper(ca1, o1);
        cs.registaCamper(ca2, o2);
        cs.registaCamper(ca3, o3);
        cs.registaCamper(ca4, o1);

        System.out.println("\n--- Campers disponíveis :" );

        for (Camper camper : cs.getCampersDisponiveis())
            System.out.println(camper);
        System.out.println("\n" );

        //Create 1 Pedido
        String p1 = cs.registaPedido(c1, ca1);

        //owner 1 accpets the order
        o1.aceitaPedido(p1, ca1);

        System.out.println("\n--- Campers disponíveis :" );

        for (Camper camper : cs.getCampersDisponiveis())
            System.out.println(camper);
        System.out.println("\n" );
    }
}
