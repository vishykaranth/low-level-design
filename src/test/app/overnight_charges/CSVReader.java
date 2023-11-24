package overnight_charges;

import overnight_charges.position.InvalidInstrument;
import overnight_charges.position.Position;
import overnight_charges.position.PositionFactory;
import overnight_charges.price.Price;
import overnight_charges.price.PriceImpl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader {

    public static void main(String[] args) {
        String csvFile = "src/test/positions.csv";
        BufferedReader br = null;
        String line;
        String cvsSplitBy = ",";

        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                String[] positions = line.split(cvsSplitBy);
                System.out.println("Position [quantity= " + positions[0] + " , instrument=" + positions[1] + "]");

                calculateCharges(positions);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    static OvernightChargesTestUtil overnightChargesTestUtil = new OvernightChargesTestUtil();

    static void calculateCharges(String[] positions) {

        int size = Integer.parseInt(positions[0]);
        String instrument = positions[1];
        String state = positions[2];

        Position position = null;
        try {
            position = PositionFactory.createPosition(size, instrument, state);
        } catch (InvalidInstrument invalidInstrument) {
            invalidInstrument.printStackTrace();
        }
        Price price = new PriceImpl(5.0);

        OvernightCharges overnightCharges = null;
        try {
            overnightCharges = overnightChargesTestUtil.populateOvernightCharges(position, price);
        } catch (InvalidInstrument invalidInstrument) {
            invalidInstrument.printStackTrace();
        }
        double charge = overnightCharges.getCharges();
        System.out.println(charge);
    }


}
