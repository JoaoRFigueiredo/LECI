import java.time.LocalDate;
import java.util.List;

public class Event implements IEvent{
    private List<Activity> activities;
    LocalDate date;
    Client c;

    public Event(Client c, LocalDate date){
        this.c = c;
        this.date = date;
    }

    public Client getClient(){
        return c;
    }

    

    

    public void setClient(Client t ){
        this.c = t;
    }

    public String toString(){
        int dinheiro = 0;
        for(Activity at : activities){

            if(at.getClass().toString().equalsIgnoreCase("Sport")){
                dinheiro = dinheiro + at.getNum()*30;
            }
            else if (at.getClass().toString().equalsIgnoreCase("Culture")){
                dinheiro = dinheiro + at.getNum()*25;
            }
            else{
                dinheiro = dinheiro + at.getNum()*35;
            }
            
        }
        String ans = "*** Evento em "+this.date.toString()+", total "+dinheiro+" euros";
        for(Activity at : activities){
            ans += "\n";
            

        }

        return ans;
    }

    
    

    @Override
    public Event addActivity(Activity activity) {
       activities.add(activity);
       return new Event(c, date);
        
    }

    @Override
    public LocalDate getDate() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public double getTotalCost() {
        // TODO Auto-generated method stub
        return 0;
    }

   

    
}
