public class Main {
    public static void main(String[] args) {
        ReceiverAC receiverAC = new ReceiverAC();
        InvokerRemote invokerRemote = new InvokerRemote();

        invokerRemote.setCommand(new TurnACOn(receiverAC));
        invokerRemote.pressButton();

        invokerRemote.undoButton();
    }
}