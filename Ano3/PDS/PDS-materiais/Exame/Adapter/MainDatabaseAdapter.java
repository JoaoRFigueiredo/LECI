import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainDatabaseAdapter implements DatabaseAdapter {
  private static DatabaseAdapter defaultAdapter = new SweetsDatabaseAdapter();

  private List<DatabaseAdapter> adapters;

  public MainDatabaseAdapter() {
    adapters = new ArrayList<>();
  }

  public void addDatabaseAdapter(DatabaseAdapter adapter) {
    adapters.add(adapter);
  }

  @Override
  public void addEmployee(EmployeeAdapter employee) {
    // TODO Auto-generated method stub
    if (adapters.size() > 0)
      adapters.get(0).addEmployee(employee);
    else {
      adapters.add(defaultAdapter);
      addEmployee(employee);
    }
  }

  @Override
  public void removeEmployee(long emp_num) {
    // TODO Auto-generated method stub
    for (DatabaseAdapter db : adapters)
      if (db.isEmployee(emp_num))
        db.removeEmployee(emp_num);
  }

  @Override
  public boolean isEmployee(long emp_num) {
    // TODO Auto-generated method stub
    for (DatabaseAdapter db : adapters)
      if (db.isEmployee(emp_num))
        return true;

    return false;
  }

  @Override
  public EmployeeAdapter[] getEmployees() {
    // TODO Auto-generated method stub
    List<EmployeeAdapter> employees = new ArrayList<>();
    for (DatabaseAdapter db : adapters)
      employees.addAll(Arrays.asList(db.getEmployees()));
    return employees.toArray(new EmployeeAdapter[0]);
  }

}
