package ex01;

public class Program {

    public static void main(String[] args) {
        User user1 = new User("Oleg", 1000);
        User user2 = new User("Boris", 1500);
        User user3 = new User("Eva", 2500);
        User user4 = new User("Nancey", 0);

        System.out.println(user4.getIdentifier() + " " + user4.toString());
        System.out.println(user3.getIdentifier() + " " + user3.toString());
        System.out.println(user2.getIdentifier() + " " + user2.toString());
        System.out.println(user1.getIdentifier() + " " + user1.toString());
    }
}
