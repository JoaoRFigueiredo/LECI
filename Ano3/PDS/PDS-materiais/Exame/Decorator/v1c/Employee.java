package v1.v1c;
import java.util.Date;
/**
 * Employee
 */
public class Employee implements EmpInterface{

     private Date startW,endW;
     private String name;
     

     public Employee(String name){
          this.name=name;
     }


     @Override
     public void start(Date d) {
          // TODO Auto-generated method stub
          this.startW=d;
          
     }


     @Override
     public void terminate(Date d) {
          // TODO Auto-generated method stub
          this.endW=d;
          
     }


     @Override
     public void work() {
          // TODO Auto-generated method stub
          System.out.println("Worker: "+ name+" is working!");
          
     }


}