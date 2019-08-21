package cn.com.polycis.modules.analysis.entity;

import java.util.Date;

public class AnalysisRule {
    private String name;
    private Integer id;
    private Integer appId;
    private String instruct;
    private Date createTime;
    private Integer  isDelete;

    private Integer type;

    private Integer pushWay;

    private Integer pushId;

    private String description;

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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getPushWay() {
        return pushWay;
    }

    public void setPushWay(Integer pushWay) {
        this.pushWay = pushWay;
    }

    public Integer getPushId() {
        return pushId;
    }

    public void setPushId(Integer pushId) {
        this.pushId = pushId;
    }

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

    public String getInstruct() {
        return instruct;
    }

    public void setInstruct(String instruct) {
        this.instruct = instruct;
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
        return "AnalysisRule{" +
                "name=" + name +
                ", id=" + id +
                ", appId=" + appId +
                ", instruct='" + instruct + '\'' +
                ", createTime=" + createTime +
                ", isDelete=" + isDelete +
                ", type=" + type +
                ", pushWay=" + pushWay +
                ", pushId=" + pushId +
                ", description='" + description + '\'' +
                '}';
    }
}
