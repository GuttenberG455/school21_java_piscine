package ex04;

public class IllegalTransactionException  extends RuntimeException {
    @Override
    public String toString() {
        return ("\nIllegalTransactionException\nNot enough funds to make this transaction!");
    }
}
