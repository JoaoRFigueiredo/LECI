package e3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CampService {
    //Arraylist of Capmers
    private ArrayList<Camper> camps;
    //Arraylist of Clientes
    private ArrayList<Cliente> clientes;
    //Map key: Owner of the camp, value: Arraylist of Campers
    private Map<Owner, ArrayList<Camper>> campowners;

    public CampService() {
        this.camps = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.campowners = new HashMap<>();
    }

    public void registaCamper(Camper c, Owner o) {
        this.camps.add(c);
        if (this.campowners.containsKey(o)) {
            this.campowners.get(o).add(c);
        } else {
            ArrayList<Camper> campers = new ArrayList<>();
            campers.add(c);
            this.campowners.put(o, campers);
        }
    }

    public void registaCliente(Cliente c) {
        this.clientes.add(c);
    }

    public Camper[] getCampersDisponiveis() {
        //if camper Estado == Disponivel add camper to array
        Camper[] disponiveis = new Camper[this.camps.size()];
        int i = 0;
        for (Camper c : this.camps) {
            if (c.getEstado() instanceof Disponivel) {
                disponiveis[i] = c;
                i++;
            }
        }
        return disponiveis;

    }

    public String registaPedido(Cliente c1, Camper camper) {
        //get camper owner
        Owner o = getCamperOwner(camper);
        //add notification to owner
        if (o != null) {
            o.addNotification("Pedido de " + c1.getNome() + " para " + camper.getDescricao());
        }else{
            return "Camper não encontrado";
        }
        //print notification
        System.out.println(o.getNome() + " recebeu uma nova notificação: " + o.getNotifications().get(o.getNotifications().size() - 1));
        //set camper estado to pendente
        camper.setEstado(new Pendente());
        //return message
        return "Pedido de " + c1.getNome() + " para " + camper.getDescricao();

    }

    //get camper owner
    public Owner getCamperOwner(Camper c) {
        for (Owner o : this.campowners.keySet()) {
            for (Camper camper : this.campowners.get(o)) {
                if (camper.equals(c)) {
                    return o;
                }
            }
        }
        return null;
    }

        
    
}
