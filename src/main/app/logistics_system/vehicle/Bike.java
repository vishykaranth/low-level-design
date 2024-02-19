package logistics_system.vehicle;

public class Bike extends Vehicle {

    private final static int capacityofBike = 10;

    public Bike(int id, String vehicleNo) {

        super(id, vehicleNo, capacityofBike);
    }
}

