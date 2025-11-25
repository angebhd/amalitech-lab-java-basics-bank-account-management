package account;
import customer.Customer;
public abstract class Account {
    public Account( Customer customer, double balance, String status) {
        this.accountNumber = generateId() ; /// auto generated
        this.customer = customer;
        this.balance = balance;
        this.status = status;
    }

    private String accountNumber;
    private Customer customer;
    private double balance;
    private String status;

    static int accountCounter = 0;

    public abstract void displayAccountDetail();
    public abstract String getAccountType();

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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
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


    private String generateId (){
        Account.accountCounter++;
        String count = String.valueOf(Account.accountCounter);
        if (count.length() > 2)
            return "ACC"+count;
        return "ACC"+ "0".repeat(3 - count.length()) + count ;
    }
}