/**
 * Restaurant
 */

public abstract class Restaurant {
     protected int max=20;
     protected int min=5;
     protected int rand=(int)(Math.random()*(max-min+1)+min);
     private Restaurant successor=null;
     public void restaurant(Request r) {

          if(successor!=null) {
			successor.restaurant(r); 
		}else {
			System.out.println("We're sorry but that request can't be satisfied by our service!");
		}
     }

     protected boolean canMake(Request r, String type){
          return (r != null) && (r.getType()==type); 
     }

     public Restaurant setSucessor(Restaurant successor) {
		this.successor=successor;
		return this;
	}
}
class Sushi extends Restaurant{
	@Override
	public void restaurant(Request r) {
		if(canMake(r, "sushi")) {
			System.out.println("Starting to cook sushi "+r.getName()+".Out in "+rand+ " minutes!")  ;
		}else {
               System.out.println("SushiChef: I can't cook that.");

			super.restaurant(r);
		}
	}
}
class Pasta extends Restaurant{
	@Override
	public void restaurant(Request r) {
		if(canMake(r, "pasta")) {
			System.out.println("Starting to cook pasta "+r.getName()+".Out in "+rand + " minutes!")  ;
		}else {
               System.out.println("PastaChef: I can't cook that.");

			super.restaurant(r);
		}
	}
}
class Burger extends Restaurant{
	@Override
	public void restaurant(Request r) {
		if(canMake(r, "burger")) {
			System.out.println("Starting to cook burger "+r.getName()+".Out in "+rand + " minutes!")  ;
		}else {
               System.out.println("BurgerChef: I can't cook that.");
			super.restaurant(r);
		}
	}
}
class Pizza extends Restaurant{
	@Override
	public void restaurant(Request r) {
		if(canMake(r, "pizza")) {
			System.out.println("Starting to cook pizza "+r.getName()+".Out in "+rand + " minutes!")  ;
		}else {
               System.out.println("PizzaChef: I can't cook that.");

			super.restaurant(r);
		}
	}
}
class Dessert extends Restaurant{
	@Override
	public void restaurant(Request r) {
		if(canMake(r, "dessert")) {
			System.out.println("Starting to cook dessert "+r.getName()+".Out in "+rand + " minutes!")  ;
		}else {
               System.out.println("DessertChef: I can't cook that.");

			super.restaurant(r);
		}
	}
}