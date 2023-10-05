
class Employee  {

private double salary;
private Person n;
private BankAccount BankAcc;
	
	public Employee(Person n, double s) {
		this.n = n;
		salary = s;
		BankAcc = new BankAccountImpl("PeDeMeia", 0);
	}

	public double getSalary() {
		return salary;
	}

	public Person getPerson(){
		return n;
	}

	public BankAccount getBankAccount() {
		return new BankAccProxy(BankAcc);
	}
}