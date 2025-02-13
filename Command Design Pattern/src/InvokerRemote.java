import java.util.Stack;

public class InvokerRemote {
    Stack<Command> addCommands = new Stack<>();
    Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
        addCommands.add(command);
    }

    public void undoButton() {
        if (!addCommands.isEmpty()) {
            command = addCommands.pop();
            command.undo();
        }
    }
}
