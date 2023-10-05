import java.util.ArrayList;
import java.util.Date;

enum State{
	stock, leilao, sold
}

public class Product {

     int uid=0;
	String desc;
	double price;
	State state;
	ArrayList<Observer> participants;
	Date startTime;
	int maxTime=0;
	public Product(int uid,String desc, double price) {
		this.uid=uid;
		this.desc=desc;
		this.price=price;
		this.state=State.stock;
		participants=new ArrayList<>();
	}


     public boolean makebid(double v, Observer o) {	
		Date currentTime = new Date();
		int seconds=0;
		if(startTime!=null) {
			seconds = (int)((currentTime.getTime() - startTime.getTime()) / 1000);
		}
		
		if(v<=price || this.state!=State.leilao || seconds > maxTime || o.getType()!="Client") {
			if(seconds > maxTime) {
				state=State.sold;
			}
			return false;
		}else {
			price=v;
				System.out.println("Elapsed " + seconds + " seconds.");
			notify(" New bid for " + v + " by "+o.getName()+" for "+this.desc);
			
		}
		return true;
	}


     public boolean addObserver(Observer o) {
		if(this.state==State.leilao) {
			participants.add(o);
			return true;
		}else {
			return false;
		}
		
	}
	
	// iniciar leilao dum produtos
	public void makeAlive(int mt) {
		this.state=State.leilao;
		startTime = new Date();
		maxTime=mt;
	}
	
	// notifica todos os Observers 
	public void notify(String s) {
		for(Observer p : participants) {
			p.update("[" + p.getType() + " - " + p.getName() + "]" + s);
		}
	}
}
