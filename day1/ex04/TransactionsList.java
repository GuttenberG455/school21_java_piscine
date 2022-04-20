package ex04;

import java.util.UUID;

public interface TransactionsList {
    void addTransaction(Transaction transaction);

    void removeTransactionById(UUID identifier) throws TransactionNotFoundException;

    Transaction[] toArray();
}
