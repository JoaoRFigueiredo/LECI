import java.util.ArrayList;
import java.util.List;

public class CompanyFacade {
    private List<Card> cards;
    private Company comp;
    private Insurance insurance;
    private Parking park;
    private SocialSecurity socialsecurity;

    public CompanyFacade(){
        comp = new Company();
        insurance = new Insurance();
        park = new Parking();
        socialsecurity = new SocialSecurity();
        cards = new ArrayList<Card>();
    }


    public void admitEmployee(Person p, double salary){
        Employee e = new Employee(p, salary);
        this.comp.admitEmployee(p, salary);
        Card c = new Card(p.getName());
        e.addCard(c);
    }

    public void paySalaries(int month){
        this.comp.paySalaries(month);
    }

    public List<Employee> employees() {
		return this.comp.employees();
	}
}
