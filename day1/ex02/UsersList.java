public interface UsersList {
    static Integer DEFAULT_SIZE = 10;

    void addUser(User user);

    User getUserById(Integer id) throws UserNotFoundException;

    User getUserByIndex(Integer index) throws UserNotFoundException;

    Integer getUserCount();
}
