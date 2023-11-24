package overnight_charges;

import overnight_charges.calculation.CalculationStrategy;
import overnight_charges.position.Position;
import overnight_charges.price.Price;

public class OvernightCharges {
    private Position position;
    private Price price;
    private CalculationStrategy calculationStrategy;

    public double getCharges() {
        return calculationStrategy.calculate(price, position);
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public void setCalculationStrategy(CalculationStrategy calculationStrategy) {
        this.calculationStrategy = calculationStrategy;
    }
}
