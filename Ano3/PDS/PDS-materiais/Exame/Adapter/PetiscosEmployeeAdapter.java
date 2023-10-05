public class PetiscosEmployeeAdapter implements EmployeeAdapter {
  private Empregado employee;

  public PetiscosEmployeeAdapter(Empregado employee) {
    this.employee = employee;
  }

  @Override
  public String getName() {
    // TODO Auto-generated method stub
    return employee.nome() + ' ' + employee.apelido();
  }

  @Override
  public long getEmpNum() {
    // TODO Auto-generated method stub
    return employee.codigo();
  }

  @Override
  public double getSalary() {
    // TODO Auto-generated method stub
    return employee.salario();
  }

}
