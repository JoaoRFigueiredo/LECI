package lab09.ex2;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {

    public static void main(String[] args) {
        Chef sushiChef = new SushiChef("SushiChef");
        Chef pastaChef = new PastaChef("PastaChef");
        Chef burgerChef = new BurgerChef("BurgerChef");
        Chef pizzaChef = new PizzaChef("PizzaChef");
        Chef dessertChef = new DessertChef("DessertChef");

        sushiChef.setNextChef(pastaChef);
        pastaChef.setNextChef(burgerChef);
        burgerChef.setNextChef(pizzaChef);
        pizzaChef.setNextChef(dessertChef);

        List<String> orders = new ArrayList<>();
        orders.add("Can I please get a veggie burger?");
        orders.add("Can I please get a Pasta Carbonara?");
        orders.add("Can I please get a PLAIN pizza, no toppings!?");
        orders.add("Can I please get a sushi nigiri and sashimi?");
        orders.add("Can I please get a salad with tuna?");
        orders.add("Can I please get a strawberry ice cream and waffles dessert?");


        for (String dish : orders){
            System.out.println(dish);
            sushiChef.cook(dish);
        }

        
    }
    
    
    
}

