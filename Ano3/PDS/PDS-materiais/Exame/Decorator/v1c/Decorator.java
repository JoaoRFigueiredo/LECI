package v1.v1c;
import java.util.Date;

public abstract class Decorator implements EmpInterface{
     EmpInterface interf;
	
	public Decorator(EmpInterface interf) {
        this.interf = interf;
    }

    public void start(Date date) {
        this.interf.start(date);
    }

    public void terminate(Date date) {
        this.interf.terminate(date);
    }

    public void work() {
        this.interf.work();
    }

}
