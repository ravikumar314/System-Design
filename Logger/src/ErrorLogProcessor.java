public class ErrorLogProcessor extends LogProccessor{
    public ErrorLogProcessor(LogProccessor logProccessor) {
        super(logProccessor);
    }

    @Override
    void log(int logLevel, String logMessage) {
        if(logLevel == ERROR){
            System.out.println("Error" + logMessage);
        }
        else{
            super.log(logLevel, logMessage);
        }

    }
}
