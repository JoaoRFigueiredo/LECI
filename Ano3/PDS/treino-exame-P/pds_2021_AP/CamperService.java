import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CamperService implements IService{
    //Owner has campers
    private ArrayList<Owner> owners;
    //list of Users
    private ArrayList<Utilizador> users;
    //list of Campers
    private ArrayList<Camper> campers;
    //Map of Campers and Clients
    private Map<Cliente, ICamper> orders;
    //Map of Campers and owners
    private Map<Owner, ICamper> campowners;

    public CamperService() {
        this.owners = new ArrayList<>();
        this.users = new ArrayList<>();
        this.campers = new ArrayList<>();
        this.orders = new HashMap<>();
        this.campowners = new HashMap<>();
    }

    @Override
    public void registaUtilizador(Utilizador u) {
        //if user == Owner add to owners
        if(u instanceof Owner){
            owners.add((Owner) u);
        }
        //else add to users
        else{
            users.add(u);
        }
        
    }

    @Override
    public ICamper registaCamper(Owner p, int lugares, String descrição) {
        //Create Camper
        Camper c = new Camper(lugares, descrição);
        //Add Camper to campers
        campers.add(c);
        //Add Owner,Camper to campowners
        campowners.put(p, c);
        //Return Camper
        return c;
    }

    @Override
    public String registaPedido(Cliente u, ICamper c) {
        //Add key: Cliente, value: Camper to orders
        //Check camper estado
        if(c.getEstado() == Estado.Disponivel){
            orders.put(u, c);
            //Change camper estado
            c.setEstado(Estado.Pendenete);
        }
        //Return message
        //Camper + Camper.getNome alugada por Cliente + Cliente.getNome
        return c.getDescricao() + " pedida por " + u.getNome();
    }

    @Override
    public String cancelaPedido(Cliente u, ICamper c) {
        //check if u in orders
        if(orders.containsKey(u)){
            //remove from orders
            orders.remove(u);
            //change camper estado
            c.setEstado(Estado.Disponivel);
        }

        //Return message
        //Camper + Camper.getNome devolvida por Cliente + Cliente.getNome
        return c.getDescricao() + " devolvida por " + u.getNome();
    }

    @Override
    public String aceitaPedido(Cliente u, ICamper c) {
        //if camper estado == Pendente and owner,camper exists in campowners, camper estado = Reservado
        if(c.getEstado() == Estado.Pendenete && campowners.containsValue(c)){
            c.setEstado(Estado.Reservado);
        }
        //Return message
        //Pedido de Camper + Camper.getNome aceite por Owner + Owner.getNome
        return "Pedido de "+ u.getNome() + " para " + c.getDescricao() + ": Aceite";

    }

    @Override
    public String rejeitaPedido(Cliente u, ICamper c) {
        //if camper estado == Pendente and owner,camper exists in campowners, camper estado = Disponivel
        //check if value in campowners == c
        if(c.getEstado() == Estado.Pendenete && campowners.containsValue(c)){
            c.setEstado(Estado.Disponivel);
        }
        
        //Return message
        //Pedido de Camper + Camper.getNome rejeitado por Owner + Owner.getNome
        return "Pedido de "+ u.getNome() + " para " + c.getDescricao() + ": Rejeitado";
    }

    @Override
    public String registaDevolucao(Cliente u, ICamper c) {
        // if camper estado == Reservado and cliente,camper exists in orders, camper estado = Disponivel
        if(c.getEstado() == Estado.Reservado && orders.containsKey(u)){
            orders.get(u).setEstado(Estado.Disponivel);
        }
        //Return message
        //Devolucao de Camper + Camper.getNome devolvida por Cliente + Cliente.getNome
        return "Devolucao de " + c.getDescricao() + " devolvida por " + u.getNome();
    }

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
