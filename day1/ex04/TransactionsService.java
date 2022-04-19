public class TransactionsService {
    UsersList usersList;

    public TransactionsService() {
        this.usersList = new UsersArrayList();
    }

    public void addUser(User user) {
        usersList.addUser(user);
    }

    public Integer showUserBalance(User user) {
        return (user.getBalance());
    }

    public Integer createTransaction(Integer senderId, Integer recipientId, Integer transferAmount) {
        User sender = this.usersList.getUserById(senderId);
        User recipient = this.usersList.getUserById(recipientId);

        Transaction trans1 = new Transaction(sender, recipient, transferAmount);
        Transaction trans2 = new Transaction(recipient, sender, -transferAmount);

        trans2.setIdentifier(trans1.getIdentifier());
        sender.getTransactionsList().addTransaction(trans1);
        recipient.getTransactionsList().addTransaction(trans2);
        return (0);
    }
}
