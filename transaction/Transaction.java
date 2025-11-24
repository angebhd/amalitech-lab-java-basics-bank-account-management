package transaction;

import java.time.LocalDateTime;

public class Transaction{

    public Transaction(String accountNumber, String type, double amount, double balanceAfter) {
        this.accountNumber = accountNumber;
        this.type = type;
        this.amount = amount;
        this.balanceAfter = balanceAfter;
        this.timestamp = LocalDateTime.now().toString();

        /// Automatically generate transactionId
    }

    static  int transactionCounter = 0;
    private String transactionId;
    private String accountNumber;
    private String type;
    private double amount;
    private double balanceAfter;
    private String timestamp;

    public void displayTransactionDetails(){
        System.out.println("Transaction Details \nAccount Number: " + this.accountNumber);
    }

    public String getTimestamp() {
        return timestamp;
    }

    public double getBalanceAfter() {
        return balanceAfter;
    }

    public double getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public static int getTransactionCounter() {
        return transactionCounter;
    }



}
