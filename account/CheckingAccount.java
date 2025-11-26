package account;

import customer.Customer;
import customer.PremiumCustomer;

public class CheckingAccount extends Account {
    public CheckingAccount( Customer customer, double balance, String status){
        super(customer, balance, status);
        this.overdraftLimit = 1000;
        if (customer instanceof PremiumCustomer && ((PremiumCustomer) customer).hasWaivedFees(balance))
            this.monthlyFee = 0;
        else
            this.monthlyFee = 10;
    }
    private final double overdraftLimit;
    private final double monthlyFee;

    @Override
    public void displayAccountDetail(){
        System.out.println("Account Details: ");
        System.out.println("\tCustomer: " + this.getCustomer().getName());
        System.out.println("\tAccount Type: " + getAccountType());
        System.out.println("\tCurrent Balance: " + this.getBalance());
    }

    @Override
    public String getAccountType(){
        return "Checking";
    }

    @Override
    public void withdraw(double amount){
        if(this.getBalance() + this.overdraftLimit >= amount){
            this.setBalance(this.getBalance() - amount);
            System.out.println("Amount " + amount + "$ sucessfully withdrawn");
            return;
        }
        System.out.println("Insufficient funds");
    }

    public void applyMonthlyFee(){
        this.setBalance(this.getBalance() - this.monthlyFee);
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    public double getMonthlyFee() {
        return monthlyFee;
    }
}