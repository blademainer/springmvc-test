package com.kingray.hibernate.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by YAN on 2014/8/6.
 */
@Entity
public class TCustomer {
    private String userId;//用户编号，QQ方姓名
    private String userName;//用户姓名
    private String clientId;//QQ客户端编号
    private String origin;//来源方
    private String userNickName;//
    private Integer sex;
    private TCustomer tCustomer;

    @Id
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getUserNickName() {
        return userNickName;
    }

    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }




}
