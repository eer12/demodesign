package cn.com.polycis.modules.t2g.entity;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;



public class DataEntity implements Serializable {
    /**
     * 序号
     */
    private Integer id;


    /**
     * 设备唯一标识
     */
    private DeviceEntity deviceEntity;

    /**
     * 具体数据内容
     */
    private byte[] payload;

    /**
     * 对payload加密后的内容
     */
    private String data;

    /**
     * 数据校验码
     */
    private Integer crc;

    /**
     * 数据类型
     */
    private Integer type;

    /**
     * 数据状态：undo/fail/success/refuse
     */
    private String status;

    /**
     * 数据标识符
     */
    private Integer uuid;

    /**
     * 下发数据是否需要应答机制
     */
    private boolean isAck = false;

    /**
     * 数据下发失败的次数
     */
    private int failDownLoadCount;

    /**
     * 数据创建时间
     */
    private Date createTime;

    /**
     * 数据的最后修改时间
     */
    private Date updateTime;

    public DataEntity() {
        JSONObject jsonObject1 =JSONObject.parseObject("ss");
    }


    public DataEntity(DeviceEntity deviceEntity, byte[] payload, Integer crc, Integer type, Integer uuid, Date createTime) {
        this.deviceEntity = deviceEntity;
        this.payload = payload;
        this.crc = crc;
        this.type = type;
        this.uuid = uuid;
        this.createTime = createTime;
    }

    public DeviceEntity getDeviceEntity() {

        return deviceEntity;
    }

    public void setDeviceEntity(DeviceEntity deviceEntity) {
        this.deviceEntity = deviceEntity;
    }

    public byte[] getPayload() {
        return payload;
    }

    public void setPayload(byte[] payload) {
        this.payload = payload;
    }

    public Integer getCrc() {
        return crc;
    }

    public void setCrc(Integer crc) {
        this.crc = crc;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getUuid() {
        return uuid;
    }

    public void setUuid(Integer uuid) {
        this.uuid = uuid;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isAck() {
        return isAck;
    }

    public void setAck(boolean ack) {
        isAck = ack;
    }

    public int getFailDownLoadCount() {
        return failDownLoadCount;
    }

    public void setFailDownLoadCount(int failDownLoadCount) {
        this.failDownLoadCount = failDownLoadCount;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "DataEntity{" +
                "id=" + id +
                ", deviceEntity=" + deviceEntity +
                ", payload=" + Arrays.toString(payload) +
                ", data='" + data + '\'' +
                ", crc=" + crc +
                ", type=" + type +
                ", status='" + status + '\'' +
                ", uuid=" + uuid +
                ", isAck=" + isAck +
                ", failDownLoadCount=" + failDownLoadCount +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
