import java.util.UUID;

public class Program {

    public static void main(String[] args) {
        TransactionsService transactionsService = new TransactionsService();

        for (int i = 1; i < 4; i++) {
            User user = new User("Boka " + i, i * 1000);
            transactionsService.addUser(user);
            user = new User("Joka " + i, i * 500);
            transactionsService.addUser(user);
            user = new User("Doka " + i, i * 2500);
            transactionsService.addUser(user);
        }
        System.out.println("Amount of users " + transactionsService.usersList.getUserCount());
        for (int i = 0; i < transactionsService.usersList.getUserCount(); i++) {
            System.out.println(transactionsService.usersList.getUserByIndex(i).toString());
        }
        transactionsService.createTransaction(2, 1, 100);
        transactionsService.createTransaction(1, 2, 200);
        transactionsService.createTransaction(2, 3, -300);

        for (Transaction t : transactionsService.usersList.getUserById(1).getTransactionsList().toArray()) {
            System.out.println(t.toString());
        }

    }
}
