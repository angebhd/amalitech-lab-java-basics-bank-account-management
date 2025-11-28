package transaction;

public interface Transactable {
    boolean processTransaction(double amount, TransactionType type);
}
