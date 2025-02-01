import java.util.List;

public class ParkingSpotManagerFactory {
    ParkingSpotManager getParkingSpotManager(VehicleType vehicleType, List<ParkingSpot> parkingSpots) {
        if (vehicleType == VehicleType.TwoWheeler) {
            return new TwoWheelerManager(parkingSpots);
        } else if (vehicleType == VehicleType.FourWheeler) {
            return new FourWheelerManager(parkingSpots);
        }
        return null;
    }
}
