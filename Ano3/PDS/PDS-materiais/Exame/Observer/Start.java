import java.util.concurrent.TimeUnit;

public class Start {
	public static void main(String[] args) throws InterruptedException {
		
		Product p1 = new Product(1,"Divida do BES", 5);
		Product p2 = new Product(2,"Mortalhas do Fahla", 100000000);
		Product p3 = new Product(3,"iPhone scammado à mary of the Channels", 90);
		Product p4 = new Product(4,"Plantation of the Artures", 20000);
		Product p5 = new Product(5,"Bocado de Alcatrão ", 1);
		
		Client c1 = new Client("Pablito");
		Client c2 = new Client("Pedrofilo");
		Client c3 = new Client("xXPVP420MASTERXx");
		
		Manager m1 = new Manager("Herman Jose");
		m1.addProduct(p1);
		m1.addProduct(p2);
		m1.addProduct(p3);
		m1.addProduct(p4);
		m1.addProduct(p5);
		
		
		m1.startLeilao(p1, 3);
		m1.startLeilao(p3, 3);
		m1.startLeilao(p4, 3);
		m1.startLeilao(p5, 3);
		
		p1.addObserver(c1);
		c1.bid(p1, 6);
		
		TimeUnit.SECONDS.sleep(1);
		p2.addObserver(c3);
		c3.bid(p2, 100000001); // Won't run because Mortalhas do Fahla are too good to be bought with cash, also there isn't a leilao for p2
		
		p3.addObserver(c3);
		c3.bid(p3, 100);
		
		TimeUnit.SECONDS.sleep(1);
		p4.addObserver(c1);
		c1.bid(p4, 30001);
	
		p5.addObserver(c2);
		c2.bid(p5, 2);
		
		TimeUnit.SECONDS.sleep(1);
		p1.addObserver(c2);
		c2.bid(p1, 7); 
		
		TimeUnit.SECONDS.sleep(2); // too late my friend
		p1.addObserver(c2);
		c2.bid(p1, 8); 
	}
}