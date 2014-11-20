package com.kingray.hibernate.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by 瑛琪<a href="http://xiongyingqi.com">xiongyingqi.com</a> on 2014/8/6 0006.
 */
@Entity
public class EmailAccount extends BaseDomain {
    private Integer accountId;
    //email.protocol=smtps
    private String accountProtocol;
    private String accountHost;
    private int accountPort;
    private String accountFrom;
    private String accountUserName;
    private String accountPassword;
    private String nickName;
    private boolean isAuth;
    //默认发件人
    private String systemEmail;
    //默认抄送人
    private String cc;
    //默认密送人
    private String bcc;

    @Id
    @GeneratedValue
    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getAccountProtocol() {
        return accountProtocol;
    }

    public void setAccountProtocol(String protocol) {
        this.accountProtocol = protocol;
    }

    public String getAccountHost() {
        return accountHost;
    }

    public void setAccountHost(String host) {
        this.accountHost = host;
    }

    public int getAccountPort() {
        return accountPort;
    }

    public void setAccountPort(int port) {
        this.accountPort = port;
    }

    public String getAccountUserName() {
        return accountUserName;
    }

    public void setAccountUserName(String username) {
        this.accountUserName = username;
    }

    public String getAccountPassword() {
        return accountPassword;
    }

    public void setAccountPassword(String password) {
        this.accountPassword = password;
    }

    public boolean isIsAuth() {
        return isAuth;
    }

    public void setIsAuth(boolean auth) {
        this.isAuth = auth;
    }

    public String getSystemEmail() {
        return systemEmail;
    }

    public void setSystemEmail(String systemEmail) {
        this.systemEmail = systemEmail;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getBcc() {
        return bcc;
    }

    public void setBcc(String bcc) {
        this.bcc = bcc;
    }

    public String getAccountFrom() {
        return accountFrom;
    }

    public void setAccountFrom(String from) {
        this.accountFrom = from;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
