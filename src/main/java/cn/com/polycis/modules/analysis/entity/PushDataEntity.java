package cn.com.polycis.modules.analysis.entity;

import java.util.Date;

public class PushDataEntity {

    private Integer type;

    private String deviceId;


    private String payload;

    private Date reportTime;

    public Date getReportTime() {
        return reportTime;
    }

    public void setReportTime(Date reportTime) {
        this.reportTime = reportTime;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    @Override
    public String toString() {
        return "DataEntity{" +
                "type=" + type +
                ", deviceId='" + deviceId + '\'' +
                ", payload='" + payload + '\'' +
                ", reportTime=" + reportTime +
                '}';
    }
}
