public class Main {
    public static void main(String[] args) {
        Auction auction = new Auction();
        Bidder bidder1 = new Bidder("Shreyas", auction);
        Bidder bidder2 = new Bidder("Tejas", auction);
        Bidder bidder3 = new Bidder("Madhuri", auction);

        bidder2.placeBid(1200);
        bidder1.placeBid(800);
    }
}