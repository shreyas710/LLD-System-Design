import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<ParkingSpot> parkingSpots = new ArrayList<>();
        for (int i = 1; i <= 100; ++i) {
            if (i <= 50)
                parkingSpots.add(new ParkingSpot(i, 10));
            else
                parkingSpots.add(new ParkingSpot(i, 20));
        }

        ParkingSpotManagerFactory parkingSpotManagerFactory = new ParkingSpotManagerFactory();

        EntranceGate entranceGate = new EntranceGate(parkingSpotManagerFactory);
        ExitGate exitGate = new ExitGate(parkingSpotManagerFactory);

        Vehicle vehicle = new Vehicle(123, VehicleType.TwoWheeler);
        ParkingSpot parkingSpot = entranceGate.findParkingSpace(vehicle.vehicleType, parkingSpots);
        Ticket ticket = entranceGate.generateTicket(vehicle, parkingSpot);

        exitGate.removeVehicle(ticket);
    }
}