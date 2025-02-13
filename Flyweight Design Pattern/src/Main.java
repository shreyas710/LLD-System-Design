public class Main {
    public static void main(String[] args) {
        Robot humanRobot1 = RobotFactory.createRobot("HUMAN");
        humanRobot1.display(1,2);
        Robot humanRobot2 = RobotFactory.createRobot("HUMAN");
        humanRobot2.display(2,3);
        Robot dogRobot1 = RobotFactory.createRobot("DOG");
        dogRobot1.display(1,2);
    }
}