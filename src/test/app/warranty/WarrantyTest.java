package warranty;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class WarrantyTest {

    @Test
    public void testCreateWarranty(){
        Warranty warranty = WarrantyFactory.createWarranty("Walmart");
        assertThat(warranty.getMerchant(), is("Walmart"));
    }
}
