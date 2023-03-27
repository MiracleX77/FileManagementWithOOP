public class ModelLog {
    private String ipAddress;
    private String time;
    private String deviceType;
    private String newAttr;
    private String referURL;
    private String browser;

    @Override
    public String toString() {
        return "ModelLog{" +
                "ipAddress='" + ipAddress + '\'' +
                ", time='" + time + '\'' +
                ", deviceType='" + deviceType + '\'' +
                ", newAttr='" + newAttr + '\'' +
                ", referURL='" + referURL + '\'' +
                ", brower='" + browser + '\'' +
                '}';
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getIpAddress() {
        return ipAddress;
    }
    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }
    public String getDeviceType() {
        return deviceType;
    }
    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }
    public String getNewAttr() {
        return newAttr;
    }
    public void setNewAttr(String newAttr) {
        this.newAttr = newAttr;
    }
    public String getReferURL() {
        return referURL;
    }
    public void setReferURL(String referURL) {
        this.referURL = referURL;
    }
    public String getBrowser() {
        return browser;
    }
    public void setBrowser(String browser) {
        this.browser = browser;
    }
}
