import java.util.List;
import java.util.ArrayList;


public class Parking {
    private List<Employee> parkingList; //list with the people inside the parking lot


    public Parking(){
        this.parkingList = new ArrayList<Employee>();

    }

    public void allowParking(Employee e, List<Employee> companyEmp){
        //list with all the company employees
        int avg = 0;
        for (Employee p : companyEmp){
            avg += e.getSalary();
        }
        avg = avg/companyEmp.size(); // average salary

        // only gets in the salary is above average (and if the person isn't already in :/  )
        if (!parkingList.contains(e) && e.getSalary()>avg){
            parkingList.add(e);
        }
        else if (!parkingList.contains(e) && e.getSalary()<=avg){
            System.out.println("Salary bellow average, get Scammed out of using the company parking lot");
        }
        else{
            System.out.println("Already in!");
        }
    }

    public List<Employee> getParkingList(){
        return parkingList;
    }
    
}
