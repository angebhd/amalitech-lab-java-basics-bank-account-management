package helper;

import account.Account;
import account.CheckingAccount;
import account.SavingsAccount;
import customer.Customer;
import customer.PremiumCustomer;
import customer.RegularCustomer;

import java.util.Scanner;

public class Helper {

    public Account[] generateAccounts(){
        Customer[] cs = generateCustomers();
        Account account1 = new CheckingAccount(cs[0],1000, "ACTIVE");
        Account account2 = new CheckingAccount(cs[1],2000, "ACTIVE");
        Account account3 = new CheckingAccount(cs[2],3000, "ACTIVE");
        Account account4 = new SavingsAccount(cs[3],11000, "ACTIVE");
        Account account5 = new SavingsAccount(cs[4],12000, "ACTIVE");


        return  new Account[]{account1, account2, account3, account4, account5};
    }

    public Customer[] generateCustomers(){
        Customer cust1 = new RegularCustomer("Ange Buhendwa", 35, "AA 11 st 12, City", "+1 123 123 123");
        Customer cust2 = new RegularCustomer("Joel Kayembe", 35, "AA 21 st 22, City", "+2 123 123 123");
        Customer cust3 = new PremiumCustomer("Ernest Manzi", 35, "AA 31 st 32, City", "+3 123 123 123");
        Customer cust4 = new PremiumCustomer("Josh Obama", 35, "AA 41 st 42, City", "+4 123 123 123");
        Customer cust5 = new PremiumCustomer("Carl Doe", 35, "AA 51 st 52, City", "+5 123 123 123");

        return new Customer[]{cust1, cust2, cust3, cust4, cust5};
    }



    public int validateIntInput(Scanner scanner, int max) {
        int input;
        while (true) {
            if (!scanner.hasNextInt()) {
                System.out.print("Invalid integer, try again: ");
                scanner.nextLine(); // Consume the invalid input
                continue;  // Continue prompting until a valid integer is entered
            }
            input = scanner.nextInt();
            if (input <= 0 || input > max) {
                System.out.print("Invalid number, choose a number in the specified range (1 - " + (max) + "). Try again: ");
            } else {
                break;  // Exit the loop if the input is valid
            }
        }
        scanner.nextLine();  // Clear the buffer
        return input;
    }

    public double validateDoubleInput(Scanner scanner) {
        return validateDoubleInput(scanner, "Invalid number, should be greater than 0 try again...");
    }
    public double validateDoubleInput(Scanner scanner, String msg) {
        return validateDoubleInput(scanner, 1, msg);
    }
    // Validate double input with a minimum value and a custom message
    public double validateDoubleInput(Scanner scanner, double min, String msg) {
        double input;
        while (true) {
            if (!scanner.hasNextDouble()) {
                System.out.print(msg);
                scanner.nextLine();  // Consume the invalid input
                continue;
            }

            input = scanner.nextDouble();
            if (input < min) {
                System.out.print(msg);
            } else {
                break;
            }
        }
        scanner.nextLine();
        return input;
    }
}


