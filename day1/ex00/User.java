public class User {
    private Integer identifier;
    private String name;
    private Integer balance;

    public User(String name, Integer balance) {
        this.name = name;
        if (balance < 0) {
            this.balance = 0;
        } else {
            this.balance = balance;
        }
    }

    public Integer getIdentifier() {
        return identifier;
    }

    public String getName() {
        return name;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setIdentifier(Integer identifier) {
        this.identifier = identifier;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBalance(Integer balance) {
        if (balance < 0) {
            this.balance = 0;
        } else {
            this.balance = balance;
        }
    }

    @Override
    public String toString() {
        return (String.format("[%s] %s Balance=%s", identifier, name, balance));
    }
}
