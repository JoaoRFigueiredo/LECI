import static java.lang.Double.NaN;

public class BankAccProxy implements BankAccount{
    private BankAccount BankAcc; 

    BankAccProxy(BankAccount bankAcc){
        this.BankAcc = bankAcc;
    }


    @Override
    public void deposit(double amount) {
        this.BankAcc.deposit(amount);
    }

    //We want to limit access to these 2 methods

    @Override
    public boolean withdraw(double amount) {
        if (Company.user.equals(User.OWNER)){
           return  this.BankAcc.withdraw(amount);
        }
        return false;
    }

    @Override
    public double balance() {
        if (Company.user.equals(User.OWNER)){
            return BankAcc.balance();
        }

        return NaN;
        
        
    }

    
    
}
