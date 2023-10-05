import java.util.stream.Stream;

public class SweetsDatabaseAdapter implements DatabaseAdapter {
  private Database database;

  public SweetsDatabaseAdapter() {
    this.database = new Database();
  }

  public SweetsDatabaseAdapter(Database database) {
    this.database = database;
  }

  @Override
  public void addEmployee(EmployeeAdapter employee) {
    // TODO Auto-generated method stub
    database.addEmployee(new Employee(employee.getName(), employee.getEmpNum(), employee.getSalary()));
  }

  @Override
  public void removeEmployee(long emp_num) {
    // TODO Auto-generated method stub
    database.deleteEmployee(emp_num);
  }

  @Override
  public boolean isEmployee(long emp_num) {
    // TODO Auto-generated method stub
    for (EmployeeAdapter emp : getEmployees())
      if (emp.getEmpNum() == emp_num)
        return true;
    return false;
  }

  @Override
  public EmployeeAdapter[] getEmployees() {
    // TODO Auto-generated method stub
    Employee[] employees = database.getAllEmployees();
    SweetsEmployeeAdapter[] employeesAdapted = Stream.of(employees).map(SweetsEmployeeAdapter::new)
        .toArray(SweetsEmployeeAdapter[]::new);
    ;

    return employeesAdapted;
  }

}
