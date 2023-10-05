import java.util.List;
import java.util.ArrayList;


public class Insurance {
    private List<Employee> empList;


    public Insurance(){
        this.empList = new ArrayList<Employee>();
    }

    public void regist(Employee e) {
        if (!empList.contains(e)){
            empList.add(e);
        }
    }

    public List<Employee> getInsuranceRegist() {
        return empList;
    }
    
}
