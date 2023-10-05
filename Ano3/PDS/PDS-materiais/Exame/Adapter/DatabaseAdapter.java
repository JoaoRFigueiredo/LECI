public interface DatabaseAdapter {
  public void addEmployee(EmployeeAdapter employee);

  public void removeEmployee(long emp_num);

  public boolean isEmployee(long emp_num);

  public EmployeeAdapter[] getEmployees();
}
