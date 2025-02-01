public class ElevatorCar {
    int id;
    Display display;
    ElevatorState elevatorState;
    int currentFloor;
    InternalButtons internalButtons;
    Direction elevatorDirection;
    ElevatorDoor elevatorDoor;

    public ElevatorCar() {
        display = new Display();
        internalButtons = new InternalButtons();
        elevatorState = ElevatorState.IDLE;
        currentFloor = 0;
        elevatorDirection = Direction.UP;
        elevatorDoor = new ElevatorDoor();
    }

    public void showDisplay() {
        display.display();
    }

    public void pressButton(int destination) {
        internalButtons.pressButton(destination, this);
    }

    public void setDisplay() {
        this.display.setDisplay(currentFloor, elevatorDirection);
    }

    boolean moveElevator(Direction dir, int destination) {
        int start = currentFloor;
        if (dir == Direction.UP) {
            for (int i = start; i <= destination; i++) {
                this.currentFloor = start;
                setDisplay();
                showDisplay();
                if (i == destination) {
                    return true;
                }
            }
        }
        if (dir == Direction.DOWN) {
            for (int i = start; i >= destination; i--) {
                this.currentFloor = start;
                setDisplay();
                showDisplay();
                if (i == destination) {
                    return true;
                }
            }
        }
        return false;
    }
}
