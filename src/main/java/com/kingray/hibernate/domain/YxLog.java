package com.kingray.hibernate.domain;


import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by 瑛琪<a href="http://xiongyingqi.com">xiongyingqi.com</a> on 2014/6/10 0010.
 */
@Entity
@Table(name = "YX_LOG")
public class YxLog extends BaseDomain {
    private Integer logId;
    private Timestamp logDateTime;
    private Integer logLevelId;
    private String methodFrom;
    private String methodTarget;
    private String invokeMethod;
    private Integer logTypeId;
    private Long invokeMethodTextId;
    private Long methodReturnTextId;
    private Integer invokeTime;
    //    private Integer loggedByUserId;
    private PUser user;
    private String ip;

    @Id
    @GeneratedValue
    @Column(name = "LOG_ID")
    public Integer getLogId() {
        return logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    @Basic
    @Column(name = "LOG_DATE_TIME")
    public Timestamp getLogDateTime() {
        return logDateTime;
    }

    public void setLogDateTime(Timestamp logDateTime) {
        this.logDateTime = logDateTime;
    }

    @Basic
    @Column(name = "LOG_LEVEL_ID")
    public Integer getLogLevelId() {
        return logLevelId;
    }

    public void setLogLevelId(Integer logLevelId) {
        this.logLevelId = logLevelId;
    }

    @Basic
    @Column(name = "METHOD_FROM")
    public String getMethodFrom() {
        return methodFrom;
    }

    public void setMethodFrom(String methodFrom) {
        this.methodFrom = methodFrom;
    }

    @Basic
    @Column(name = "METHOD_TARGET")
    public String getMethodTarget() {
        return methodTarget;
    }

    public void setMethodTarget(String methodTarget) {
        this.methodTarget = methodTarget;
    }

    @Basic
    @Column(name = "INVOKE_METHOD")
    public String getInvokeMethod() {
        return invokeMethod;
    }

    public void setInvokeMethod(String invokeMethod) {
        this.invokeMethod = invokeMethod;
    }

    @Basic
    @Column(name = "LOG_TYPE_ID")
    public Integer getLogTypeId() {
        return logTypeId;
    }

    public void setLogTypeId(Integer logTypeId) {
        this.logTypeId = logTypeId;
    }

    @Basic
    @Column(name = "INVOKE_METHOD_TEXT_ID")
    public Long getInvokeMethodTextId() {
        return invokeMethodTextId;
    }

    public void setInvokeMethodTextId(Long invokeMethodTextId) {
        this.invokeMethodTextId = invokeMethodTextId;
    }

    @Basic
    @Column(name = "METHOD_RETURN_TEXT_ID")
    public Long getMethodReturnTextId() {
        return methodReturnTextId;
    }

    public void setMethodReturnTextId(Long methodReturnTextId) {
        this.methodReturnTextId = methodReturnTextId;
    }

    @Basic
    @Column(name = "INVOKE_TIME")
    public Integer getInvokeTime() {
        return invokeTime;
    }

    public void setInvokeTime(Integer invokeTime) {
        this.invokeTime = invokeTime;
    }

    @Basic
    @Column(name = "IP")
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @ManyToOne
    public PUser getUser() {
        return user;
    }

    public void setUser(PUser user) {
        this.user = user;
    }

    //    @Basic
//    @Column(name = "LOGGED_BY_USER_ID")
//    public Integer getLoggedByUserId() {
//        return loggedByUserId;
//    }
//
//    public void setLoggedByUserId(Integer loggedByUserId) {
//        this.loggedByUserId = loggedByUserId;
//    }

}
