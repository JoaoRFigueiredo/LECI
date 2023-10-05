public class Van  extends VehicleFactory implements Vehicle {

     @Override
     public String toString() {
          // TODO Auto-generated method stub
          return "Van";
     }

     @Override
     public int getMaxPassangers() {
          // TODO Auto-generated method stub
          return 4;
     }
     
     @Override
     public int getMaxVolume() {
          // TODO Auto-generated method stub
          return 1000;
     }
     
}
