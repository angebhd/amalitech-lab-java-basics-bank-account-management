package account;

import menu.Menu;

public class AccountManager {

    private final Account[] accounts = new Account[50]  ;
    private int accountCount = 0;
    private final Menu menu = new Menu();
    public void addAccount(Account acc) {
        this.accounts[accountCount] = acc;
        this.accountCount++;
    }

    public Account findAccount(String accountNumber){
        for (int i = 0; i < accountCount ; i++) {
            if (this.accounts[i].getAccountNumber().equalsIgnoreCase(accountNumber))
                return this.accounts[i];
        }
        return null;
    }

    public void viewAllAccount(){
        menu.printTitle("ACCOUNT LISTING");
        double bankBalance = 0;
        if(accounts.length == 0){
            System.out.println("Nothing to show");
            return;
        }
        System.out.println("ACC NO   |   CUSTOMER NAME     |  TYPE   |   BALANCE    |  STATUS   | OTHERS   ");
        System.out.println("_______________________________________________________________________________");
        for (int i =0; i< Account.accountCounter; i++){
            menu.printViewAccountRow(accounts[i]);
            bankBalance += accounts[i].getBalance();
        }

        System.out.println();
        System.out.println("Total Accounts: " + Account.accountCounter);
        System.out.println("Total Bank Balance: " + bankBalance);

    }
    public double getTotalBalance(){
        ///  implementation

        return 23.0;
    }

    public int getAccountCount(){
        return this.accountCount+1;
    }
}

