import java.util.stream.*;
public class VehicleFactory {

     private static Vehicle[] vehicles = new Vehicle[] { new Scooter(), new Micro(), new City(), new Family(), new Van() };

     public static Vehicle getVehicle(int NPassanger, int [] luggage, boolean option) {
          int totalLuggageWeight = 0;

          for (int weight: luggage) {
               if (totalLuggageWeight <= 0) { 
                    System.err.println("Luggage Weight can't be negative");
                    return null;
               }

               totalLuggageWeight += weight;
          }
          
          Vehicle v = checkAttribute(NPassanger, totalLuggageWeight, option);
          if (v != null)
               System.out.println("Vehicle for " + NPassanger + " passengers" + ((luggage != null) ? (" with " + luggage.length + " items of luggage") : "") + ((option) ? " and wheelchair" : "") + ": Use a " + v.toString());
          else
               System.out.println("There is no vehicle that fulfills your criteria");
          return v;
     }

     public static Vehicle getVehicle(int NPassanger, boolean option) {
          return getVehicle(NPassanger, new int[] {}, option);
     }

     public static Vehicle getVehicle(int NPassanger, int [] luggage) {
          return getVehicle(NPassanger, luggage, false);
     }

     public static Vehicle getVehicle(int NPassanger) {
          return getVehicle(NPassanger, false);
     }

     private static Vehicle checkAttribute(int passegers, int totalLuggageWeight, boolean wheelchair) {          
          if (wheelchair) {
               Vehicle v = vehicles[vehicles.length - 1];

               if(passegers<=v.getMaxPassangers() && totalLuggageWeight<=v.getMaxVolume())
                    return v;
               return null;
          }

          for (Vehicle vehicle : vehicles)
               if(passegers<=vehicle.getMaxPassangers() && totalLuggageWeight<=vehicle.getMaxVolume())
                    return vehicle;

          return null;
     }
 
}

