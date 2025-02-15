import Element.DeluxeRoom;
import Element.DoubleRoom;
import Element.RoomElement;
import Element.SingleRoom;
import Visitor.RoomMaintenance;
import Visitor.RoomPricing;
import Visitor.RoomVisitor;

public class Main {
    public static void main(String[] args) {
        RoomElement singleRoom = new SingleRoom();
        RoomElement doubleRoom = new DoubleRoom();
        RoomElement deluxeRoom = new DeluxeRoom();

        RoomVisitor roomPricing = new RoomPricing();
        singleRoom.accept(roomPricing);
        System.out.println(((SingleRoom)singleRoom).price);

        doubleRoom.accept(roomPricing);
        System.out.println(((DoubleRoom)doubleRoom).price);

        deluxeRoom.accept(roomPricing);
        System.out.println(((DeluxeRoom)deluxeRoom).price);


        RoomVisitor roomMaintenance = new RoomMaintenance();
        singleRoom.accept(roomMaintenance);
        doubleRoom.accept(roomMaintenance);
        deluxeRoom.accept(roomMaintenance);
    }
}