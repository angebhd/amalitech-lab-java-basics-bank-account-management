package account;
public class CheckingAccount extends Account {
    public CheckingAccount(){
        this.overdraftLimit = 1000;
        this.monthlyFee = 10;
    }
    private double overdraftLimit;
    private double monthlyFee;

    @Override
    public void displayAccountDetail(){
        System.out.println("Checking Account");
        System.out.println("Overdraft detail: " + this.overdraftLimit);
    }

    @Override
    public String getAccountType(){
        return "Checking";
    }

    @Override
    void withdraw(double amount){
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

}