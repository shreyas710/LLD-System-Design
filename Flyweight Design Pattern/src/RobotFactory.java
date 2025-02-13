import java.util.HashMap;
import java.util.Map;

public class RobotFactory {
    private static Map<String, Robot> robotObjectCache = new HashMap<String, Robot>();

    public static Robot createRobot(String robotName) {
        if (robotObjectCache.containsKey(robotName)) {
            return robotObjectCache.get(robotName);
        } else {
            if (robotName.equals("HUMAN")) {
                Sprites humanSprite = new Sprites();
                Robot human = new HumanRobot(robotName, humanSprite);
                robotObjectCache.put(robotName, human);
                return human;
            } else if (robotName.equals("DOG")) {
                Sprites dogSprite = new Sprites();
                Robot dog = new DogRobot(robotName, dogSprite);
                robotObjectCache.put(robotName, dog);
                return dog;
            }
        }
        return null;
    }
}
