package zadExam;

public class Transaction {
    private String transactionType;
    private double amount;
    private String transactionId;

    public Transaction(String transactionType, double amount, String tran) {
        this.transactionType = transactionType;
        this.amount = amount;
    }
}
