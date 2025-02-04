import Strategy.SpecialDriveStrategy;

public class SportVehicle extends Vehicle {
    SportVehicle() {
        super (new SpecialDriveStrategy());
    }
}
