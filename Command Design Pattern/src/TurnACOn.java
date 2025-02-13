public class TurnACOn implements Command {
    ReceiverAC receiverAC;

    TurnACOn(ReceiverAC receiverAC) {
        this.receiverAC = receiverAC;
    }

    @Override
    public void execute() {
        receiverAC.turnOnAC();
    }

    @Override
    public void undo() {
        receiverAC.turnOffAC();
    }
}
