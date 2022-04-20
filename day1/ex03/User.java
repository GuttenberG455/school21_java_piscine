package ex03;

public class User {
    private final Integer identifier;
    private String name;
    private Integer balance;
    private TransactionsLinkedList transactionsList;


    public User(String name, Integer balance) {
        this.identifier = UserIdsGenerator.getInstance().generateId();
        this.name = name;
        this.transactionsList = new TransactionsLinkedList();
        setBalance(balance);
    }

    public Integer getIdentifier() {
        return identifier;
    }

    public String getName() {
        return name;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBalance(Integer balance) {
        if (balance < 0) {
            this.balance = 0;
        } else {
            this.balance = balance;
        }
    }

    public TransactionsLinkedList getTransactionsList() {
        return transactionsList;
    }

    public void setTransactionsList(TransactionsLinkedList transactionsList) {
        this.transactionsList = transactionsList;
    }

    @Override
    public String toString() {
        return (String.format("[%s] %s Balance=%s", identifier, name, balance));
    }
}
