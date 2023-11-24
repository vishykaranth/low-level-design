package overnight_charges.position;

public interface Position {
    int getSize();
    String getInstrumentType();
    String getState();

    double getPositionValue();
}
