public class Ex1_2 {
  public static void main(String[] args) {
    Database db = new Database();
    db.addEmployee(new Employee("Paulo Quem", 1, 420));
    db.addEmployee(new Employee("Pedro Filo", 2, 421));

    Registos db2 = new Registos();
    db2.insere(new Empregado("Paulo", "Quem 2", 3, 422));
    db2.insere(new Empregado("Pedro", "Filo 2", 4, 423));

    MainDatabaseAdapter db3 = new MainDatabaseAdapter();
    db3.addDatabaseAdapter(new SweetsDatabaseAdapter(db));
    db3.addDatabaseAdapter(new PetiscosDatabaseAdapter(db2));

    for (EmployeeAdapter emp : db3.getEmployees())
      System.out.println(String.format("%-15s %5d %5f€", emp.getName(), emp.getEmpNum(), emp.getSalary()));

    if (db3.isEmployee(1))
      System.out.println("Check 1");

    db3.removeEmployee(1);
    db3.removeEmployee(4);

    if (db3.isEmployee(1))
      System.out.println("Check 1");

    for (EmployeeAdapter emp : db3.getEmployees())
      System.out.println(String.format("%-15s %5d %5f€", emp.getName(), emp.getEmpNum(), emp.getSalary()));
  }
}