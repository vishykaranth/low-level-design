package overnight_charges.position;

public class PositionFactory {
    public static Position createPosition(int size, String instrument, String state) throws InvalidInstrument {
        if(instrument.equalsIgnoreCase("INDICES")){
            return new IndicesPosition(size, instrument, state);
        }else if(instrument.equalsIgnoreCase("EQUITY")){
            return new EquityPosition(size, instrument, state);
        }else if(instrument.equalsIgnoreCase("FX")){
            return new FXPosition(size, instrument, state);
        }else if(instrument.equalsIgnoreCase("COMMODITY")){
            return new CommodityPosition(size, instrument, state);
        }
        throw new InvalidInstrument("Invalid instrument :: " + instrument);
    }
}
