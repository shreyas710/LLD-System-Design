import java.util.List;

public class TwoWheelerManager extends ParkingSpotManager {
    public TwoWheelerManager(List<ParkingSpot> parkingSpots) {
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
