package overnight_charges.position;

public class IndicesPosition implements Position {
    public static final double INDICES_FACTOR = 0.6;
    private int size;
    private String instrument;
    private String state;

    public IndicesPosition(int size, String instrument, String state) {
        this.size = size;
        this.instrument = instrument;
        this.state = state;
    }

    public int getSize() {
        return this.size;
    }

    public String getInstrumentType() {
        return this.instrument;
    }

    public String getState() {
        return this.state;
    }

    public double getPositionValue() {
        return this.size * INDICES_FACTOR;
    }
}
