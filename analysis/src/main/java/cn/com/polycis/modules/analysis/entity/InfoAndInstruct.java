package cn.com.polycis.modules.analysis.entity;

public class InfoAndInstruct {

    public InfoAndInstruct() {
    }


    public InfoAndInstruct(String info, String instruct, String data) {
        this.info = info;
        this.instruct = instruct;
        this.data = data;
    }

    //base64解密数据
    private String info;

    //指令
    private String instruct;

    //base64加密原始数据
    private String data;

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getInstruct() {
        return instruct;
    }

    public void setInstruct(String instruct) {
        this.instruct = instruct;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "InfoAndInstruct{" +
                "info='" + info + '\'' +
                ", instruct='" + instruct + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
