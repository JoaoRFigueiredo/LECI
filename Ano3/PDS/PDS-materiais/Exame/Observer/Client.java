
public class Client implements Observer{
	String name;
	public Client(String name) {
		this.name=name;
	}

	@Override
	public void update(String s) {
		System.out.println(s);
	}
	@Override
	public String getType() {
		return "Client";
	}
	
	public String getName() {
		return name;
	}
	
	public void bid(Product p, double money){
          if(p!=null){
               p.makebid(money,this);

          }else{
               System.out.println("Can't bid on a non existent item");
          }
     }
	}
