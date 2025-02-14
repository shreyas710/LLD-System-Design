import java.util.ArrayList;
import java.util.List;

public class Auction implements Mediator {
    List<Colleague> colleagues = new ArrayList<Colleague>();

    @Override
    public void addBidder(Colleague bidder) {
        colleagues.add(bidder);
    }

    @Override
    public void placeBid(Colleague bidder, int bid) {
        for (Colleague colleague : colleagues) {
            if (!colleague.getName().equals(bidder.getName())) {
                colleague.receiveBidNotification(bid);
            }
        }
    }
}
