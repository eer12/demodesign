package cn.com.polycis.common.vo;

import java.util.Map;

public class RequestAPIVO {

    private Map<String, Object> data;

    private Map<String, Object> user;

    private Map<String, Object> dev;

    public Map<String, Object> getDev() {
        return dev;
    }

    public void setDev(Map<String, Object> dev) {
        this.dev = dev;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public Map<String, Object> getUser() {
        return user;
    }

    public void setUser(Map<String, Object> user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "RequestAPIVO{" +
                "data=" + data +
                ", user=" + user +
                '}';
    }
}
