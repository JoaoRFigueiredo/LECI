import java.util.ArrayList;
public class Manager implements Observer{
     String name;
	ArrayList<Product> products = new ArrayList<>();
	public Manager(String name) {
		this.name=name;
	}

	@Override
	public void update(String s) {
		System.out.println(s);
	}
	@Override
	public String getType() {
		return "Manager";
	}
	
	public String getName() {
		return name;
	}
	
	public void addProduct(Product p) {
		products.add(p);
		p.addObserver(this);
	}
	
     //produto, tempo max para dar bid
     public void startLeilao(Product p, int timetobid) {
		p.makeAlive(timetobid);
	}
}
