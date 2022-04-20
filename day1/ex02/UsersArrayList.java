package ex02;

public class UsersArrayList implements UsersList {
    private Integer capacity = DEFAULT_SIZE;
    private Integer size = 0;

    private User[] users = new User[DEFAULT_SIZE];

    @Override
    public void addUser(User user) throws NullPointerException {
        if (size == capacity - 1) {
            users = reallocUserArray(users);
        }
        if (user == null) {
            throw new NullPointerException();
        } else {
            users[size] = user;
            size++;
        }
    }

    private User[] reallocUserArray(User[] users) {
        this.capacity = this.capacity * 2;
        User[] tmp = new User[this.capacity];
        for (int i = 0; i <= size; i++) {
            tmp[i] = users[i];
        }
        return (tmp);
    }

    @Override
    public User getUserById(Integer id) throws UserNotFoundException {
        for (int i = 0; i < this.size; i++) {
            if (users[i].getIdentifier().equals(id)) {
                return (users[i]);
            }
        }
        throw new UserNotFoundException();
    }

    @Override
    public User getUserByIndex(Integer index) throws UserNotFoundException, ArrayIndexOutOfBoundsException {
        if (index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        else if (users[index] == null) {
            throw new UserNotFoundException();
        } else {
            return (users[index]);
        }
    }
    @Override
    public Integer getUserCount() {
        return (this.size);
    }
}
