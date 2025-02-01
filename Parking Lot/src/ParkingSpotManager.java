import java.util.List;

abstract class ParkingSpotManager {
    List<ParkingSpot> parkingSpots;

    public ParkingSpotManager(List<ParkingSpot> parkingSpots) {
        this.parkingSpots = parkingSpots;
    }

    abstract ParkingSpot findParkingSpace();

    void parkVehicle(Vehicle vehicle) {
        ParkingSpot parkingSpot = findParkingSpace();
        parkingSpot.parkVehicle(vehicle);
    }

    void removeVehicle(Vehicle vehicle) {
        for (ParkingSpot parkingSpot : parkingSpots) {
            if (parkingSpot.vehicle != null && parkingSpot.vehicle.equals(vehicle)) {
                parkingSpot.removeVehicle();
                return;
            }
        }
    }
}
