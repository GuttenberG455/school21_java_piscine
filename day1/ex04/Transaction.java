import java.util.UUID;

public class Transaction {
    private UUID identifier;
    private User recipient;
    private User sender;
    private TransferCategory transferCategory;
    private Integer transferAmount;

    public enum TransferCategory {
        CREDIT ("OUTCOME", ""),
        DEBIT ("INCOME", "+");

        private final String text;
        private final String sign;

        TransferCategory(String text, String sign) {
            this.text = text;
            this.sign = sign;
        }

        public String getText() {
            return text;
        }

        public String getSign() {
            return sign;
        }
    }

    public Transaction(User recipient, User sender, Integer transferAmount) {
        this.identifier = UUID.randomUUID();
        this.recipient = recipient;
        this.sender = sender;
        if (transferAmount > 0) {
            setTransferCategory(TransferCategory.DEBIT);
        } else {
            setTransferCategory(TransferCategory.CREDIT);
        }
        this.transferAmount = transferAmount;
    }

    public void setIdentifier(UUID identifier) {
        this.identifier = identifier;
    }

    public UUID getIdentifier() {
        return identifier;
    }

    public User getRecipient() {
        return recipient;
    }

    public User getSender() {
        return sender;
    }

    public TransferCategory getTransferCategory() {
        return transferCategory;
    }

    public void setTransferCategory(TransferCategory transferCategory) {
        this.transferCategory = transferCategory;
    }

    public Integer getTransferAmount() {
        return transferAmount;
    }

    @Override
    public String toString() {
        return (String.format("[%d] %s -> [%d] %s, %s%s, %s, %s", sender.getIdentifier(), sender.getName(), recipient.getIdentifier(), recipient.getName(), transferCategory.sign, transferAmount, transferCategory.text, identifier));
    }
}
