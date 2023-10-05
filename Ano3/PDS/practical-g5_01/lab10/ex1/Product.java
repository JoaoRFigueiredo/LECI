
import java.util.Date;
import java.util.ArrayList;

public class Product {
    private static int codeGen = 0;

    private int code;
    private String desc;
    private double price;
    private State state;

    ArrayList<Observer> participants;
    Date startTime;
    int maxTime = 0;

    public Product(int basePrice) {
        this.code = codeGen++;
        this.price = basePrice;
        this.state=State.Stock;
		this.participants=new ArrayList<>();
    }

    public boolean makeBid(double v, Observer o) {
        Date currentTime = new Date();
        int seconds = 0;
        if(startTime != null) {
            seconds = (int) ((currentTime.getTime() - startTime.getTime()) / 1000);
        }
        if(v >= price || this.state != State.Auction || o.getType() != "Client") {
            if(seconds > maxTime) {
				state=State.Sold;
			}else {
                price=v;
                System.out.println("Elapsed " + seconds + " seconds.");
                notify(" New bid for " + v + " by "+o.getName()+" for "+this.desc);

			    return false;
            }
        }

        price = v;
        return true;
    }

    public boolean addObserver(Observer o) {
        if(this.state == State.Auction) {
            participants.add(o);
            return true;
        }

        return false;
    }

    public void startAuction(int maxTime) {
        this.state = State.Auction;
        this.maxTime = maxTime;
        this.startTime = new Date();
    }

    public void notify(String s) {
        for(Observer p : participants) {
            p.update("[" + p.getType() + " - " + p.getName() + "]" + s + "\n");
        }
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getCode() {
        return this.code;
    }

    public String getDesc() {
        return this.desc;
    }
}

enum State {
    Stock, Auction, Sold
}