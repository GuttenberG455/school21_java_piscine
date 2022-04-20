package ex00;

public class Program {

    public static void main(String[] args) {
        User user1 = new User("Oleg", 1000);
        user1.setIdentifier(1);
        User user2 = new User("Boris", 1500);
        user2.setIdentifier(2);

        System.out.println(user1);
        System.out.println(user2);
        Transaction transaction1 = new Transaction(user1, user2, 600);
        System.out.println(transaction1);
        Transaction transaction2 = new Transaction(user2, user1, -1600);
        System.out.println(transaction2);

        user2.setName("Dasha");
        System.out.println(user2.getName());

        user1.setBalance(user1.getBalance() + 2222);
        System.out.println(user1.getBalance());
    }
}
