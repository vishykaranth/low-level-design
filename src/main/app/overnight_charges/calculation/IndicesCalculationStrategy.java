package overnight_charges.calculation;

import overnight_charges.position.Position;
import overnight_charges.price.Price;

/*
    Formula : ((priceVal * positionValue) * 15)/10;
*/
public class IndicesCalculationStrategy implements CalculationStrategy{
    public double calculate(Price price, Position position) {
        double priceVal = price.getPrice();
        double positionValue = position.getPositionValue();

        double charge = ((priceVal * positionValue) + 15)/10;

        return charge;
    }
}
