import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BasicCamperService implements ICamperService{
    //list of Clients
    private ArrayList<Utilizador> clients;
    //list of Campers
    private ArrayList<Camper> campers;
    //Map of Campers and Clients
    private Map<Cliente, ICamper> orders;


    public BasicCamperService() {
        this.clients = new ArrayList<>();
        this.campers = new ArrayList<>();
        this.orders = new HashMap<>();
    }

    @Override
    public void registaUtilizador(Utilizador u) {
        //Add Utilizador to clients
        clients.add(u);   
    }

    @Override
    public ICamper registaCamper(int lugares, String descricao) {
        //Create Camper
        Camper c = new Camper(lugares, descricao);
        //Add Camper to campers
        campers.add(c);
        //Return Camper
        return c;
    }

    @Override
    public String registaAluguer(Cliente u, ICamper c) {
        //Add key: Cliente, value: Camper to orders
        //Check camper estado
        if(c.getEstado() == Estado.Disponivel){
            orders.put(u, c);
            //Change camper estado
            c.setEstado(Estado.Reservado);
        }
        //Return message
        //Camper + Camper.getNome alugada por Cliente + Cliente.getNome
        return c.getDescricao() + " alugada por " + u.getNome();

    }

    @Override
    public String terminaAluguer(Cliente u, ICamper c) {
        //if camper estado == Reservado remove from map and camper estado == Disponivel
        if(c.getEstado() == Estado.Reservado){
            orders.remove(u);
            c.setEstado(Estado.Disponivel);
        }
        //Return message
        //Camper + Camper.getNome devolvida por Cliente + Cliente.getNome
        return c.getDescricao() + " devolvida por " + u.getNome();
    }
    
    //getCampersDisponiveis()
    public ArrayList<ICamper> getCampersDisponiveis() {
        //Create ArrayList of ICamper
        ArrayList<ICamper> campersDisponiveis = new ArrayList<ICamper>();
        //For each Camper
        for (Camper c : campers) {
            //if estado == Disponivel
            if (c.getEstado() == Estado.Disponivel) {
                //Add Camper to campersDisponiveis
                campersDisponiveis.add(c);
            }
        }
        //Return campersDisponiveis
        return campersDisponiveis;
    }
}
