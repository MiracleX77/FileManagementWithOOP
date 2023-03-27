public class main {
    public static void main(String[] args) {
        DashBoard d = new DashBoard("yod.net.log");
        System.out.println(">>----------------DASH BOARD------------------<<");
        System.out.println(">>--------------------------------------------<<");
        d.viewSizeOfLogData();
        d.viewSizeOfIp();
        d.viewSizeOfBrowser();
        System.out.println(">>--------------------------------------------<<");
        d.viewTopBrowser();
        System.out.println(">>--------------------------------------------<<");
        d.viewTopIpAddress();

    }
}
