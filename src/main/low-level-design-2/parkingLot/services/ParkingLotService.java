package parkingLot.services;

import parkingLot.dao.ParkingLotDao;

/**
 * 
 * @created 18/04/2021
 */
public class ParkingLotService {
    private final ParkingLotDao parkingLotDao;

    public ParkingLotService(ParkingLotDao parkingLotDao) {
        this.parkingLotDao = parkingLotDao;
    }


}
