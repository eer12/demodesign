package cn.com.polycis.modules.dev.entity;

import java.util.Date;

public class DataList {

    private Date time;
    private String devEUI;

    private String deviceName;
    private String  data;

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getDevEUI() {
        return devEUI;
    }

    public void setDevEUI(String devEUI) {
        this.devEUI = devEUI;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "DataList{" +
                "time=" + time +
                ", devEUI='" + devEUI + '\'' +
                ", deviceName='" + deviceName + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
