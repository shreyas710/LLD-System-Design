import Shape.Shape;
import Shape.Rectangle;
import Shape.Square;
import Shape.Circle;

public class ShapeFactory {
    public Shape getShape(String shapeType) {
        Shape shape = null;
        switch (shapeType) {
            case "Rectangle":
                shape = new Rectangle();
                break;
            case "Circle":
                shape = new Circle();
                break;
            case "Square":
                shape = new Square();
                break;
            default:
                break;
        }
        return shape;
    }
}
