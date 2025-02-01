import java.util.List;

public class Building {
    List<Floor> floorList;

    Building(List<Floor> floors) {
        this.floorList = floors;
    }

    public void addFloor(Floor floor) {
        floorList.add(floor);
    }

    public void removeFloor(Floor floor) {
        floorList.remove(floor);
    }

    List<Floor> getAllFloors() {
        return floorList;
    }
}
