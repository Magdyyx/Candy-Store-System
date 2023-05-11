public class LoyaltyPointsScheme {
    private String name;
    private int pointsPerUnit;

    public LoyaltyPointsScheme(String name, int pointsPerUnit) {
        this.name = name;
        this.pointsPerUnit = pointsPerUnit;
    }

    public String getName() {
        return name;
    }

    public int getPointsPerUnit() {
        return pointsPerUnit;
    }
}
