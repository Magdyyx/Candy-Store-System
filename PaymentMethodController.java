import java.util.List;

public class PaymentMethodController {

    public void processPayment(order order, User user, List<GiftVoucher> vouchers, int loyaltyPoints,
            PaymentMethod paymentMethod, float cashAmount) {
        float totalAmount = order.getTotalAmount();
        float remainingAmount = totalAmount;

        // 1) Use gift vouchers to pay for order
        for (GiftVoucher voucher : vouchers) {
            if (!voucher.isRedeemed()) {
                float voucherAmount = voucher.getValue();
                if (voucherAmount <= remainingAmount) {
                    voucher.setRedeemed(true);
                    remainingAmount -= voucherAmount;
                } else {
                    voucher.setRedeemed(false);
                }
            }
        }

        // 2) Redeem loyalty points to pay for order
        float pointsValue = (float) loyaltyPoints / user.getLoyaltyPointsScheme().getPointsPerUnit();
        if (pointsValue <= remainingAmount) {
            user.decreaseLoyaltyPoints(loyaltyPoints);
            remainingAmount -= pointsValue;
        }

        // 3) Pay remaining amount via payment method
        switch (paymentMethod.getMethodType()) {
            case "Smart Wallet":
                SmartWallet smartWallet = (SmartWallet) paymentMethod;
                if (smartWallet.checkBalance(remainingAmount)) {
                    smartWallet.makePayment(remainingAmount);
                    order.setPaymentStatus("Paid");
                } else {
                    order.setPaymentStatus("Failed");
                }
                break;
            case "Credit Card":
                CreditCard creditCard = (CreditCard) paymentMethod;
                if (creditCard.checkLimit(remainingAmount)) {
                    creditCard.makePayment(remainingAmount);
                    order.setPaymentStatus("Paid");
                } else {
                    order.setPaymentStatus("Failed");
                }
                break;
            default:
                order.setPaymentStatus("Failed");
                break;
        }

        // 4) Pay remaining amount with cash upon delivery
        if (order.getPaymentStatus().equals("Pending") && cashAmount >= remainingAmount) {
            order.setPaymentStatus("Paid");
        }
    }
}
