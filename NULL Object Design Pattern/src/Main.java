public class Main {
    public static void main(String[] args) {
        Vehicle vehicle = VehicleFactory.makeVehicle("Bike");
        printVehicleDetails(vehicle);
    }

    private static void printVehicleDetails(Vehicle vehicle) {
        System.out.println("Tank capacity: " + vehicle.getTankCapacity());
        System.out.println("Seating capacity: " + vehicle.getSeatingCapacity());
    }
}