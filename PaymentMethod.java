public abstract class PaymentMethod {
    private String methodType;

    public PaymentMethod(String methodType) {
        this.methodType = methodType;
    }

    public String getMethodType() {
        return methodType;
    }

    public void setMethodType(String methodType) {
        this.methodType = methodType;
    }

    public abstract boolean checkBalance(float amount);

    public abstract void makePayment(float amount);
}
