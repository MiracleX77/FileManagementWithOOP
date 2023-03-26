public class main {
    public static void main(String[] args) {
        LogData s = new LogData();
        s.importLogfile("yod.net.log");
        DashBoard d = new DashBoard(s);
        d.viewTopBrower();
        System.out.println("--------------------------------------------");
        d.viewTopIpAddress();

    }
}
