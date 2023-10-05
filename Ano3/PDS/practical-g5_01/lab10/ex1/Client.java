
public class Client implements Observer {
    private String name;
    
    public Client(String name) {
        this.name = name;
    }

    @Override
    public void update(String s) {
        System.out.print(s);
    }

    @Override
    public String getType() {
        return "Client";
    }

    @Override
    public String getName() {
        return name;
    }

    public void bid(Product p, double value) {
        if (p != null) {
            p.makeBid(value, this);
        } else {
            System.out.println("That product doesn't exist.");
        }
    }
}
