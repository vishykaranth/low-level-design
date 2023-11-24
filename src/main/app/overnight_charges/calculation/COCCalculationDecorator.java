package overnight_charges.calculation;

import overnight_charges.position.Position;
import overnight_charges.price.Price;

/*
    Default COC Value : 0.85
*/
public class COCCalculationDecorator implements CalculationStrategy{
    CalculationStrategy calculationStrategy;

    public COCCalculationDecorator(CalculationStrategy calculationStrategy){
        this.calculationStrategy = calculationStrategy;
    }

    public double calculate(Price price, Position position) {
        return calculationStrategy.calculate(price, position) * getDefaultCOC();
    }

    private double getDefaultCOC() {
        //TODO: Fetch COC based on 2 currencies via some utility later
        return 0.85;
    }
}
