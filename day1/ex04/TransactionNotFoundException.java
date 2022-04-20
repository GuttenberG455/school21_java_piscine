package ex04;

public class TransactionNotFoundException extends RuntimeException{
    @Override
    public String toString() {
        return ("\nTransactionNotFoundException\nTransaction not found!");
    }
}