package transaction;

import customer.Customer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction{

    public Transaction(String accountNumber, TransactionType type, double amount, double balanceAfter) {
        this.transactionId = generateId();
        this.accountNumber = accountNumber;
        this.type = type;
        this.amount = amount;
        this.balanceAfter = balanceAfter;
        this.timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm a"));
    }

    static  int transactionCounter = 0;
    private String transactionId;
    private String accountNumber;
    private TransactionType type;
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

    public TransactionType getType() {
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

    private String generateId (){
        Transaction.transactionCounter++;
        String count = String.valueOf(Transaction.transactionCounter);
        if (count.length() > 2)
            return "TXN"+count;
        return "TXN"+ "0".repeat(3 - count.length()) + count ;
    }



}
