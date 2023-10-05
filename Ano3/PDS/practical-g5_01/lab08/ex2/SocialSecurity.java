import java.util.List;
import java.util.ArrayList;

public class SocialSecurity {
    private List<Employee> empList;

    public SocialSecurity(){
        this.empList = new ArrayList<Employee>(); 
        
    }

    public void regist(Employee e) {
        if (!empList.contains(e)){
            empList.add(e);
        }
    }

    public List<Employee> getSocialSecurityRegist() {
        return empList;
    }
    
}
