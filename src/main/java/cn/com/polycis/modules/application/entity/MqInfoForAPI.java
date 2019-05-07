package cn.com.polycis.modules.application.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * mq信息表
 * </p>
 *
 * @author ${author}
 * @since 2018-12-03
 */
@TableName("lo_mq_info")
public class MqInfoForAPI implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自增id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 名称
     */
    private String name;

    /**
     * 队列名
     */
    private String queue;

    /**
     * mq地址
     */
    private String host;

    /**
     * ip端口号
     */
    private Integer port;


    /**
     * 用户名
     */
    private String login;
    /**
     * 密码
     */
    private String password;

    private Integer type;

    /**
     * 启动标识(0未启动,1启动)
     */
    private Integer status;
    /**
     * 创建时间
     */
    private Date createTime;


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

    public String getQueue() {
        return queue;
    }

    public void setQueue(String queue) {
        this.queue = queue;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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

    @Override
    public String toString() {
        return "MqInfoForAPI{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", queue='" + queue + '\'' +
                ", host='" + host + '\'' +
                ", port=" + port +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", type=" + type +
                ", status=" + status +
                ", createTime=" + createTime +
                '}';
    }
}
