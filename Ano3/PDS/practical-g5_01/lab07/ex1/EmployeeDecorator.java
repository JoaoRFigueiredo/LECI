import java.util.Date;

public class EmployeeDecorator implements EmployeeInterface{

    protected EmployeeInterface employeeInterface;

    public EmployeeDecorator(EmployeeInterface employeeInterface){
        this.employeeInterface = employeeInterface;
    }
    
    @Override
    public void start(Date date) {
        employeeInterface.start(date);
        // System.out.println("Started at " + date.toString());
    }

    @Override
    public void terminate(Date date) {
        employeeInterface.terminate(date);
        // System.out.println("Terminated at " + date.toString());
    }

    @Override
    public void work() {
        employeeInterface.work();
        // System.out.println("Working");
    }
    
}
