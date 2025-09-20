
public class Main {
    public static void main(String[] args) {

        LogProccessor logObj = new InfoLogProccessor(new DebugLogProcessor(new ErrorLogProcessor(null)));
        logObj.log(1, "this is the error");
    }
}