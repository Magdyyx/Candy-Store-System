public class GiftVoucher {
    private String code;
    private float value;
    private boolean redeemed;

    public GiftVoucher(String code, float value, boolean redeemed) {
        this.code = code;
        this.value = value;
        this.redeemed = redeemed;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public boolean isRedeemed() {
        return redeemed;
    }

    public void setRedeemed(boolean redeemed) {
        this.redeemed = redeemed;
    }
}
