package cn.com.polycis.modules.t2g.entity;


import java.io.Serializable;
import java.util.Date;

public class NsServerEntity implements Serializable {

    /**
     * 序号
     */
    private Integer id;

    /**
     * ns系统名
     */
    private String nsName;

    /**
     * app编号
     */
    private String appNumber;

    /**
     * ns系统的tcp连接地址
     */
    private String nsTcpAddress;

    /**
     * ns系统的udp连接地址
     */
    private String nsUdpAddress;

    /**
     * 对系统名、tco地址、udp地址进行crc加密
     */
    private int crc;

    /**
     * ns系统的状态
     */
    private Integer status;

    /**
     * ns系统的注册时间
     */
    private Date createTime;

    /**
     * ns系统的修改时间
     */
    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNsName() {
        return nsName;
    }

    public void setNsName(String nsName) {
        this.nsName = nsName;
    }

    public String getNsTcpAddress() {
        return nsTcpAddress;
    }

    public void setNsTcpAddress(String nsTcpAddress) {
        this.nsTcpAddress = nsTcpAddress;
    }

    public String getNsUdpAddress() {
        return nsUdpAddress;
    }

    public void setNsUdpAddress(String nsUdpAddress) {
        this.nsUdpAddress = nsUdpAddress;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public int getCrc() {
        return crc;
    }

    public void setCrc(int crc) {
        this.crc = crc;
    }

    public String getAppNumber() {
        return appNumber;
    }

    public void setAppNumber(String appNumber) {
        this.appNumber = appNumber;
    }

    @Override
    public String toString() {
        return "NsServerEntity{" +
                "id=" + id +
                ", nsName='" + nsName + '\'' +
                ", appNumber='" + appNumber + '\'' +
                ", nsTcpAddress='" + nsTcpAddress + '\'' +
                ", nsUdpAddress='" + nsUdpAddress + '\'' +
                ", crc=" + crc +
                ", status=" + status +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }

}
