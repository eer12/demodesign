package cn.com.polycis.modules.dev.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author ${author}
 * @since 2019-01-21
 */
@TableName("union_device")
public class UnionDevice implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自增id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * lora/nb/2g设备表的id
     */
    private String secondId;
    /**
     * 名称
     */
    private String name;
    /**
     * 设备唯一标识
     */
    private String deviceUuid;
    /**
     * 应用id
     */
    private Integer appId;
    /**
     * 平台类型lora/nb/2g
     */
    private String type;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 用户id
     */
    private Integer userId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSecondId() {
        return secondId;
    }

    public void setSecondId(String secondId) {
        this.secondId = secondId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeviceUuid() {
        return deviceUuid;
    }

    public void setDeviceUuid(String deviceUuid) {
        this.deviceUuid = deviceUuid;
    }

    public Integer getAppId() {
        return appId;
    }

    public void setAppId(Integer appId) {
        this.appId = appId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "UnionDevice{" +
        ", id=" + id +
        ", secondId=" + secondId +
        ", name=" + name +
        ", deviceUuid=" + deviceUuid +
        ", appId=" + appId +
        ", type=" + type +
        ", createTime=" + createTime +
        ", userId=" + userId +
        "}";
    }
}
