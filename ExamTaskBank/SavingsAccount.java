package zadExam;

public class SavingsAccount extends BankAccount {
    private double minBalance;
    public SavingsAccount(String bankAccount, Customer accountHolder, double balance, double minBalance) {
        super(bankAccount, accountHolder, balance);
        this.minBalance = minBalance;
    }

    @Override
    public void withdraw(double amount){
        if(minBalance < 100){
            System.out.println("Minimal balance should be 100!");
        }
        try {
            minBalance -= amount;
            if(amount > minBalance) throw new InsufficientFundsException("Not enough funds!");
        } 
        catch (InsufficientFundsException e) {
            e.getMessage();
        }
    }
}
