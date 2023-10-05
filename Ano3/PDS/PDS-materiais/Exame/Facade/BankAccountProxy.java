enum User {OWNER, COMPANY} // i dont feel like making a new file
public class BankAccountProxy implements BankAccount{
	private BankAccount bank;
	
	BankAccountProxy (BankAccount bank) {
		this.bank = bank;
	}
	
	public void deposit(double amount) {
		bank.deposit(amount);
		
	}
	
	@Override public boolean withdraw(double amount) {
		if(Company.user == User.OWNER) {
			return bank.withdraw(amount);
		} else {
			System.out.println(Company.user);
			System.out.println("Operation denied!");
			return false;
		}
	}
	
	@Override public double balance() {
		if(Company.user == User.OWNER) {
			return bank.balance();
		} else {
			System.out.println("Operation denied!");
			return Double.NaN;
		}
	}
	
	
	

}