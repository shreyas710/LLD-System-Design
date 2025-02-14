public class Bidder implements Colleague {
    String name;
    Mediator mediator;

    Bidder(String name, Mediator mediator) {
        this.name = name;
        this.mediator = mediator;
        mediator.addBidder(this);
    }

    @Override
    public void placeBid(int bid) {
        mediator.placeBid(this, bid);
    }

    @Override
    public void receiveBidNotification(int bid) {
        System.out.println("Bidder " + name + " received notification that someone has bid: " + bid);
    }

    @Override
    public String getName() {
        return name;
    }
}
