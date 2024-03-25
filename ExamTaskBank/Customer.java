package zadExam;

import java.util.ArrayList;

public class Customer {
    private long customerId;
    private String name;
    private ArrayList<BankAccount> accounts;

    public Customer(long customerId, String name){
        this.customerId = customerId;
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public long getCustomerId(){
        return customerId;
    }

    public String getName(){
        return name;
    }

    public void setCustonerId(long id){
        this.customerId = id;
    }

    public void setName(String name){
        this.name = name;
    }

    void addBankAccount(BankAccount account){
        accounts.add(account);
    }

    void printBankAccount(){
        for(BankAccount account : accounts){
            System.out.println(account);
        }
    }
}
