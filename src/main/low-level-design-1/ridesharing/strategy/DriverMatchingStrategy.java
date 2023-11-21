package ridesharing.strategy;

import ridesharing.model.Driver;
import ridesharing.model.Rider;

import java.util.List;
import java.util.Optional;

public interface DriverMatchingStrategy {

    Optional<Driver> findDriver(Rider rider, List<Driver> nearByDrivers, int origin, int destination);
}
