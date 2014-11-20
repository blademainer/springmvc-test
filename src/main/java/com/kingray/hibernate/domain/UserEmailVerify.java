package com.kingray.hibernate.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.sql.Timestamp;

/**
 * Created by 瑛琪<a href="http://xiongyingqi.com">xiongyingqi.com</a> on 2014/4/28 0028.
 */
@Entity
public class UserEmailVerify extends BaseDomain {
    private Long verifyId;
    private Timestamp verifyTime;
    private Timestamp verifyEndTime;
    private String verifyPrivateKey;
    private String verifyPublicKey;
    private PUser userByUserId;

    @Id
    @GeneratedValue
    public Long getVerifyId() {
        return verifyId;
    }

    public void setVerifyId(Long verifyId) {
        this.verifyId = verifyId;
    }

    public Timestamp getVerifyTime() {
        return verifyTime;
    }

    public void setVerifyTime(Timestamp verifyTime) {
        this.verifyTime = verifyTime;
    }

    public Timestamp getVerifyEndTime() {
        return verifyEndTime;
    }

    public void setVerifyEndTime(Timestamp verifyEndTime) {
        this.verifyEndTime = verifyEndTime;
    }

    public String getVerifyPrivateKey() {
        return verifyPrivateKey;
    }

    public void setVerifyPrivateKey(String verifyPrivateKey) {
        this.verifyPrivateKey = verifyPrivateKey;
    }

    public String getVerifyPublicKey() {
        return verifyPublicKey;
    }

    public void setVerifyPublicKey(String verifyPublicKey) {
        this.verifyPublicKey = verifyPublicKey;
    }

    @ManyToOne
    public PUser getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(PUser userByUserId) {
        this.userByUserId = userByUserId;
    }
}
