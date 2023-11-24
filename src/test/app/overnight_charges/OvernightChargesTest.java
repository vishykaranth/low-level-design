package overnight_charges;

import org.junit.Before;
import org.junit.Test;
import overnight_charges.position.InvalidInstrument;
import overnight_charges.position.Position;
import overnight_charges.position.PositionFactory;
import overnight_charges.price.Price;
import overnight_charges.price.PriceImpl;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class OvernightChargesTest {
    OvernightChargesTestUtil overnightChargesTestUtil;
    @Before
    public void setUp(){
        overnightChargesTestUtil = new OvernightChargesTestUtil();
    }

    @Test
    public void testOvernightChargesProcessingForEquity() throws Exception {
        Position position = PositionFactory.createPosition(10, "EQUITY", "OPEN");
        Price price = new PriceImpl(5.0);

        OvernightCharges overnightCharges = overnightChargesTestUtil.populateOvernightCharges(position, price);
        double charge = overnightCharges.getCharges();
        assertThat(charge, is(10.0));
    }

    @Test
    public void testOvernightChargesForIndices() throws Exception {
        Position position = PositionFactory.createPosition(10, "INDICES", "OPEN");
        Price price = new PriceImpl(5.0);

        OvernightCharges overnightCharges = overnightChargesTestUtil.populateOvernightCharges(position, price);
        double charge = overnightCharges.getCharges();
        assertThat(charge, is(4.5));
    }

    @Test
    public void testOvernightChargesForFX() throws Exception {
        Position position = PositionFactory.createPosition(10, "FX", "OPEN");
        Price price = new PriceImpl(5.0);

        OvernightCharges overnightCharges = overnightChargesTestUtil.populateOvernightCharges(position, price);
        double charge = overnightCharges.getCharges();
        assertThat(charge, is(3.8));
    }

    @Test
    public void testOvernightChargesForCommodity() throws Exception {
        Position position = PositionFactory.createPosition(10, "COMMODITY", "OPEN");
        Price price = new PriceImpl(5.0);

        OvernightCharges overnightCharges = overnightChargesTestUtil.populateOvernightCharges(position, price);
        double charge = overnightCharges.getCharges();
        assertThat(charge, is(5.3));
    }

    @Test(expected = InvalidInstrument.class)
    public void testOvernightChargesInvalidInstrument() throws InvalidInstrument {
        PositionFactory.createPosition(10, "DUMMY", "OPEN");
    }


    @Test
    public void testOvernightChargesForEquitiesWithCOC() throws Exception {
        Position position = PositionFactory.createPosition(10, "EQUITY", "OPEN");
        Price price = new PriceImpl(5.0);

        OvernightCharges overnightCharges = overnightChargesTestUtil.populateOvernightChargesWithCOC(position, price);
        double charge = overnightCharges.getCharges();
        assertThat(charge, is(8.5));
    }
}
