import java.util.List;

public class LoyaltyPointsController {
    private Catalog catalog;

    public LoyaltyPointsController(Catalog catalog) {
        this.catalog = catalog;
    }

    public void setLoyaltyPoints(User user, int points) {
        user.setLoyaltyPoints(points);
    }

    public void setLoyaltyPointsScheme(int points) {
        catalog.setLoyaltyPointsScheme(points);
    }

    public int getLoyaltyPointsScheme() {
        return catalog.getLoyaltyPointsScheme();
    }

    public void updateLoyaltyPoints(User user, int points) {
        int currentPoints = user.getLoyaltyPoints();
        user.setLoyaltyPoints(currentPoints + points);
    }

    public void redeemLoyaltyPoints(User user, int points) {
        int currentPoints = user.getLoyaltyPoints();
        if (currentPoints >= points) {
            user.setLoyaltyPoints(currentPoints - points);
        }
    }

    public float calculateDiscount(order order) {
        User user = order.getUser();
        int loyaltyPoints = user.getLoyaltyPoints();
        int pointsToDiscount = (int) (loyaltyPoints / catalog.getLoyaltyPointsScheme());
        float totalDiscount = pointsToDiscount * catalog.getLoyaltyPointsDiscount();
        return totalDiscount;
    }

    public void applyGiftVoucher(order order, GiftVoucher voucher) {
        if (voucher.isRedeemed()) {
            throw new IllegalStateException("Voucher has already been redeemed");
        }
        float voucherValue = voucher.getValue();
        float orderTotal = order.getTotalAmount();
        float amountToPay = orderTotal - voucherValue;
        if (amountToPay < 0) {
            voucherValue = orderTotal;
            amountToPay = 0;
        }
        order.setTotal(amountToPay);
        voucher.setRedeemed(true);
        order.getAppliedVouchers().add(voucher);
    }

    public boolean validateGiftVoucher(String voucherCode) {
        List<Item> itemsInCart = CartController.getCartItems(User.getId());
        float cartTotal = CartController.calculateCartTotal(itemsInCart);
        GiftVoucher voucher = catalog.getGiftVoucherByCode(voucherCode);
        if (voucher == null) {
            return false;
        }
        if (voucher.isRedeemed()) {
            return false;
        }
        if (voucher.getValue() > cartTotal) {
            return false;
        }
        return true;
    }
}
