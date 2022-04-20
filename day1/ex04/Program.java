package ex04;

import java.util.UUID;

public class Program {

    public static void main(String[] args) {
        TransactionsService transactionsService = new TransactionsService();

        transactionsService.addUser(new User("John", 10000));
        transactionsService.addUser(new User("Mike", 2000));
        transactionsService.addUser(new User("Eva", 5000));
        transactionsService.addUser(new User("Nancey", 0));

        System.out.println(" -- User list before transactions -- ");
        for (int i = 0; i < transactionsService.getUsersList().getUserCount(); i++) {
            System.out.println(transactionsService.getUsersList().getUserByIndex(i));
        }

        transactionsService.createTransaction(1, 2, 500);
        transactionsService.createTransaction(3, 4, 1000);
        transactionsService.createTransaction(4, 2, 200);
        transactionsService.createTransaction(4, 1, -300);
//        transactionsService.createTransaction(4, 12, 200);

        System.out.println("\n -- Transactions of John -- ");
        if (transactionsService.getTransactionsByUserId(1) != null) {
            for (Transaction t : transactionsService.getTransactionsByUserId(1)) {
                System.out.println(t.toString());
            }
        }
        //Delete first transaction of John
        UUID idToDelete = transactionsService.getUsersList().getUserById(1).getTransactionsList().toArray()[0].getIdentifier();
        System.out.println(idToDelete);
        transactionsService.removeTransaction(1, idToDelete);

        System.out.println("\n -- Transactions of John -- ");
        if (transactionsService.getTransactionsByUserId(1) != null) {
            for (Transaction t : transactionsService.getTransactionsByUserId(1)) {
                System.out.println(t.toString());
            }
        }
        System.out.println(" -- Transactions of Mike -- ");
        if (transactionsService.getTransactionsByUserId(2) != null) {
            for (Transaction t : transactionsService.getTransactionsByUserId(2)) {
                System.out.println(t.toString());
            }
        }
        System.out.println(" -- Transactions of Eva -- ");
        if (transactionsService.getTransactionsByUserId(3) != null) {
            for (Transaction t : transactionsService.getTransactionsByUserId(3)) {
                System.out.println(t.toString());
            }
        }
        System.out.println(" -- Transactions of Nancey -- ");
        if (transactionsService.getTransactionsByUserId(4) != null) {
            for (Transaction t : transactionsService.getTransactionsByUserId(4)) {
                System.out.println(t.toString());
            }
        }
        System.out.println("\n -- User list after transactions -- ");
        for (int i = 0; i < transactionsService.getUsersList().getUserCount(); i++) {
            System.out.println(transactionsService.getUsersList().getUserByIndex(i));
        }

        System.out.println("\n -- Unpaired transaction list before 2nd deletion -- ");
        if (transactionsService.getUnpairedTransactions() != null) {
            for (Transaction t : transactionsService.getUnpairedTransactions()) {
                System.out.println(t.toString());
            }
        }
        //Delete first transaction of Mike (and it is unpaired)
        idToDelete = transactionsService.getUsersList().getUserById(2).getTransactionsList().toArray()[0].getIdentifier();
        System.out.println(idToDelete);
        transactionsService.removeTransaction(2, idToDelete);

        System.out.println("\n -- Unpaired transaction list before 2nd deletion -- ");
        if (transactionsService.getUnpairedTransactions() != null) {
            for (Transaction t : transactionsService.getUnpairedTransactions()) {
                System.out.println(t.toString());
            }
        }
    }
}
