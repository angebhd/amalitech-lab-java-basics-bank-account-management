# Java Basic Lab - Bank Account Management
This is a bank account management CLI application, build with Java only

**By Ange Buhendwa**


## Overview
A console-based bank account management system that allows users to create accounts, manage transactions, and view account details. The application supports different customer types (Regular and Premium) and account types (Savings and Checking) with specific features and benefits.

## Features
- **Account Management**: Create and view bank accounts
- **Customer Types**: 
  - Regular Customer: Standard banking features
  - Premium Customer: Waived monthly fees on checking accounts
- **Account Types**:
  - Savings Account: 3.5% interest rate, $500 minimum balance
  - Checking Account: $1,000 overdraft limit, $10 monthly fee (waived for premium customers)
- **Transaction Processing**: Deposit and withdrawal operations
- **Transaction History**: View complete transaction records by account
- **Auto-generated IDs**: Automatic generation of account, customer, and transaction IDs

## Project Structure
```
├── account/           # Account classes (Account, SavingsAccount, CheckingAccount)
├── customer/          # Customer classes (Customer, RegularCustomer, PremiumCustomer)
├── transaction/       # Transaction management classes
├── menu/             # User interface and menu system
├── helper/           # Utility classes
└── Main.java         # Application entry point
```

## Project Setup
**Requirements:**
- JDK version 21 or higher

**Running the project**: 

```bash
# Clone and access the repository
git clone https://github.com/angebhd/amalitech-lab-java-basics-bank-account-management.git
cd amalitech-lab-java-basics-bank-account-management

# Compile and run the project
javac Main.java
java Main
```

## Usage
The application provides a menu-driven interface with the following options:

1. **Create Account**: Set up new customer and account with initial deposit
2. **View Accounts**: Display all accounts with balances and details
3. **Process Transaction**: Perform deposits or withdrawals
4. **View Transaction History**: Review transaction records for specific accounts
5. **Exit**: Close the application

## Account Features
- **Savings Account**: Earns 3.5% interest, requires $500 minimum balance
- **Checking Account**: Allows overdraft up to $1,000, $10 monthly fee (waived for premium customers with sufficient balance)
- **Premium Customer Benefits**: Monthly fee waiver on checking accounts