package zadExam;

public class CheckingAccount extends BankAccount {
    public CheckingAccount(String bankAccount, Customer accountHolder, double balance, double minBalance) {
        super(bankAccount, accountHolder, balance);
    }

    @Override
    public void withdraw(double amount){
        
    }
}
