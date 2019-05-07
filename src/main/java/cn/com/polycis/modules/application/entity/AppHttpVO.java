package cn.com.polycis.modules.application.entity;

import java.util.List;

public class AppHttpVO {

    private  Integer appid;
    private String name;
    private List<HttpInfoForAPI> datalist;

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

    public List<HttpInfoForAPI> getDatalist() {
        return datalist;
    }

    public void setDatalist(List<HttpInfoForAPI> datalist) {
        this.datalist = datalist;
    }

    @Override
    public String toString() {
        return "AppHttpVO{" +
                "appid=" + appid +
                ", name='" + name + '\'' +
                ", datalist=" + datalist +
                '}';
    }
}
