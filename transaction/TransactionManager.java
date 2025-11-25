package transaction;

public class TransactionManager {
    private final Transaction[] transactions = new Transaction[200];
    private int transactionCount = 0;

    public void addTransaction(Transaction transaction){
        if(transactionCount == this.transactions.length){
            System.out.println("Maximum trasction reached");
            return;
        }
        transactions[transactionCount] = transaction;
        transactionCount++;
    }

    public void viewTransactionsByAccount(String accountNumber){
        for(Transaction transaction: this.transactions){
            if(transaction.getAccountNumber().equals(accountNumber)){
                System.out.println("Transaction detail");
            }
        }
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
