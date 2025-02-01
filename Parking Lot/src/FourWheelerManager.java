import java.util.List;

public class FourWheelerManager extends ParkingSpotManager {
    public FourWheelerManager(List<ParkingSpot> parkingSpots) {
        super(parkingSpots);
    }

    @Override
    ParkingSpot findParkingSpace() {
        // implement different nearest parking spot algorithms

        for (ParkingSpot parkingSpot : parkingSpots) {
            if (parkingSpot.vehicle == null) {
                return parkingSpot;
            }
        }
        return null;
    }
}
