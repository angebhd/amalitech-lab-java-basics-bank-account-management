package account;

import customer.Customer;

public class SavingsAccount extends Account {
    public SavingsAccount(Customer customer, double balance, String status){
        super(customer, balance, status);
        this.interestRate = 3.5;
        this.minimumBalace = 500;
    }

    private final double interestRate;
    private final double minimumBalace;

    @Override
    public void displayAccountDetail(){
        System.out.println("Account Details: ");
        System.out.println("\tCustomer: " + this.getCustomer().getName());
        System.out.println("\tAccount Type: " + getAccountType());
        System.out.println("\tCurrent Balance: " + this.getBalance());
    }

    @Override
    public String getAccountType(){
        return "Savings";
    }

    @Override
    void withdraw(double amount){
        if(this.getBalance() >= amount+ this.minimumBalace){
            this.setBalance(this.getBalance() - minimumBalace);
            System.out.println("Amount " + amount + "$ sucessfully withdrawn");
            return;
        }
        System.out.println("Insufficient funds");
    }

    public double calculateInterest(){
        return this.getBalance() + (this.getBalance() * this.interestRate);
    }



}