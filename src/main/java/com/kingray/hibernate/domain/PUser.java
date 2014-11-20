package com.kingray.hibernate.domain;


import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.sql.Date;

/**
 * Created by 瑛琪<a href="http://xiongyingqi.com">xiongyingqi.com</a> on 2014/6/10 0010.
 */
@Entity
@Table(name = "P_USER")
public class PUser extends BaseDomain {
    private Integer userId;
    @NotEmpty(message = "用户名不能为空")
    @Size(min = 3, max = 80, message = "用户名必须大于3位且必须小于三位")
    @Pattern(regexp = "^[a-zA-Z]\\w{2,}", message = "用户名必须以字母开头，并且必须大于3个字符")
    private String userName;
    @NotEmpty(message = "密码不能为空")
    @Size(min = 3, message = "密码必须大于3位")
    private String userPassword;
    private String realName;
    private String nickName;
    private Date birthday;
    private java.util.Date registerDate;
    private Short age;
    @Pattern(regexp = "\\d{11}", message = "手机号码不符合")
    private String mobile;
    /**
     * 手机是否验证
     */
    private boolean mobileChecked;
    private Short level;
    @Pattern(regexp = "([\\w\\.\\-]+@\\w+(\\.\\w+)+)|()", message = "邮箱格式错误")
    private String email;
    /**
     * 身份证
     */
    private String identityCard;
    /**
     * 银行卡
     */
    private String bankCard;

    /**
     * 用户状态标志
     */
    private YxStatusFlag statusFlag;

    @Id
    @GeneratedValue
    @Column(name = "USER_ID")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "USER_NAME", unique = true)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "USER_PASSWORD")
    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Basic
    @Column(name = "REAL_NAME")
    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }


    @Basic
    @Column(name = "NICK_NAME")
    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Basic
    @Column(name = "BIRTHDAY")
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Basic
    @Column(name = "AGE")
    public Short getAge() {
        return age;
    }

    public void setAge(Short age) {
        this.age = age;
    }

    @Basic
    @Column(name = "MOBILE", unique = true)
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Basic
    @Column(name = "LEVEL")
    public Short getLevel() {
        return level;
    }

    public void setLevel(Short level) {
        this.level = level;
    }

    @Basic
    @Column(name = "EMAIL", unique = true)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Basic
    @Column(name = "IDENTITY_CARD", unique = true)
    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    @Basic
    @Column(name = "BANK_CARD")
    public String getBankCard() {
        return bankCard;
    }

    public void setBankCard(String bankCard) {
        this.bankCard = bankCard;
    }

    public java.util.Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(java.util.Date registerDate) {
        this.registerDate = registerDate;
    }

    public boolean isMobileChecked() {
        return mobileChecked;
    }

    public void setMobileChecked(boolean isMobileChecked) {
        this.mobileChecked = isMobileChecked;
    }

    @ManyToOne
    public YxStatusFlag getStatusFlag() {
        return statusFlag;
    }

    public void setStatusFlag(YxStatusFlag statusFlag) {
        this.statusFlag = statusFlag;
    }
}