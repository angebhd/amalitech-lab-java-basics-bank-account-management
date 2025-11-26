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
            menuChoice = scanner.nextLine().trim().charAt(0);
            switch (menuChoice){
                case '1':
                    createAccount();
                    System.out.print("Press Enter to continue...");
                    scanner.nextLine();
                    System.out.println();
                    break;
                case '2':
                    accountManager.viewAllAccount();
                    System.out.println();
                    System.out.print("Press enter to continue...");
                    scanner.nextLine();
                    System.out.println();
                    break;
                case '3':
                    processTransaction();
                    System.out.print("Press enter to continue...");
                    scanner.nextLine();
                    System.out.println();
                    break;
                case '4':
                    showViewTransactionHistoryROW();
                    System.out.print("Press enter to continue...");
                    scanner.nextLine();
                    System.out.println();
                    break;
                case '5':
                    System.out.println("Thank you for using Bank Account Management System !");
                    System.out.println("GoodBye!");
                    exitApp = true;
            }
        }while (!exitApp);
        scanner.close();

    }

    static void createAccount(){
        Account newAccount;
        Customer newCustomer;

        menu.printTitle("ACCOUNT CREATION");
        System.out.println();
        System.out.print("Enter customer name: ");
        String name = scanner.nextLine().trim();
        scanner.reset();

        System.out.print("Enter customer age: ");
        int age = scanner.nextInt();
        scanner.reset();

        System.out.print("Enter customer contact: ");
        String contact = scanner.next().trim();
        scanner.reset();

        System.out.print("Enter customer address: ");
        String address = scanner.next().trim();
        scanner.reset();

        System.out.println();
        System.out.println("Customer Type: ");
        System.out.println("1. Regular Customer");
        System.out.println("2. Premium Customer");
        System.out.print("Select type(1-2): ");
        int customerType = scanner.nextInt();
        scanner.reset();

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
        System.out.print("Select type(1-2): ");
        int accountType = scanner.nextInt();
        scanner.reset();


        System.out.println();
        System.out.print("Enter initial deposit amount: ");
        double deposit = scanner.nextDouble();
        scanner.reset();

        newAccount = switch (accountType) {
            case 1 -> new SavingsAccount(newCustomer, deposit, "ACTIVE");
            case 2 -> new CheckingAccount(newCustomer, deposit, "ACTIVE");
            default -> throw new IllegalArgumentException("Invalid account type choice");
        };

        /// save accounts & Customer somewhere, then display sucess message
        accountManager.addAccount(newAccount);

        System.out.println("\nAccount Created Successfully!");
        System.out.println("Account Number: "+ newAccount.getAccountNumber());
        System.out.println("Customer "+ newAccount.getCustomer().getName() + " ( " + newAccount.getCustomer().getCustomerType() + " )") ;
        System.out.println("Account Type: "+ newAccount.getAccountType());

        ///  display saving account details
        if(newAccount instanceof SavingsAccount){
            System.out.println("Interest Rate: "+ ((SavingsAccount) newAccount).getInterestRate() + "%");
            System.out.println("Minimum balance: "+ ((SavingsAccount) newAccount).getMinimumBalace());

        }
        /// for Checking account display checking account information details
        if(newAccount instanceof  CheckingAccount){
            System.out.println("Overfraft Limit: "+ ((CheckingAccount) newAccount).getOverdraftLimit());
            System.out.print("Montly fee: $" + ((CheckingAccount) newAccount).getMonthlyFee());
            ///  if premium customer, check if monthly fees are waived
            if(((CheckingAccount) newAccount).getMonthlyFee() == 0){
                System.out.print("( WAIVED - Premium Customer)");
            }
            System.out.println("\n");
        }
        System.out.println("Initial Balance: "+ newAccount.getBalance());
        System.out.println("Status: "+ newAccount.getStatus());
        System.out.println();

    }

    static void processTransaction(){
        TransactionType transactionType;
        menu.printTitle("PROCESS TRANSACTION");
        scanner.reset();
        System.out.print("Enter Account number: ");
        String accountNo = scanner.next().trim().toUpperCase();
        scanner.reset();
        final Account account = accountManager.findAccount(accountNo);
        if (account == null) {
            System.out.println("Account with accountNo: " + accountNo+ " not found");
            System.out.println();
            return;
        }
        System.out.println("Account Details: ");
        System.out.println("\tCustomer: " + account.getCustomer().getName());
        System.out.println("\tAccount Type: " + account.getAccountType());
        System.out.println("\tCurrent Balance: $" + account.getBalance());

        System.out.println();

        System.out.println("Trasaction Type: ");
        System.out.println("1. Deposit");
        System.out.println("2. Withdrawal");
        System.out.println();
        System.out.print("Select type(1-2): ");
        int chosenTransaction = scanner.nextInt();
        scanner.reset();
        transactionType = switch (chosenTransaction){
            case 1 -> TransactionType.DEPOSIT;
            case 2 -> TransactionType.WITHDRAW;
            default -> throw new IllegalArgumentException("Invalid transaction type");
        };
        System.out.println();

        System.out.print("Enter amount: ");
        final double amount = scanner.nextDouble();
        scanner.reset();
        final int operation = transactionType.equals(TransactionType.DEPOSIT)? 1 : -1;
        Transaction newTransaction = new Transaction(accountNo, transactionType, amount, account.getBalance() + (amount * operation));

        menu.printTitle("TRANSACTION CONFIRMATION");
        System.out.println("Transaction ID: " + newTransaction.getTransactionId());
        System.out.println("Account: " + newTransaction.getAccountNumber());
        System.out.println("Amount: $" + newTransaction.getAmount());
        System.out.println("Previous Balance: $" + account.getBalance());
        System.out.println("New Balance: $" + newTransaction.getBalanceAfter());
        System.out.println("Date/Time: " + newTransaction.getTimestamp());
        System.out.println("_____________________________________________");
        System.out.println();
        System.out.print("Confirm Transaction? (Y/N): ");
        char confirm = scanner.next().trim().toUpperCase().charAt(0);
        scanner.reset();
        if(confirm != 'Y'){
            System.out.println("Transaction canceled .....");
            System.out.println();
            return;
        }
        if (transactionType.equals(TransactionType.WITHDRAW)) {
            try{
            account.withdraw(amount);
            }catch (IllegalArgumentException e){
                System.out.println("_____________________________________________");
                System.out.println("Transaction failed!!!");
                System.out.println("Reason: " + e.getMessage());
                System.out.println();
                return;
            }
        }else
            account.deposit(amount);
        transactionManager.addTransaction(newTransaction);

        System.out.println("Transaction completed sucessfully!");

    }

    static void showViewTransactionHistoryROW(){
        menu.printTitle("VIEW TRANSACTION HISTORY");
        System.out.println();
        System.out.print("Enter ccount number: ");
        String accountNo = scanner.next().trim().toUpperCase();
        scanner.reset();

        Account account = accountManager.findAccount(accountNo);
        if (account == null) {
            System.out.println("Account not found");
        }

        System.out.println("Account Details: ");
        System.out.println("\tCustomer: " + account.getCustomer().getName());
        System.out.println("\tAccount Type: " + account.getAccountType());
        System.out.println("\tCurrent Balance: $" + account.getBalance());
        System.out.println();

        transactionManager.viewTransactionsByAccount(accountNo);

    }

    static void initializeData(){
        for (Account c: helper.generateAccounts()){
            accountManager.addAccount(c);
        }
    }
}
