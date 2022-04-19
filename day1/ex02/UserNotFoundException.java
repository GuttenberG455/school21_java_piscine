public class UserNotFoundException extends RuntimeException {
    @Override
    public String toString() {
        return ("\nUserNotFoundException\nUser not found!");
    }
}
