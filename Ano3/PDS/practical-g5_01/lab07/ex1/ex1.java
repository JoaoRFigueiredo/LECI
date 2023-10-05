import java.util.Date;

public class ex1 {
    public static void main(String[] args) {
        Employee e1 = new Employee();
        Employee e2 = new Employee();
        Manager m1 = new Manager(e1);
        TeamLeader tl1 = new TeamLeader(m1);
        TeamMember tm1 = new TeamMember(e1);
        TeamLeader tl2 = new TeamLeader(e2);
        TeamMember tm2 = new TeamMember(tl1);

        tl1.plan();
        tm2.collaborate();
        e1.start(new Date());
        m1.terminate(new Date());
        m1.manage();
        e2.work();

    }
}
