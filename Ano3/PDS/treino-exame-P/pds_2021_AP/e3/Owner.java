package e3;

import java.util.ArrayList;

public class Owner extends Utilizador{

    //private String notifications;
    private ArrayList<String> notifications;


    public Owner(String nome, String localidade, int idade) {
        super(nome, localidade, idade);
        this.notifications = new ArrayList<>();
    }

    public void addNotification(String notification) {
        this.notifications.add(notification);
    }

    public ArrayList<String> getNotifications() {
        return this.notifications;
    }

    //Aceita pedido
    public void aceitaPedido(String pedido, Camper c) {
        //if pedido in notifications
        if (this.notifications.contains(pedido)) {
            //remove notification
            this.notifications.remove(pedido);
            System.out.println(this.getNome() + " aceitou o pedido " + pedido);
            c.setEstado(new Reservado());
        }else{
            System.out.println("Pedido não encontrado");
        }
    }
}
