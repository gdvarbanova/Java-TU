package zadExam;

public class BankAccount implements PrintInformation {
    private String bankAccount;
    private Customer accountHolder;
    private double balance;

    public BankAccount(String bankAccount, Customer accountHolder, double balance){
        this.bankAccount = bankAccount;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public String getBankAccount(){
        return bankAccount;
    }

    public Customer getAccountHolder(){
        return accountHolder;
    }

     void deposit(double amount){
        this.balance += amount;
    }

    void withdraw(double amount) throws InsufficientFundsException{
        if(amount > this.balance){
            throw new InsufficientFundsException("Not enough funds!");
        }
        this.balance -= amount;
    } 

    private double getBalance(){
        return this.balance;
    }

    @Override
    public void printInfo() {
        System.out.println("Account number: " + bankAccount);
        System.out.println("Account holder: " + accountHolder);
        System.out.println("Account balance: " + getBalance());
    }
}
