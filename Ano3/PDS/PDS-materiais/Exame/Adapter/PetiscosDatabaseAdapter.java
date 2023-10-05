import java.util.Arrays;
import java.util.stream.Stream;

public class PetiscosDatabaseAdapter implements DatabaseAdapter {
  private Registos database;

  public PetiscosDatabaseAdapter() {
    this.database = new Registos();
  }

  public PetiscosDatabaseAdapter(Registos database) {
    this.database = database;
  }

  @Override
  public void addEmployee(EmployeeAdapter employee) {
    // TODO Auto-generated method stub
    String[] names = employee.getName().split(" ");
    String name = String.join(" ", Arrays.copyOfRange(names, 0, names.length / 2));
    String surname = String.join(" ", Arrays.copyOfRange(names, names.length / 2, names.length));
    Empregado emp = new Empregado(name, surname, (int) employee.getEmpNum(), employee.getSalary());
    database.insere(emp);
  }

  @Override
  public void removeEmployee(long emp_num) {
    // TODO Auto-generated method stub
    database.remove((int) emp_num);
  }

  @Override
  public boolean isEmployee(long emp_num) {
    // TODO Auto-generated method stub
    return database.isEmpregado((int) emp_num);
  }

  @Override
  public EmployeeAdapter[] getEmployees() {
    // TODO Auto-generated method stub
    Empregado[] employees = database.listaDeEmpregados().toArray(new Empregado[0]);
    PetiscosEmployeeAdapter[] employeesAdapted = Stream.of(employees).map(PetiscosEmployeeAdapter::new)
        .toArray(PetiscosEmployeeAdapter[]::new);

    return employeesAdapted;
  }

}
