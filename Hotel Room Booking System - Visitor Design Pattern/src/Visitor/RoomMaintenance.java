package Visitor;

import Element.DeluxeRoom;
import Element.DoubleRoom;
import Element.SingleRoom;

public class RoomMaintenance implements RoomVisitor {
    @Override
    public void visit(SingleRoom room) {
        System.out.println("Maintenance computation logic for single room");
    }

    @Override
    public void visit(DoubleRoom room) {
        System.out.println("Maintenance computation logic for double room");
        room.price = 2000;
    }

    @Override
    public void visit(DeluxeRoom room) {
        System.out.println("Maintenance computation logic for deluxe room");
        room.price = 3000;
    }
}
