public class VehicleFactory {
    static Vehicle makeVehicle(String vehicleType) {
        if (vehicleType.equalsIgnoreCase("car")) {
            return new Car();
        }
        return new NullVehicle();
    }
}
