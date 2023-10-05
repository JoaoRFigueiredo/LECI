package v1.v1c;

import java.util.Date;

public class Manager extends Decorator {
     public Manager(EmpInterface interf) {
          super(interf);


     
     }
     
     @Override
	public void start(Date d) {
		super.start(d);
	}

	@Override
	public void terminate(Date d) {
		super.terminate(d);
	}

	@Override
	public void work() {
		super.work();
		manage();
	}
	
	public void manage() {
		System.out.println("I manage things around here!");
	}
     

     
}
