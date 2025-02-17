public class Main {
    public static void main(String[] args) {
        CareTaker careTaker = new CareTaker();
        Originator originator = new Originator(5, 10);

        Memento snapshot1 = originator.createMemento();
        careTaker.addMemento(snapshot1);

        originator.setHeight(7);
        originator.setWidth(12);

        Memento snapshot2 = originator.createMemento();
        careTaker.addMemento(snapshot2);

        originator.setHeight(9);
        originator.setWidth(14);

        Memento undoMemento = careTaker.undo();
        originator.restoreMemento(undoMemento);

        System.out.println(originator.height + " " + originator.width);
    }
}