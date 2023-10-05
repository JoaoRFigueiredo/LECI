import java.util.Date;

public class TeamMember extends EmployeeDecorator{

    public TeamMember(EmployeeInterface employeeInterface) {
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

    public void collaborate(){
        System.out.println("Collaborating");
    }
}
