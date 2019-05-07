package cn.com.polycis.modules.application.entity;

import java.util.List;

public class AppMqVO {

    private  Integer appid;
    private String name;
    private List<MqInfoForAPI> datalist;

    public Integer getAppid() {
        return appid;
    }

    public void setAppid(Integer appid) {
        this.appid = appid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MqInfoForAPI> getDatalist() {
        return datalist;
    }

    public void setDatalist(List<MqInfoForAPI> datalist) {
        this.datalist = datalist;
    }

    @Override
    public String toString() {
        return "AppMqVO{" +
                "appid=" + appid +
                ", name='" + name + '\'' +
                ", datalist=" + datalist +
                '}';
    }
}
