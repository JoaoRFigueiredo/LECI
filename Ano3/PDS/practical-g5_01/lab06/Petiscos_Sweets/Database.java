import java.util.Vector;

public class Database {
    // Data elements
    private Vector<Employee> employees; // Stores the employees


    public Database() {
    employees = new Vector<>();
    }


    public boolean addEmployee(Employee employee) {
    // Code to add employee
    boolean added = false;
    if (!employees.contains(employee)){
    if (employees.add(employee)){
        added = true;
    }
}

    return added;

    }
    public void deleteEmployee(long emp_num) {
    // Code to delete employee
    for (Employee e : employees){
        if (e.getEmpNum() == emp_num){
            employees.remove(e);
            break;
        }
    }
    }
    public Employee[] getAllEmployees() {
    // Code to retrieve collection
    Employee[] emp = employees.toArray(new Employee[employees.size()]);
    return emp;
    }
    }