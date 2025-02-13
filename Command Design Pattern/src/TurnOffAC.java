public class TurnOffAC implements Command {
    ReceiverAC receiverAC;

    TurnOffAC(ReceiverAC receiverAC) {
        this.receiverAC = receiverAC;
    }

    @Override
    public void execute() {
        receiverAC.turnOffAC();
    }

    @Override
    public void undo() {
        receiverAC.turnOnAC();
    }
}
