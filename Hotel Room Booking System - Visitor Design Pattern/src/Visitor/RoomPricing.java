package Visitor;

import Element.DeluxeRoom;
import Element.DoubleRoom;
import Element.SingleRoom;

public class RoomPricing implements RoomVisitor {
    @Override
    public void visit(SingleRoom room) {
        System.out.println("Pricing computation logic for single room");
        room.price = 1000;
    }

    @Override
    public void visit(DoubleRoom room) {
        System.out.println("Pricing computation logic for double room");
        room.price = 2000;
    }

    @Override
    public void visit(DeluxeRoom room) {
        System.out.println("Pricing computation logic for deluxe room");
        room.price = 3000;
    }
}
