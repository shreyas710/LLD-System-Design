public class Bill {
    Reservation reservation;
    double total;
    boolean paid;

    Bill(Reservation reservation) {
        this.reservation = reservation;
        this.total = computeBillAmount();
        this.paid = false;
    }

    private double computeBillAmount(){
        return 100.0;
    }

}
