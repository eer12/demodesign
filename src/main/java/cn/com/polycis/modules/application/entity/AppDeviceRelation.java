package cn.com.polycis.modules.application.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 应用与设备中间表
 * </p>
 *
 * @author ${author}
 * @since 2018-12-05
 */
@TableName("lo_app_device_relation")
public class AppDeviceRelation implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自增id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 应用标识
     */
    private Integer appId;
    /**
     * 设备标识
     */
    private Integer deviceId;
    private Date createTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAppId() {
        return appId;
    }

    public void setAppId(Integer appId) {
        this.appId = appId;
    }

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "AppDeviceRelation{" +
        ", id=" + id +
        ", appId=" + appId +
        ", deviceId=" + deviceId +
        ", createTime=" + createTime +
        "}";
    }
}
