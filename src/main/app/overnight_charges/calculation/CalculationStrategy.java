package overnight_charges.calculation;

import overnight_charges.position.Position;
import overnight_charges.price.Price;

public interface CalculationStrategy {
    double calculate(Price price, Position position);
}
