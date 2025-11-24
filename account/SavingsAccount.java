public class SavingsAccount implements Account {
    public SavingsAccount() {
        this.interestRate = 3.5;
        this.minimumBalace = 500;
    }

    private double interestRate;
    private double minimumBalace;

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
        if(this.balacnce >= amount+ this.minimumBalace){
            this.balance -= minimumBalace;
            System.out.println("Amount " + amount + "$ sucessfully withdrawn");
            return;
        }
        System.out.println("Insufficient funds");
    }

    public double calculateInterest(){
        return this.balance + (this.balance * this.interestRate)
    }



}