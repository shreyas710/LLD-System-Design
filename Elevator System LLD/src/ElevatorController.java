import java.util.PriorityQueue;

public class ElevatorController {
    ElevatorCar elevatorCar;

    PriorityQueue<Integer> upMinQ;
    PriorityQueue<Integer> downMaxQ;

    ElevatorController(ElevatorCar elevatorCar) {
        this.elevatorCar = elevatorCar;
        upMinQ = new PriorityQueue<>();
        downMaxQ = new PriorityQueue<>();
    }

    public void submitExternalRequest(int floor, Direction direction) {
        if (direction == Direction.DOWN) {
            downMaxQ.offer(floor);
        } else {
            upMinQ.offer(floor);
        }
    }

    public void submitInternalRequest(int floor) {

    }

    public void controlElevator() {
        
    }
}
