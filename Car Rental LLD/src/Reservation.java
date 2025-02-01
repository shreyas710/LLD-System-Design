import Product.Vehicle;

import java.util.Date;

public class Reservation {
    int id;
    User user;
    Vehicle vehicle;
    Date bookingDate;
    Date dateBookedFrom;
    Date dateBookedTo;
    Long fromTimestamp;
    Long toTimestamp;
    Location pickupLocation;
    Location dropOffLocation;
    ReservationType reservationType;
    ReservationStatus reservationStatus;
    Location location;

    public void createReserve(User user, Vehicle vehicle) {
        id = 12345;
        this.user = user;
        this.vehicle = vehicle;
        reservationType = ReservationType.DAILY;
        reservationStatus = ReservationStatus.SCHEDULED;
    }
}
