package cn.com.polycis.modules.t2g.entity;

import java.io.Serializable;
import java.util.Date;

public class DeviceEntity implements Serializable {
    /**
     * 序号
     */
    private int id;

    /**
     * 设备唯一标识
     */
    private String devUID;

    /**
     * 设备别名
     */
    private String devName;

    /**
     * 设备关联的ns服务
     */
    private NsServerEntity nsServerEntity;

    /**
     * 设备类型（0主设备 1从设备）
     */
    private Integer type;

    /**
     * 设备状态(0运行 1离线)
     */
    private int status;

    /**
     * 设备描述信息
     */
    private String describe;

    /**
     * 设备的扩展模式
     */
    private Integer pattern;

    /**
     * 设备的添加时间
     */
    private Date createTime;

    /**
     * 设备的修改时间
     */
    private Date updateTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDevUID() {
        return devUID;
    }

    public void setDevUID(String devUID) {
        this.devUID = devUID;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
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

    public NsServerEntity getNsServerEntity() {
        return nsServerEntity;
    }

    public void setNsServerEntity(NsServerEntity nsServerEntity) {
        this.nsServerEntity = nsServerEntity;
    }

    public String getDevName() {
        return devName;
    }

    public void setDevName(String devName) {
        this.devName = devName;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public Integer getPattern() {
        return pattern;
    }

    public void setPattern(Integer pattern) {
        this.pattern = pattern;
    }

    @Override
    public String toString() {
        return "DeviceEntity{" +
                "id=" + id +
                ", devUID='" + devUID + '\'' +
                ", devName='" + devName + '\'' +
                ", nsServerEntity=" + nsServerEntity +
                ", type=" + type +
                ", status=" + status +
                ", describe='" + describe + '\'' +
                ", pattern=" + pattern +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
