package transaction;

public class TransactionManager {
    private final Transaction[] transactions = new Transaction[200];
    private int transactionCount = 0;

    public void addTransaction(Transaction transaction){
        if(transactionCount == this.transactions.length){
            System.out.println("Maximum transaction reached");
            return;
        }
        transactions[transactionCount] = transaction;
        transactionCount++;
    }

    public void viewTransactionsByAccount(String accountNumber){
        boolean found = false;
        double deposits = 0;
        double withdrawals = 0;
        for(int i =0; i < this.transactionCount; i++){
            if(this.transactions[i].getAccountNumber().equals(accountNumber)){

                if (!found) {
                    System.out.println();
                    System.out.println("___________________________________________");
                    System.out.println(" TXN ID |       DATE/TIME        |  TYPE    |   AMOUNT   | BALANCE ");
                    System.out.println("_____________________________________________");
                    found=true;
                }
                double transactionType = this.transactions[i].getType().equals(TransactionType.DEPOSIT) ? 1 : -1;

                if (transactionType > 0)
                    deposits += this.transactions[i].getAmount();
                else
                    withdrawals += this.transactions[i].getAmount();

                System.out.println(this.transactions[i].getTransactionId() + " | " + this.transactions[i].getTimestamp() + " | " +
                        this.transactions[i].getType().toString()  + " | $" + transactionType*this.transactions[i].getAmount() + " | $" +
                        this.transactions[i].getBalanceAfter());
            }
        }
        if (found){
            System.out.println();
            System.out.println("Total transactions: " + transactions.length);
            System.out.println("___________________________________________");
            System.out.println("Total deposits: $" + deposits);
            System.out.println("Total withdrawals: $" + withdrawals);
            System.out.println("Net change: $" + (deposits-withdrawals));
        }else
            System.out.println("No transactions recorded for this account");

    }

    public double calculateTotalDeposits(String accountNumber){
        double sum = 0;
        for(Transaction transaction: this.transactions){
            if(transaction.getAccountNumber().equals(accountNumber) && transaction.getType().equals(TransactionType.DEPOSIT)){
                sum+= transaction.getAmount();
            }
        }
        return sum;
    }

    public double calculateTotalWithdrawals(String accountNumber){
        double sum = 0;
        for(Transaction transaction: this.transactions){
            if(transaction.getAccountNumber().equals(accountNumber) && transaction.getType().equals(TransactionType.WITHDRAW)){
                sum+= transaction.getAmount();
            }
        }
        return sum;
    }

    public int getTransactionCount(){
        return this.transactionCount + 1;
    }
}
