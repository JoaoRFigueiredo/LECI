public class V1main {


     public static void main(String[] args) {
          int [] luggage;
          Vehicle v;

          //Get vehicle for 1 passanger without luggage
          v= VehicleFactory.getVehicle(1);

          // Get vehicle for 1 passanger with two items of luggage
          luggage= new int[] {100, 140};// two bags with a total volume of 240
          v = VehicleFactory.getVehicle(1, luggage);
          // Get vehicle for 3 passengers with two items of luggage
          luggage = new int[] {50, 200, 240};// three bags with a total volume of 490
          v = VehicleFactory.getVehicle(3, luggage);
          
          // Get vehicle for 2 passengers and wheelchair
          v = VehicleFactory.getVehicle(2, true);

          
          // you should add other examples here
          // Get vehicle for 2 passengers with 1 item of luggage and wheelchair
          luggage= new int[] {140};// 1 bags with a total volume of 140

          v = VehicleFactory.getVehicle(2,luggage ,true);

          // Get vehicle for 2 passengers 


          v = VehicleFactory.getVehicle(2);

     }






}