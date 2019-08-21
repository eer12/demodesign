package cn.com.polycis.modules.application.entity;

import cn.com.polycis.modules.dev.entity.DeviceInfo;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 应用表
 * </p>
 *
 * @author ${author}
 * @since 2018-11-28
 */
@TableName("lo_app_info")
public class AppDevVo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 应用标识
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 应用名称
     */
    private String name;
    /**
     * 应用描述
     */
    private String description;
    /**
     * 应用唯一标识appeui
     */
    private String eui;
    /**
     * 组织id
     */
    private Integer organizationId;
    /**
     * 状态(0启用,1未启用)
     */
    private Integer status;
    /**
     * 开启告警标识(0关闭,1开启)
     */
    private Integer alarmSwitch;
    /**
     * 应用的token
     */
    private String token;
    /**
     * 服务key
     */
    private String appKey;
    /**
     * 修改时间
     */
    private Date updateTime;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 删除标识(0删除,1未删除)
     */
    private Integer isDelete;

    private String otherAppId;

    private Integer networkConfigId;

    private List<DeviceInfo> deviceInfoList;

    public List<DeviceInfo> getDeviceInfoList() {
        return deviceInfoList;
    }

    public void setDeviceInfoList(List<DeviceInfo> deviceInfoList) {
        this.deviceInfoList = deviceInfoList;
    }

    public Integer getNetworkConfigId() {
        return networkConfigId;
    }

    public void setNetworkConfigId(Integer networkConfigId) {
        this.networkConfigId = networkConfigId;
    }

    public String getOtherAppId() {
        return otherAppId;
    }

    public void setOtherAppId(String otherAppId) {
        this.otherAppId = otherAppId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getEui() {
        return eui;
    }

    public void setEui(String eui) {
        this.eui = eui;
    }

    public Integer getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getAlarmSwitch() {
        return alarmSwitch;
    }

    public void setAlarmSwitch(Integer alarmSwitch) {
        this.alarmSwitch = alarmSwitch;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public String toString() {
        return "AppDevVo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", eui='" + eui + '\'' +
                ", organizationId=" + organizationId +
                ", status=" + status +
                ", alarmSwitch=" + alarmSwitch +
                ", token='" + token + '\'' +
                ", appKey='" + appKey + '\'' +
                ", updateTime=" + updateTime +
                ", createTime=" + createTime +
                ", isDelete=" + isDelete +
                ", otherAppId='" + otherAppId + '\'' +
                ", networkConfigId=" + networkConfigId +
                ", deviceInfoList=" + deviceInfoList +
                '}';
    }
}
