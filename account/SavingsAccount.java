package account;

import customer.Customer;

public class SavingsAccount extends Account {
    public SavingsAccount(Customer customer, double balance, String status){
        super(customer, balance, status);
        this.interestRate = 3.5;
        this.minimumBalance = 500;
    }

    private final double interestRate;
    private final double minimumBalance;

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
    public void withdraw(double amount){
        if(this.getBalance() >= amount+ this.minimumBalance){
            this.setBalance(this.getBalance() - minimumBalance);
            System.out.println("Amount " + amount + "$ sucessfully withdrawn");
            return;
        }
        throw new IllegalArgumentException("Insuficient Balance");
    }

    public double calculateInterest(){
        return this.getBalance() + (this.getBalance() * this.interestRate);
    }

    public double getInterestRate() {
        return interestRate;
    }

    public double getMinimumBalace() {
        return this.minimumBalance;
    }
}