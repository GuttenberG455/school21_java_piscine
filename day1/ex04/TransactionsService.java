package ex04;

import java.util.UUID;

public class TransactionsService {


    private UsersList usersList;

    private TransactionsLinkedList unpairedTransactions;

    public TransactionsService() {
        this.usersList = new UsersArrayList();
        this.unpairedTransactions = new TransactionsLinkedList();
    }

    public UsersList getUsersList() {
        return usersList;
    }

    public void addUser(User user) {
        usersList.addUser(user);
    }

    public Integer showUserBalance(User user) {
        return (user.getBalance());
    }

    public void createTransaction(Integer senderId, Integer recipientId, Integer transferAmount)
            throws IllegalTransactionException {

        User sender = this.usersList.getUserById(senderId);
        User recipient = this.usersList.getUserById(recipientId);

        if (transferAmount > 0 && transferAmount > sender.getBalance()) {
            throw new IllegalTransactionException();
        } else if (transferAmount < 0 && -transferAmount > recipient.getBalance()) {
            throw new IllegalTransactionException();
        }
        Transaction trans1 = new Transaction(sender, recipient, transferAmount);
        Transaction trans2 = new Transaction(recipient, sender, -transferAmount);

        sender.setBalance(sender.getBalance() - transferAmount);
        recipient.setBalance(recipient.getBalance() + transferAmount);

        trans2.setIdentifier(trans1.getIdentifier());
        sender.getTransactionsList().addTransaction(trans2);
        recipient.getTransactionsList().addTransaction(trans1);
    }

    public void removeTransaction(Integer userId, UUID transId)
    {
        Transaction transToDelete = this.usersList.getUserById(userId).getTransactionsList().getTransactionByID(transId);

        if (this.unpairedTransactions.isInTransList(transId)) {
            this.unpairedTransactions.removeTransactionById(transId);
        } else {
            Integer secondId = (userId == transToDelete.getSender().getIdentifier())  ?
                    transToDelete.getRecipient().getIdentifier() : transToDelete.getSender().getIdentifier();
            Transaction transToSave = this.usersList.getUserById(secondId).getTransactionsList().getTransactionByID(transId);
            this.unpairedTransactions.addTransaction(transToSave);
        }
        this.usersList.getUserById(userId).getTransactionsList().removeTransactionById(transId);
    }

    public Transaction[] getTransactionsByUserId(Integer userId)
    {
        return (this.usersList.getUserById(userId).getTransactionsList().toArray());
    }

    public Transaction[] getUnpairedTransactions() {
        return (this.unpairedTransactions.toArray());
    }
}
