public class Main {
    public static void main(String[] args) {
        LogProcessor log = new InfoLogProcessor(new DebugLogProcessor(new ErrorLogProcessor(null)));
        log.log(LogProcessor.ERROR, "divide by zero");
        log.log(LogProcessor.INFO, "just for information");
        log.log(LogProcessor.DEBUG, "need to debug this");
    }
}