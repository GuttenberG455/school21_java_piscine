import java.util.UUID;

public class TransactionsLinkedList implements TransactionsList {

    private Integer length = 0;

    private final TransactionNode start = new TransactionNode(null,null,null);
    private final TransactionNode end = new TransactionNode(null,null,null);

    public TransactionsLinkedList() {
        start.setNext(end);
        end.setPrev(start);
    }

    @Override
    public void addTransaction(Transaction transaction) {
        TransactionNode tmp = start;
        while (tmp.getNext() != end) {
            tmp = tmp.getNext();
        }
        tmp.setNext(new TransactionNode(transaction, end, tmp));
        this.length++;
    }

    @Override
    public void removeTransactionById(UUID identifier) throws TransactionNotFoundException {
        TransactionNode tmp = start.getNext();
        while (tmp != end) {
            if (tmp.getData().getIdentifier() == identifier) {
                tmp.getPrev().setNext(tmp.getNext());
                tmp.getNext().setPrev(tmp.getPrev());
                tmp.setData(null);
                tmp.setPrev(null);
                tmp.setNext(null);
                length--;
                return ;
            }
            tmp = tmp.getNext();
        }
        throw new TransactionNotFoundException();
    }

    @Override
    public Transaction[] toArray() {
        Transaction[] transactions = new Transaction[this.length];
        TransactionNode tmp = this.start.getNext();

        if (tmp.getData() == null) {
            return (null);
        } else {
            for (int i = 0; i < this.length; i++) {
                transactions[i] = tmp.getData();
                tmp = tmp.getNext();
            }
        }
        return (transactions);
    }

    public Integer getLength() {
        return length;
    }
}
