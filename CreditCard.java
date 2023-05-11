public class CreditCard extends PaymentMethod {
    private float limit;
    private float balance;

    public CreditCard(String type, float limit, float balance) {
        super(type);
        this.limit = limit;
        this.balance = balance;
    }

    public float getLimit() {
        return limit;
    }

    public void setLimit(float limit) {
        this.limit = limit;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public boolean checkLimit(float amount) {
        return limit >= amount + balance;
    }

    public void makePayment(float amount) {
        balance += amount;
    }

    public boolean checkBalance(float amount) {
        return balance >= amount;
    }
}
