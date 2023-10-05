public class SweetsEmployeeAdapter implements EmployeeAdapter {
  private Employee employee;

  public SweetsEmployeeAdapter(Employee employee) {
    this.employee = employee;
  }

  @Override
  public String getName() {
    // TODO Auto-generated method stub
    return employee.getName();
  }

  @Override
  public long getEmpNum() {
    // TODO Auto-generated method stub
    return employee.getEmpNum();
  }

  @Override
  public double getSalary() {
    // TODO Auto-generated method stub
    return employee.getSalary();
  }

}
