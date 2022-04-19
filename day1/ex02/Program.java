public class Program {

    public static void main(String[] args) {
        UsersList usersList = new UsersArrayList();

        for (int i = 0; i < 9; i++) {
            User user = new User("Boka " + (i + 1), i * 100);
            usersList.addUser(user);
            user = new User("Joka " + (i + 1), i * 50);
            usersList.addUser(user);
            user = new User("Doka " + (i + 1), i * 250);
            usersList.addUser(user);
        }
        System.out.println("Amount of users " + usersList.getUserCount());
        for (int i = 0; i < usersList.getUserCount(); i++) {
            System.out.println(usersList.getUserByIndex(i).toString());
        }
        System.out.println("User with ID 50 " + usersList.getUserById(50));

    }
}
