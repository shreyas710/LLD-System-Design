package Element;

import Visitor.RoomVisitor;

public class DeluxeRoom implements RoomElement {
    public int price = 0;

    @Override
    public void accept(RoomVisitor visitor) {
        visitor.visit(this);
    }
}
