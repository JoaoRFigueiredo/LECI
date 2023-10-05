public class Ex1_1 {
  public static void main(String[] args) {
    Database db = new Database();
    db.addEmployee(new Employee("Paulo Quem", 1, 420));
    db.addEmployee(new Employee("Pedro Filo", 2, 421));

    for (Employee emp : db.getAllEmployees())
      System.out.println(String.format("%-15s %5d %5f€", emp.getName(), emp.getEmpNum(), emp.getSalary()));

    db.deleteEmployee(2);

    for (Employee emp : db.getAllEmployees())
      System.out.println(String.format("%-15s %5d %5f€", emp.getName(), emp.getEmpNum(), emp.getSalary()));

    Registos db2 = new Registos();
    db2.insere(new Empregado("Paulo", "Quem", 1, 420));
    db2.insere(new Empregado("Pedro", "Filo", 2, 421));

    for (Empregado emp : db2.listaDeEmpregados())
      System.out
          .println(String.format("%-15s %5d %5f€", emp.nome() + " " + emp.apelido(), emp.codigo(), emp.salario()));

    if (db2.isEmpregado(1))
      System.out.println("Check 1");
    if (db2.isEmpregado(2))
      System.out.println("Check 2");

    db2.remove(2);

    if (db2.isEmpregado(1))
      System.out.println("Check 1");
    if (db2.isEmpregado(2))
      System.out.println("Check 2");

    for (Empregado emp : db2.listaDeEmpregados())
      System.out
          .println(String.format("%-15s %5d %5f€", emp.nome() + " " + emp.apelido(), emp.codigo(), emp.salario()));

  }
}
