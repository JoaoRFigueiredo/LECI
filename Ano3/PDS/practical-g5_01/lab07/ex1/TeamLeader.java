import java.util.Date;

public class TeamLeader extends EmployeeDecorator{
    
    public TeamLeader(EmployeeInterface employeeInterface) {
        super(employeeInterface);
    }

    public void start(Date date){
        super.start(date);
    }

    public void terminate(Date date){
        super.terminate(date);
    }

    public void work(){
        super.work();
    }

    public void plan(){
        System.out.println("Planning");
    }
}
