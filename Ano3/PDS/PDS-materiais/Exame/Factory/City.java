public class City extends VehicleFactory implements Vehicle {

     @Override
     public String toString() {
          // TODO Auto-generated method stub
          return "City car";
     }

     @Override
     public int getMaxPassangers() {
          // TODO Auto-generated method stub
          return 3;
     
     }

     @Override
     public int getMaxVolume() {
          // TODO Auto-generated method stub
          return 250;
     }
}
