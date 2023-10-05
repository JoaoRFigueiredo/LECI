import java.util.concurrent.TimeUnit;

public class Ex1 {
    public static void main(String[] args) throws InterruptedException {
        Product p1 = new Product(20000);
        p1.setDesc("Lápis");
        Product p2 = new Product(6);
        p2.setDesc("Estojo");
        Product p3 = new Product(499);
        p3.setDesc("Garrafas");
        Product p4 = new Product(30000);
        p4.setDesc("Legumes");
        Product p5 = new Product(1);
        p5.setDesc("Gelado");

        Client c1 = new Client("Joao");
        Client c2 = new Client("Miguel");
        Client c3 = new Client("Luis");

        Manager m1 = new Manager("Luisa");
        m1.addProduct(p1);
        m1.addProduct(p2);
        m1.addProduct(p3);
        m1.addProduct(p4);
        m1.addProduct(p5);

        m1.startAuction(p1, 3);
		m1.startAuction(p2, 3);
		m1.startAuction(p4, 3);
		m1.startAuction(p5, 3); 

        p1.addObserver(c1);
		c1.bid(p1, 50000); 
		
		TimeUnit.SECONDS.sleep(1); 
		p2.addObserver(c3);
		c3.bid(p2, 100000001); 
		
		p3.addObserver(c3);
		c3.bid(p3, 499); 
		
		TimeUnit.SECONDS.sleep(1); 
		p4.addObserver(c1);
		c1.bid(p4, 30000); 
	
		p5.addObserver(c2);
		c2.bid(p5, 2); 
		
		TimeUnit.SECONDS.sleep(2); 
		p1.addObserver(c2);
		c2.bid(p1, 40000); 
    }
}
