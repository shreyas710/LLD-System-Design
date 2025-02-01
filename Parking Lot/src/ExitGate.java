import java.util.ArrayList;

public class ExitGate {
    ParkingSpotManagerFactory parkingSpotManagerFactory;

    public ExitGate(ParkingSpotManagerFactory parkingSpotManagerFactory) {
        this.parkingSpotManagerFactory = parkingSpotManagerFactory;
    }

    void removeVehicle(Ticket ticket) {
        ParkingSpotManager parkingSpotManager = parkingSpotManagerFactory.getParkingSpotManager(ticket.vehicle.vehicleType, new ArrayList<>());
        parkingSpotManager.removeVehicle(ticket.vehicle);
    }
}
