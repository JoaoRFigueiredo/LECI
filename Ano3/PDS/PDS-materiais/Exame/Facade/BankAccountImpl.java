public class BankAccountImpl implements BankAccount{
	private String bank;
	private double balance;
	public BankAccountImpl(String bank, double initalDeposit) {
		this.bank=bank;
		balance=initalDeposit;
	}
	public String getBank() {
		return bank;
	}
	public void deposit(double amount) {
		balance += amount;
	}
	public double balance() {
		return balance;
	}
	@Override public boolean withdraw(double amount) {
		if (amount > balance ) 
			return false;
		balance -= amount;
        return true;
	}

}