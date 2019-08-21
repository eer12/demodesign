package cn.com.polycis.modules.dev.entity;

public class ActiveVO {

    private String appSKey;
    private String devAddr;
    private String nwkSKey;
    private boolean skipFCntCheck;
    private Integer fCntDown;
    private String fCntUp;

    public String getAppSKey() {
        return appSKey;
    }

    public void setAppSKey(String appSKey) {
        this.appSKey = appSKey;
    }

    public String getDevAddr() {
        return devAddr;
    }

    public void setDevAddr(String devAddr) {
        this.devAddr = devAddr;
    }

    public String getNwkSKey() {
        return nwkSKey;
    }

    public void setNwkSKey(String nwkSKey) {
        this.nwkSKey = nwkSKey;
    }

    public boolean isSkipFCntCheck() {
        return skipFCntCheck;
    }

    public void setSkipFCntCheck(boolean skipFCntCheck) {
        this.skipFCntCheck = skipFCntCheck;
    }

    public Integer getfCntDown() {
        return fCntDown;
    }

    public void setfCntDown(Integer fCntDown) {
        this.fCntDown = fCntDown;
    }

    public String getfCntUp() {
        return fCntUp;
    }

    public void setfCntUp(String fCntUp) {
        this.fCntUp = fCntUp;
    }

    @Override
    public String toString() {
        return "ActiveVO{" +
                "appSKey='" + appSKey + '\'' +
                ", devAddr='" + devAddr + '\'' +
                ", nwkSKey='" + nwkSKey + '\'' +
                ", skipFCntCheck=" + skipFCntCheck +
                ", fCntDown=" + fCntDown +
                ", fCntUp='" + fCntUp + '\'' +
                '}';
    }
}
