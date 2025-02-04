public class Main {
    public static void main(String[] args) {
        Vehicle v1 = new SportVehicle();
        v1.drive();

        Vehicle v2 = new PassengerVehicle();
        v2.drive();

        Vehicle v3 = new OffroadVehicle();
        v3.drive();
    }
}