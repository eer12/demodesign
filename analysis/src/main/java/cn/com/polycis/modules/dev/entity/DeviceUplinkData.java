package cn.com.polycis.modules.dev.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 设备上行数据表
 * </p>
 *
 * @author ${author}
 * @since 2018-11-30
 */
//@TableName("lo_device_uplink_data")
@TableName("union_upload_device_data")
public class DeviceUplinkData implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自增id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 设备标识
     */
    private Integer deviceId;
    /**
     * 设备唯一标识
     */
    private String deviceUuid;

    /**
     * 类型
     */
    private Integer type;
    /**
     * 内容
     */
    private String info;
    /**
     * 应用自增id
     */
    private Integer appId;
    /**
     * 创建时间
     */
    private Date createTime;

    private Date reportTime;

    /**
     * base64加密数据
     */
    private String data;

    private String json;

    private Integer kind;

    private Date startTime;

    private Date endTime;

    private Integer orgId;

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }

    public Date getReportTime() {
        return reportTime;
    }

    public void setReportTime(Date reportTime) {
        this.reportTime = reportTime;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceUuid() {
        return deviceUuid;
    }

    public void setDeviceUuid(String deviceUuid) {
        this.deviceUuid = deviceUuid;
    }


    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Integer getAppId() {
        return appId;
    }

    public void setAppId(Integer appId) {
        this.appId = appId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getKind() {
        return kind;
    }

    public void setKind(Integer kind) {
        this.kind = kind;
    }


    @Override
    public String toString() {
        return "DeviceUplinkData{" +
                "id=" + id +
                ", deviceId=" + deviceId +
                ", deviceUuid='" + deviceUuid + '\'' +
                ", type=" + type +
                ", info='" + info + '\'' +
                ", appId=" + appId +
                ", createTime=" + createTime +
                ", reportTime=" + reportTime +
                ", data='" + data + '\'' +
                ", json='" + json + '\'' +
                ", kind=" + kind +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", orgId=" + orgId +
                '}';
    }
}
