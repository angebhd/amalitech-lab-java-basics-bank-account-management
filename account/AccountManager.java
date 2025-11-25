package account;

public class AccountManager {

    private final Account[] accounts = new Account[50]  ;
    private int accountCount = 0;
    public void addAccount(Account acc) {
        this.accounts[accountCount] = acc;
        this.accountCount++;
    }

    public Account findAccount(String accountNumber){
        for(Account a : this.accounts){
            if (a.getAccountNumber().equalsIgnoreCase(accountNumber))
                return a;
        }
        return null;
    }

    public void viewAllAccount(){
        ///  implementation
    }
    public double getTotalBalance(){
        ///  implementation

        return 23.0;
    }

    public int getAccountCount(){
        return this.accountCount+1;
    }
}

