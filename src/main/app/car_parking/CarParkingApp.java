package car_parking;

public class CarParkingApp {
    public static void main(String[] args) {
        int capacity = 3;
        CarParking carParking = new CarParking(capacity);
        int slotNumberShashi = carParking.park("Shashi", "KA 05 MV 1234");
        int slotNumberMJ = carParking.park("MJ", "KA 03 MB 6734");
        String display = carParking.dashboard();

        System.out.println(display);
    }
}
