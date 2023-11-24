package overnight_charges.price;

public class PriceImpl implements Price {
    private double price;

    public PriceImpl(double price) {
        this.price = price;
    }

    public double getPrice() {
        return this.price;
    }
}
