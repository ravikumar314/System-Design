public abstract class LogProccessor {

    public static  int INFO = 1;
    public static  int DEBUG = 2;
    public static  int ERROR = 3;
    LogProccessor nextLogger;


    public LogProccessor(LogProccessor logProccessor){
        this.nextLogger = logProccessor;
    }

    void log(int logLevel, String logMessage){

        if(nextLogger != null){
            nextLogger.log(logLevel, logMessage);
        }
    }

}
