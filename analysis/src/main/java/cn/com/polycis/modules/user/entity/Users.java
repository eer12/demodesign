package cn.com.polycis.modules.user.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author ${author}
 * @since 2018-11-29
 */
@TableName("lo_users")
public class Users  implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户数据标识，唯一id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 用户名字
     */
    private String name;


    private String loginname;
    /**
     * 用户密码
     */
    private String password;
    /**
     * 用户数据请求token
     */
    private String token;
    /**
     * 用户类型1.用户2，管理员
     */
    private Integer type;
    /**
     * 用户状态
     */
    private String status;
    /**
     * 邮箱
     */
    private String mail;
    /**
     * 电话
     */
    private String moblie;
    /**
     * 角色
     */
    private String role;
    /**
     * nb网络标识
     */
    private Integer nbNetworkId;
    /**
     * lora网络账户标识
     */
    private Integer loraNetworkId;
    /**
     * 2G网络标识
     */
    private Integer twogNetworkId;
    /**
     * 组织标识
     */
    private Integer org;
    /**
     * 父组织标识
     */
    private Integer orgParentId;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 创建
     */
    private Date createTime;
    /**
     * 是否删除
     */
    private Integer isDelete;


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

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMoblie() {
        return moblie;
    }

    public void setMoblie(String moblie) {
        this.moblie = moblie;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getNbNetworkId() {
        return nbNetworkId;
    }

    public void setNbNetworkId(Integer nbNetworkId) {
        this.nbNetworkId = nbNetworkId;
    }

    public Integer getLoraNetworkId() {
        return loraNetworkId;
    }

    public void setLoraNetworkId(Integer loraNetworkId) {
        this.loraNetworkId = loraNetworkId;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getTwogNetworkId() {
        return twogNetworkId;
    }

    public void setTwogNetworkId(Integer twogNetworkId) {
        this.twogNetworkId = twogNetworkId;
    }

    public Integer getOrg() {
        return org;
    }

    public void setOrg(Integer org) {
        this.org = org;
    }

    public Integer getOrgParentId() {
        return orgParentId;
    }

    public void setOrgParentId(Integer orgParentId) {
        this.orgParentId = orgParentId;
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
        return "Users{" +
        ", id=" + id +
        ", name=" + name +
        ", loginname=" + loginname +
        ", password=" + password +
        ", token=" + token +
        ", type=" + type +
        ", status=" + status +
        ", mail=" + mail +
        ", moblie=" + moblie +
        ", role=" + role +
        ", nbNetworkId=" + nbNetworkId +
        ", loraNetworkId=" + loraNetworkId +
        ", 2gNetworkId=" + twogNetworkId +
        ", org=" + org +
        ", orgParentId=" + orgParentId +
        ", updateTime=" + updateTime +
        ", createTime=" + createTime +
        ", isDelete=" + isDelete +
        "}";
    }
}
