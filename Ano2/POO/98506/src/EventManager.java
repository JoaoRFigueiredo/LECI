import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;



public class EventManager {
    private String nome;
   private TreeMap<Client, Event> map; //associar clientes a eventos
   private Set<Client> set; //guardar clientes, com sets não haverão repetidos

    public EventManager(String nome){
        this.nome = nome;
        this.map = new TreeMap<>(); 
        this.set = new HashSet<>();
    }

    public Client addClient(String nome, String localidade){
        Client c = new Client(nome, localidade);
       set.add(c);
       return c;
    }

    public Event addEvent(Client t, LocalDate d){
        Event evt = new Event(t, d);
        map.put(t, evt);
        return evt;
    }

    public String getName(){
        return nome;
    }

    public void setName(String n){
        this.nome = n;
    }

    public ArrayList<String> getAllEventsByDate()throws IOException{
        List<String> lst = Files.readAllLines(Paths.get("events.txt"));
       return null;
    }

    
    

    public ArrayList<String> getAllClientsWithEvents() throws IOException{
        List<String> lst = Files.readAllLines(Paths.get("events.txt"));
        List<String> nova = new ArrayList<>();
        for(String s : lst){
            if(s.startsWith("#")){
                nova.add(s);
            }
        }

        return (ArrayList<String>) nova;
    }

    

    public String listClients() {
        String ans = "Clients: \n";
        for (Client c : set){
            ans += c.toString()+"\n";
        }

        return ans;
        
    }

    public String toString(){
        return this.getName();
    }
    
}
