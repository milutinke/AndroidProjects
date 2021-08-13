package rs.raf.projekat1.dusan_milutinovic_10518.viewmodels;

public class BankTransaction {
    private String title;
    private int amount;
    private String description;
    private BankTransactionType type;

    public BankTransaction(String title, int amount, String description, BankTransactionType type) {
        this.title = title;
        this.amount = amount;
        this.description = description;
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BankTransactionType getType() {
        return type;
    }

    public enum BankTransactionType {
        INCOME,
        EXPENSE
    }
}
