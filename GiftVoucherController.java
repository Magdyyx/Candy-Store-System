import java.util.List;

public class GiftVoucherController {
    private List<GiftVoucher> giftVouchers;
    
    public void addGiftVoucher(GiftVoucher giftVoucher) {
        giftVouchers.add(giftVoucher);
    }
    
    public void removeGiftVoucher(GiftVoucher giftVoucher) {
        giftVouchers.remove(giftVoucher);
    }
    
    public boolean redeemGiftVoucher(String code, float amount) {
        for (GiftVoucher gv : giftVouchers) {
            if (gv.getCode().equals(code) && !gv.isRedeemed()) {
                gv.setRedeemed(true);
                return true;
            }
        }
        return false;
    }
}
