public interface Mediator {
    void addBidder(Colleague bidder);
    void placeBid(Colleague bidder, int bid);
}
