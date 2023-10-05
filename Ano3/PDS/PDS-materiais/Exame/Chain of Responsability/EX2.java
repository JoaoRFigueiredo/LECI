public class EX2 {
     public static void main(String[] args) {
          //Request r1= new (request(name,type))
          // definir a chain como Rstaurant tacobell= new sushi.setsucc(new qqshti.get suc etc)
     

          Restaurant CozinhadoPaulo = new Sushi().setSucessor(new Pasta().setSucessor(new Burger().setSucessor(new Pizza().setSucessor(new Dessert()))));

          System.out.println("\nCan i please get a veggie burger?");
          Request r1= new Request("veggie burger", "burger");
          CozinhadoPaulo.restaurant(r1);

          System.out.println("\nCan i please get a Pasta Carbonara?");
          Request r2= new Request("Pasta Carbonara", "pasta");
          CozinhadoPaulo.restaurant(r2);

          System.out.println("\nCan i please get a PLAIN pizza, no toppings?");
          Request r3= new Request("PLAIN pizza, no toppings", "pizza");
          CozinhadoPaulo.restaurant(r3);

          System.out.println("\nCan i please get a nigiri and sashimi?");
          Request r4= new Request("nigiri and sashimi", "sushi");
          CozinhadoPaulo.restaurant(r4);

          System.out.println("\nCan i please get a salad with tuna?");
          Request r5= new Request("salad with tuna", "salad");
          CozinhadoPaulo.restaurant(r5);

          System.out.println("\nCan i please get a strawberry ice cream and waffles dessert?"); 
          Request r7= new Request("strawberry ice cream and waffles dessert", "dessert");
          CozinhadoPaulo.restaurant(r7);


          
          
     
     
     
 
     }






}
