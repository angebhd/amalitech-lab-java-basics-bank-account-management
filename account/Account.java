package account;
import customer.Customer;
abstract class Account {
    private String accountNumber;
    private Customer customer;
    private double balance;
    private String status;

    static int accountCounter = 0;

    void displayAccountDetail();
    String getAccountType();

    void deposit(double amount){
        this.balance += amount;
    }

    void withdraw(double amount){
        if(this.balance >= amount){
            this.balance -= amount;
            System.out.println("Amount " + amount + "$ sucessfully withdrawn");
            return;
        }
        System.out.println("Insufficient funds");
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}