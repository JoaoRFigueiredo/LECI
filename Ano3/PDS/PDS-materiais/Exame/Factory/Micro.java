public class Micro extends VehicleFactory implements Vehicle {
     

     @Override
     public String toString() {
          // TODO Auto-generated method stub
          return "Micro car";
     }



     @Override
     public int getMaxPassangers() {
          // TODO Auto-generated method stub
          return 1;
     }
     @Override
     public int getMaxVolume() {
          // TODO Auto-generated method stub
          return 250;
     }
}
