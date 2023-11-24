package car_parking;


import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class CarParkingTest {

    CarParking carParking;
    @Before
    public void setUp(){
        carParking = new CarParking(3);
    }

    @Test
    public void testCapacity(){
        assertThat(carParking.availableParking(), is(3));
    }

    @Test
    public void testParking(){
        int slotNumberShashi = carParking.park("Shashi", "KA 05 MV 1234");
        assertThat(slotNumberShashi, is(1));
        int slotNumberMJ = carParking.park("MJ", "KA 03 MB 6734");
        assertThat(slotNumberMJ, is(2));
        int slotNumberVishwa = carParking.park("Vishwa", "KA 01 MF 1734");
        assertThat(slotNumberVishwa, is(3));
        int slotNumberMadhu = carParking.park("Madhu", "KA 02 MR 8711");
        assertThat(slotNumberMadhu, is(-1));
    }

    @Test
    public void testUnParking(){
        int charge = carParking.unpark("Shashi", "KA 05 MV 1234");
        assertThat(charge, is(10));

        int slotNumberMadhu = carParking.park("Madhu", "KA 02 MR 8711");
        assertThat(slotNumberMadhu, is(1));
    }
}