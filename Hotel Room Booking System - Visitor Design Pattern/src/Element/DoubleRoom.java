package Element;

import Visitor.RoomVisitor;

public class DoubleRoom implements RoomElement {
    public int price;

    @Override
    public void accept(RoomVisitor visitor) {
        visitor.visit(this);
    }
}
