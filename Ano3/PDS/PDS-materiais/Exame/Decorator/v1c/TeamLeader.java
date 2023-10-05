package v1.v1c;

import java.util.Date;

public class TeamLeader extends Decorator {
     public TeamLeader(EmpInterface interf) {
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
		plan();
	}
	
	public void plan() {
		System.out.println("I lead things around here!");
	}
     

     
}
