public class Family extends VehicleFactory implements Vehicle{

     @Override
     public String toString() {
          // TODO Auto-generated method stub
          return "Family car";
     }

     @Override
     public int getMaxPassangers() {
          // TODO Auto-generated method stub
          return 4;
     }

     @Override
     public int getMaxVolume() {
          // TODO Auto-generated method stub
          return 600;
     }
     
}