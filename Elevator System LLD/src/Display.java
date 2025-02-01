public class Display {
    int floor;
    Direction direction;

    public void setDisplay(int floor, Direction direction) {
        this.floor = floor;
        this.direction = direction;
    }

    public void display() {
        System.out.println("Floor: " + floor);
        System.out.println("Direction: " + direction);
    }
}
