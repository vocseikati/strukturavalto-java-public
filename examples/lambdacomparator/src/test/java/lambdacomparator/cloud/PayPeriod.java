package lambdacomparator.cloud;

public enum PayPeriod {

    ANNUAL(12),
    LIFETIME(60),
    MONTHLY(1);

    private int length;

    PayPeriod(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }
}
