package v1;

public class Plugin1 implements IPlugin{
     @Override
     public void fazQualQuerCoisa() {
          System.out.println("\nSei contar até 10 queres ver?");
          System.out.println("Se disseste não, não tens opinião\n");
          for (int i = 1; i < 11; i++) {
               System.out.println(i);
               
          }
          System.out.println("Viste? Devias estudar teórica de PDS que não é facil como contar até 10!");
          
     }
     
}
