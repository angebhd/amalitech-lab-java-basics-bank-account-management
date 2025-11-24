package account;
public class SavingsAccount extends Account {
    public SavingsAccount() {
        this.interestRate = 3.5;
        this.minimumBalace = 500;
    }

    private final double interestRate;
    private final double minimumBalace;

    @Override
    public void displayAccountDetail(){
        System.out.println("Savings Account");
        System.out.println("Interest Rate: " + this.interestRate);
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