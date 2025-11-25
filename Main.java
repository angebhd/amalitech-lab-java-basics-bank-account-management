import account.Account;
import account.AccountManager;
import account.CheckingAccount;
import account.SavingsAccount;
import customer.Customer;
import customer.PremiumCustomer;
import customer.RegularCustomer;
import helper.Helper;
import menu.Menu;
import transaction.Transaction;
import transaction.TransactionManager;
import transaction.TransactionType;

import java.util.Scanner;

class Main{
    static Scanner scanner = new Scanner(System.in);
    static Menu menu = new Menu();
    static TransactionManager transactionManager = new TransactionManager();
    static AccountManager accountManager = new AccountManager();
    static Helper helper = new Helper();



	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        initializeData();
		System.out.println("Hello World!");
        boolean exitApp = false ;
        char menuChoice;
        do{
            menu.showMainMenu();
            menuChoice = scanner.next().trim().charAt(0);
            switch (menuChoice){
                case '1':
                    System.out.println("Create Account");
                    break;
                case '2':
                    accountManager.viewAllAccount();
                    break;
                case '3':
                    System.out.println("Process Transactions");
                    break;
                case '4':
                    System.out.println("View Transaction history");
                    break;
                case '5':
                    System.out.println("Thank you for using Bank Account Management System !");
                    System.out.println("GoodBye!");
                    exitApp = true;
            }

        }while (!exitApp);
	}

    Account createAccount(){
        Account newAccount;
        Customer newCustomer;

        menu.printTitle("ACCOUNT CREATION");
        System.out.println();
        System.out.println("Enter customer name: ");
        String name = scanner.next().trim();

        System.out.println("Enter customer age: ");
        int age = scanner.nextInt();

        System.out.println("Enter customer contact: ");
        String contact = scanner.next().trim();

        System.out.println("Enter customer address: ");
        String address = scanner.next().trim();

        System.out.println();
        System.out.println("Customer Type: ");
        System.out.println("1. Regular Customer");
        System.out.println("2. Premium Customer");
        System.out.println("Select type(1-2): ");
        int customerType = scanner.nextInt();

        ///  Creatting customer depending on user choice
        newCustomer = switch (customerType) {
            case 1 -> new RegularCustomer(name, age, address, contact);
            case 2 -> new PremiumCustomer(name, age, address, contact);
            default -> throw new IllegalArgumentException();
        };

        System.out.println();
        System.out.println("Account Type: ");
        System.out.println("1. Savings Account (Interest: 3.5%, Min Balance: $500)");
        System.out.println("2. Checking Account (Overdraft: $1,000, Montly fee: $10)");
        System.out.println("Select type(1-2): ");
        int accountType = scanner.nextInt();


        System.out.println();
        System.out.println("Enter initial deposit amount: ");
        double deposit = scanner.nextDouble();

        newAccount = switch (accountType) {
            case 1 -> new SavingsAccount(newCustomer, deposit, "ACTIVE");
            case 2 -> new CheckingAccount(newCustomer, deposit, "ACTIVE");
            default -> throw new IllegalArgumentException("Invalid account type choice");
        };

        /// save accounts & Customer somewhere, then display sucess message
        return null;
    }

    void processTransaction(){
        TransactionType transactionType;
        menu.printTitle("PROCESS TRANSACTION");

        System.out.println("Enter Account number: ");
        String accountNo = scanner.next().trim();
        Account account = accountManager.findAccount(accountNo);
        if (account == null) {
            System.out.println("Account with accountNo: " + accountNo+ " not found");
            return;
        }
        System.out.println("Account Details: ");
        System.out.println("\tCustomer: " + account.getCustomer().getName());
        System.out.println("\tAccount Type: " + account.getAccountType());
        System.out.println("\tCurrent Balance: " + account.getBalance());

        System.out.println();

        System.out.println("Trasaction Type: ");
        System.out.println("1. Deposit");
        System.out.println("2. Withdrawal");
        System.out.println();
        System.out.println("Select type(1-2): ");
        int choosenTransaction = scanner.nextInt();
        transactionType = switch (choosenTransaction){
            case 1 -> TransactionType.DEPOSIT;
            case 2 -> TransactionType.WITHDRAW;
            default -> throw new IllegalArgumentException("Invalid transaction type");
        };
        System.out.println();

        System.out.println("Enter amount: ");
        double amount = scanner.nextDouble();

        Transaction newTransaction = new Transaction(accountNo, transactionType, amount, account.getBalance() - amount);

        menu.printTitle("TRANSACTION CONFIRMATION");
        System.out.println("Transaction ID: " + newTransaction.getTransactionId());
        System.out.println("Account: " + newTransaction.getAccountNumber());
        System.out.println("Amount: $" + newTransaction.getAmount());
        System.out.println("Previous Balance: $" + account.getBalance());
        System.out.println("New Balance: $" + newTransaction.getBalanceAfter());
        System.out.println("Date/Time: " + newTransaction.getTimestamp());
        System.out.println("_____________________________________________");
        System.out.println();
        System.out.println("Confirm Transaction? (Y/N): ");
        char confirm = scanner.next().trim().charAt(0);
        if(confirm != 'Y'){
            System.out.println("Transaction canceled .....");
            return;
        }
        transactionManager.addTransaction(newTransaction);

        System.out.println("Transaction completed sucessfully!");
        System.out.println("Press Enter to continue");
        scanner.next();


    }

    public void showViewTransactionHistoryROW(Transaction transaction){
        menu.printTitle("VIEW TRANSACTION HISTORY");
        System.out.println();
        System.out.println("Enter ccount number: ");
        String accountNo = scanner.next().trim();

        Account account = accountManager.findAccount(accountNo);
        if (account == null) {
            System.out.println("Account not found");
        }

        System.out.println("Account Details: ");
        System.out.println("\tCustomer: " + account.getCustomer().getName());
        System.out.println("\tAccount Type: " + account.getAccountType());
        System.out.println("\tCurrent Balance: " + account.getBalance());

        System.out.println();
        System.out.println("___________________________________________");
        Transaction[] transactions = null; /// get transactions
        if (transactions == null || transactions.length == 0) {
            System.out.println("No transactions recorded for this account");
        }else{
            System.out.println("TXN  | DATE/TIME  |  TYPE | AMOUNT | BALANCE ");
            System.out.println("_____________________________________________");
            double deposits = 0;
            double withdrawals = 0;
            for (Transaction t: transactions) {
                double transactionType = t.getType().equals(TransactionType.DEPOSIT) ? 1 : -1;
                System.out.println(t.getTransactionId() + " | " + t.getTimestamp() + " | " + t.getType().toString()  + " | $"
                + transactionType*t.getAmount() + " | $" + t.getBalanceAfter()
                );
            }
            System.out.println("___________________________________________");
            System.out.println("Total transactions: " + transactions.length);
            System.out.println("Total deposits: $" + deposits);
            System.out.println("Total withdrawals: $" + withdrawals);
            System.out.println("Net change: $" + (deposits-withdrawals));
        }

        System.out.println("Press Enter to continue");

    }

    static void initializeData(){
        for (Account c: helper.generateAccounts()){
            accountManager.addAccount(c);
        }
    }
}
