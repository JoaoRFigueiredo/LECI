import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class BasicCamperService implements ICamperService {
    private ArrayList<Utilizador> clients;
    private ArrayList<Camper> campers;
    private HashMap<Cliente, ICamper> mapa;


    public BasicCamperService(){
        this.clients = new ArrayList<>();
        this.campers = new ArrayList<>();
        this.mapa = new HashMap<>();
    }

    public void registaUtilizador(Utilziador u){
        clients.add(u);
    }

    public ICamper registaCamper(int lugares, String descricao){
        ICamper c = new Camper(lugares, descricao);
        campers.add((Camper)c);
        return c;
    }

    public String registaAluguer(Cliente u, ICamper c){
        if (c.getEstado() == Estado.DISPONIVEL){
        mapa.put(u, (Camper)c);
        c.setEstado(Estado.RESERVADO);
        }

        return c.getDescricao()+" alugada por "+u.getNome();

    }

    public String terminaAluguer(Cliente u, ICamper c){
        if (c.getEstado() == Estado.RESERVADO){
            mapa.remove(u, c);
            c.setEstado(Estado.DISPONIVEL);
        }
        return c.getDescricao()+" devolvida por "+u.getNome();
    }

    public ArrayList<ICamper> getCampersDisponiveis(){
        ArrayList<ICamper> available = new ArrayList<>(); 

        for (Camper c : campers){
            if (c.getEstado() == Estado.DISPONIVEL){
                available.add(c);
            }
        }

        return available;
        
    }
    
}
