package lab12.v3;

public class Main {
     public static void main(String[] args) {
          Ship s = new Ship("BelaRia", 200);
          s.setOwner(new Owner("Manuel"));
          s.setPassageiros(new String[] {"Manuel", "Amilcar"});
          System.out.println( PDSSerializer.fromObject(s) );
     }
     
}
