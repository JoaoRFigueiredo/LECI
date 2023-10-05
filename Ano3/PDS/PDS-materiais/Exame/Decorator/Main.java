package v1;
import java.util.Date;
import v1.v1c.*;
public class Main {

	public static void main(String[] args) {
		EmpInterface empregado = new Employee("Pedro");
        empregado.start(new Date());
        empregado.work();
        empregado.terminate(new Date());
        Manager manager = new Manager(empregado);
        manager.start(new Date());
        manager.work();
        manager.terminate(new Date());package v2;
        TeamLeader teamLeader = new TeamLeader(new Employee("Vasco"));
        teamLeader.start(new Date());
        teamLeader.work();
        teamLeader.terminate(new Date());
        Teammember teamMember = new Teammember(new Employee("Paulo"));
        teamMember.start(new Date());
        teamMember.work();
        teamMember.terminate(new Date());

      

       
        //big boss
        Manager mn2 = new Manager(new TeamLeader(new Teammember(new Employee("Nuno Fahla"))));
        mn2.start(new Date());
        mn2.work();
        mn2.terminate(new Date());
	}

}