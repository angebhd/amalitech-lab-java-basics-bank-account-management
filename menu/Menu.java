package menu;

import account.Account;
import account.CheckingAccount;
import account.SavingsAccount;

public class Menu{
 	public void showMainMenu(){
        System.out.println("============================================");
        System.out.println("||                                        ||");
        System.out.println("||   BANK ACCOUNT MANAGEMENT - MAIN MENU  ||");
        System.out.println("||                                        ||");
        System.out.println("============================================");
        System.out.println("1. Create Account");
        System.out.println("2. View Account");
        System.out.println("3. Process Transaction");
        System.out.println("4. View Transaction History");
        System.out.println("5. Exit");
        System.out.println();
        System.out.print("Enter you choice: ");
	}

    public void showViewAccount(Account[] accounts, double bankBalance){
         printTitle("ACCOUNT LISTING");
         if(accounts.length == 0){
             System.out.println("Nothing to show");
             return;
         }
        System.out.println("ACC NO   |   CUSTOMER NAME     |  TYPE   |   BALANCE    |  STATUS   | OTHERS   ");
         for (Account account: accounts)
             printViewAccountRow(account);

        System.out.println();
        System.out.println("Total Accounts: " + accounts.length);
        System.out.println("Total Bank Balance: " + bankBalance);

    }



    public void printTitle(String title){
        System.out.println();
        System.out.println("____________________________________________");
        System.out.println(title);
        System.out.println("____________________________________________");
    }

    public void printViewAccountRow(Account account){
        System.out.print(account.getAccountNumber() + "  |  " + account.getCustomer().getName() +
                " | " + account.getAccountType() + " | $" + account.getBalance() + " | " + account.getStatus() + " | " );
        if(account instanceof SavingsAccount)
            System.out.print("Interest Rate: "+ ((SavingsAccount) account).getInterestRate() + "% | Min balance: $" + ((SavingsAccount) account).getMinimumBalace());

        if (account instanceof CheckingAccount)
            System.out.print("Overdraft Limit: $" + ((CheckingAccount) account).getOverdraftLimit() + " | Monthly fee: $" + ((CheckingAccount) account).getMonthlyFee());

        System.out.println("\n"+"-------------------------------------------------------------------------------");

    }

}