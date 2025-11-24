public class CheckingAccount implements Account {
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
        if(this.balacnce + this.overdraftLimit >= amount){
            this.balance -= minimumBalace;
            System.out.println("Amount " + amount + "$ sucessfully withdrawn");
            return;
        }
        System.out.println("Insufficient funds");
    }

}