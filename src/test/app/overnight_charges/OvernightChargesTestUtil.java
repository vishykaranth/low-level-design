package overnight_charges;

import overnight_charges.calculation.COCCalculationDecorator;
import overnight_charges.calculation.CalculationStrategy;
import overnight_charges.calculation.CalculationStrategyFactory;
import overnight_charges.position.InvalidInstrument;
import overnight_charges.position.Position;
import overnight_charges.price.Price;

public class OvernightChargesTestUtil {
    OvernightCharges populateOvernightCharges(Position position, Price price) throws InvalidInstrument {
        OvernightCharges overnightCharges = new OvernightCharges();
        overnightCharges.setPosition(position);
        overnightCharges.setPrice(price);
        CalculationStrategy calculationStrategy = CalculationStrategyFactory.getCalculationStrategy(position.getInstrumentType());
        overnightCharges.setCalculationStrategy(calculationStrategy);
        return overnightCharges;
    }

    public OvernightCharges populateOvernightChargesWithCOC(Position position, Price price) throws InvalidInstrument {
        OvernightCharges overnightCharges = new OvernightCharges();
        overnightCharges.setPosition(position);
        overnightCharges.setPrice(price);
        CalculationStrategy calculationStrategy = CalculationStrategyFactory.getCalculationStrategy(position.getInstrumentType());
        overnightCharges.setCalculationStrategy(new COCCalculationDecorator(calculationStrategy));
        return overnightCharges;
    }
}
