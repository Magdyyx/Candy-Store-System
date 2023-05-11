public class SmartWallet extends PaymentMethod {
    private float balance;

    public SmartWallet(String type, float balance) {
        super(type);
        this.balance = balance;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public boolean checkBalance(float amount) {
        return balance >= amount;
    }

    public void makePayment(float amount) {
        balance -= amount;
    }
}
