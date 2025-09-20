public class DebugLogProcessor extends LogProccessor{

    public DebugLogProcessor(LogProccessor logProccessor) {
        super(logProccessor);
    }

    @Override
    void log(int logLevel, String logMessage) {
        if(logLevel == DEBUG){
            System.out.println(logMessage);
        }
        else {
            super.log(logLevel, logMessage);
        }

    }
}
