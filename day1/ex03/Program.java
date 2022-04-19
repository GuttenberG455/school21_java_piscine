import java.util.UUID;

public class Program {

    public static void main(String[] args) {
        User user1 = new User("Nif-Nif", 1000);
        User user2 = new User("Nuf-Nuf", 5000);
        User user3 = new User("Naf-Naf", 30000);
        TransactionsLinkedList transactions = new TransactionsLinkedList();
        for (int i = 1; i < 6; i++) {
            Transaction transact = new Transaction(user2, user3, -100 * i);
            transactions.addTransaction(transact);
            transact = new Transaction(user3, user2, 100 * i);
            transactions.addTransaction(transact);
            user2.getTransactionsList().addTransaction(transact);
            transact = new Transaction(user1, user2, -5 * i);
            transactions.addTransaction(transact);
            user2.getTransactionsList().addTransaction(transact);
            transact = new Transaction(user2, user1, 5 * i);
            transactions.addTransaction(transact);
        }
        System.out.println(" -- All Transactions -- ");
        for (Transaction t : transactions.toArray()) {
            System.out.println(t.toString());
        }
        System.out.println(" -- Transactions of Nuf-Nuf -- ");
        for (Transaction t : user2.getTransactionsList().toArray()) {
            System.out.println(t.toString());
        }
        transactions.removeTransactionById(transactions.toArray()[0].getIdentifier());
        transactions.removeTransactionById(transactions.toArray()[0].getIdentifier());
        System.out.println(" -- All Transactions after deletion -- ");
        for (Transaction t : transactions.toArray()) {
            System.out.println(t.toString());
        }
    }
}
