import java.util.List;
import java.util.Set;

public class DashBoard{
    private final LogData logData;
    public DashBoard(LogData logData) {
        this.logData = logData;
    }
    public DashBoard(String filename){
        LogData logdata = new LogData();
        logdata.importLogfile(filename);
        this.logData = logdata;
    }
    public void viewIpAddress(){
        for (String ip : logData.getIpAddress()){
            System.out.println("--> "+ip);
        }
    }

    public void viewBrowser(){
        for (String ip : logData.getBrowser()){
            System.out.println("--> "+ip);
        }
    }
    public void viewTopBrowser(){
        List<List<String>> lists = logData.topBrowser();
        for (int i = 0;i<10;i++){
            System.out.println("--> Top : "+(i+1)+" >> "+lists.get(i).get(0)+"::<< count is >> "+lists.get(i).get(1));
        }
    }
    public void viewTopIpAddress(){
        List<List<String>> lists = logData.topIpAddress();
        for (int i = 0;i<10;i++){
            System.out.println("--> Top : "+(i+1)+" >> "+lists.get(i).get(0)+"::<< count is >> "+lists.get(i).get(1));
        }
    }
    public void viewSizeOfIp(){
        System.out.println("--> Size Of IP Address is >> "+ logData.getSizeOfIpAddress()+" <<");
    }
    public void viewSizeOfBrowser(){
        System.out.println("--> Size Of Device Browser is >> "+ logData.getSizeOfBrowser()+" <<");
    }
    public void viewSizeOfLogData(){
        System.out.println("--> Size Of LogData is >> "+ logData.getSizeDataLogs()+" <<");
    }
}
