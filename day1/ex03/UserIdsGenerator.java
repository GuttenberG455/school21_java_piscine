package ex03;

public final class UserIdsGenerator {
    private static final UserIdsGenerator userIdsGenerator = new UserIdsGenerator();

    public static int id = 0;

    private UserIdsGenerator() {
    }

    public static UserIdsGenerator getInstance() {
        return userIdsGenerator;
    }

    public int generateId() {
        id++;
        return (id);
    }
}
