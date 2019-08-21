package cn.com.polycis.modules.dev.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 设备表
 * </p>
 *
 * @author ${author}
 * @since 2018-11-30
 */
@TableName("lo_device_info")
public class DeviceInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自增id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 设备唯一标识
     */
    private String deviceUuid;
    /**
     * 设备名称
     */
    private String name;
    /**
     * 设备描述
     */
    private String description;
    /**
     * 设备类型
     */
    private String type;
    /**
     * 设备状态(0离线,1在线,2未入网)
     */
    private Integer status;
    /**
     * 应用标识
     */
    private Integer appId;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date updateTime;
    /**
     * 删除标识(0删除,1未删除)
     */
    private Integer isDelete;


    private String deviceproId;

    private Integer sensorType;

    private Integer orgId;

    @TableField(exist=false)
    private ActiveVO activeVO;

    @TableField(exist=false)
    private Integer jihuo;
    @TableField(exist=false)
    private String appSKey;
    @TableField(exist=false)
    private String devAddr;
    @TableField(exist=false)
    private String nwkSKey;

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public ActiveVO getActiveVO() {
        return activeVO;
    }

    public void setActiveVO(ActiveVO activeVO) {
        this.activeVO = activeVO;
    }

    public String getAppSKey() {
        return appSKey;
    }

    public void setAppSKey(String appSKey) {
        this.appSKey = appSKey;
    }

    public String getDevAddr() {
        return devAddr;
    }

    public void setDevAddr(String devAddr) {
        this.devAddr = devAddr;
    }

    public String getNwkSKey() {
        return nwkSKey;
    }

    public void setNwkSKey(String nwkSKey) {
        this.nwkSKey = nwkSKey;
    }

    public Integer getJihuo() {
        return jihuo;
    }

    public void setJihuo(Integer jihuo) {
        this.jihuo = jihuo;
    }

    public Integer getSensorType() {
        return sensorType;
    }

    public void setSensorType(Integer sensorType) {
        this.sensorType = sensorType;
    }

    public String getDeviceproId() {
        return deviceproId;
    }

    public void setDeviceproId(String deviceproId) {
        this.deviceproId = deviceproId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeviceUuid() {
        return deviceUuid;
    }

    public void setDeviceUuid(String deviceUuid) {
        this.deviceUuid = deviceUuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public String toString() {
        return "DeviceInfo{" +
        ", id=" + id +
        ", deviceUuid=" + deviceUuid +
        ", name=" + name +
        ", description=" + description +
        ", type=" + type +
        ", status=" + status +
        ", appId=" + appId +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        ", isDelete=" + isDelete +
        "}";
    }
}
