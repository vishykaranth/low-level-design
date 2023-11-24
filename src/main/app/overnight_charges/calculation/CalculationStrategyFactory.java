package overnight_charges.calculation;

import overnight_charges.position.InvalidInstrument;

public class CalculationStrategyFactory {
    public static CalculationStrategy getCalculationStrategy(String instrument) throws InvalidInstrument {
        if(instrument.equalsIgnoreCase("EQUITY")){
            return new EquityCalculationStrategy();
        }
        if(instrument.equalsIgnoreCase("INDICES")){
            return new IndicesCalculationStrategy();
       }

        if(instrument.equalsIgnoreCase("FX")){
            return new FXCalculationStrategy();
        }
        if(instrument.equalsIgnoreCase("COMMODITY")){
            return new COMMODITYCalculationStrategy();
        }

        throw new InvalidInstrument("Invalid Instrument : " + instrument);
    }
}
