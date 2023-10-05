import java.util.Vector;

public class Database {
  private Vector<Employee> employees; // Stores the employees

  public Database() {
    employees = new Vector<>();
  }

  public boolean addEmployee(Employee employee) {
    // Code to add employee
    return employees.add(employee);
  }

  public void deleteEmployee(long emp_num) {
    // Code to delete employee
    for (Employee emp : employees) {
      if (emp.getEmpNum() == emp_num) {
        employees.remove(emp);
        break;
      }
    }
  }

  public Employee[] getAllEmployees() {
    // Code to retrieve collection
    return employees.toArray(new Employee[0]);
  }
}
