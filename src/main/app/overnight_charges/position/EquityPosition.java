package overnight_charges.position;

public class EquityPosition implements Position{
    public static final double EQUITY_FACTOR = 0.8;
    private int size;
    private String instrumentType;
    private String state;

    public EquityPosition(int size, String instrumentType, String state) {
        this.size = size;
        this.instrumentType = instrumentType;
        this.state = state;
    }

    public int getSize() {
        return size;
    }

    public String getInstrumentType() {
        return instrumentType;
    }

    public String getState() {
        return state;
    }

    public double getPositionValue() {
        return this.size * EQUITY_FACTOR;
    }
}
