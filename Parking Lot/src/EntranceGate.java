import java.util.List;

public class EntranceGate {
    ParkingSpotManagerFactory parkingSpotManagerFactory;

    public EntranceGate(ParkingSpotManagerFactory parkingSpotManagerFactory) {
        this.parkingSpotManagerFactory = parkingSpotManagerFactory;
    }

    ParkingSpot findParkingSpace(VehicleType vehicleType, List<ParkingSpot> parkingSpots) {
        ParkingSpotManager parkingSpotManager = parkingSpotManagerFactory.getParkingSpotManager(vehicleType, parkingSpots);
        return parkingSpotManager.findParkingSpace();
    }

    Ticket generateTicket(Vehicle vehicle, ParkingSpot parkingSpot) {
        // implementation to generate ticket

        return null;
    }
}
