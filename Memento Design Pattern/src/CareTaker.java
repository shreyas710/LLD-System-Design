import java.util.ArrayList;
import java.util.List;

public class CareTaker {
    List<Memento> history = new ArrayList<>();

    public void addMemento(Memento memento) {
        history.add(memento);
    }

    public Memento undo() {
        if (!history.isEmpty()) {
            int lastIndex = history.size() - 1;
            Memento memento = history.get(lastIndex);
            history.remove(lastIndex);
            return memento;
        }
        return null;
    }
}
