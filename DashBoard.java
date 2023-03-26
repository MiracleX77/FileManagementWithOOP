import java.util.List;
import java.util.Set;

public class DashBoard{
    private final LogData logData;
    public DashBoard(LogData logData) {
        this.logData = logData;
    }
    public Set<String> getIpAddress(){
        return logData.getIpAddress();
    }
    public void viewIpAddress(){
        for (String ip : logData.getIpAddress()){
            System.out.println("--> "+ip);
        }
    }
    public Set<String> getBrower(){
        return logData.getBrower();
    }
    public void viewBrower(){
        for (String ip : logData.getIpAddress()){
            System.out.println("--> "+ip);
        }
    }
    public void viewTopBrower(){
        List<List<String>> lists = logData.topBrower();
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

}
