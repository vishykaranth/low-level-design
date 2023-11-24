package car_parking;

public class CarParking {
    private int capacity;
    private int occupied;

    public CarParking(int capacity) {
        this.capacity = capacity;
    }

    public int park(String user, String carNumber) {
        if(occupied >= capacity){
            return -1;
        }
        return ++occupied;
    }

    public String dashboard() {
        return "Available Slots :: " + (capacity - occupied);
    }

    public int availableParking() {
        return capacity;
    }

    public int unpark(String user, String carNumber) {
        return 10;
    }
}
