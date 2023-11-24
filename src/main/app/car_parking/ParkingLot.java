package car_parking;

class Car {
    private String licensePlate;

    public Car(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getLicensePlate() {
        return licensePlate;
    }
}

class Spot {
    private int number;
    private Car car;

    public Spot(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public Car getCar() {
        return car;
    }

    public void park(Car car) {
        this.car = car;
    }

    public void leave() {
        this.car = null;
    }

    public boolean isAvailable() {
        return car == null;
    }
}

class Level {
    private int floor;
    private Spot[] spots;

    public Level(int floor, int numberOfSpots) {
        this.floor = floor;
        this.spots = new Spot[numberOfSpots];
        for (int i = 0; i < numberOfSpots; i++) {
            spots[i] = new Spot(i);
        }
    }

    public int getFloor() {
        return floor;
    }

    public Spot[] getSpots() {
        return spots;
    }

    public boolean park(Car car) {
        for (Spot spot : spots) {
            if (spot.isAvailable()) {
                spot.park(car);
                return true;
            }
        }
        return false;
    }

    public boolean leave(Car car) {
        for (Spot spot : spots) {
            if (spot.getCar() == car) {
                spot.leave();
                return true;
            }
        }
        return false;
    }
}

public class ParkingLot {
    private Level[] levels;

    public ParkingLot(int numberOfLevels, int numberOfSpotsPerLevel) {
        this.levels = new Level[numberOfLevels];
        for (int i = 0; i < numberOfLevels; i++) {
            levels[i] = new Level(i, numberOfSpotsPerLevel);
        }
    }
}