public class InfoLogProccessor extends  LogProccessor{

    public InfoLogProccessor(LogProccessor logProccessor) {
        super(logProccessor);
    }

    @Override
    void log(int logLevel, String logMessage) {
        if(logLevel == INFO){
            System.out.println(logMessage);
        }
        else{
            super.log(logLevel, logMessage);
        }
    }
}
