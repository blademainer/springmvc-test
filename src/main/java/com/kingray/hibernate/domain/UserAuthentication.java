package com.kingray.hibernate.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created by 瑛琪<a href="http://xiongyingqi.com">xiongyingqi.com</a> on 2014/4/28 0028.
 */
@Entity
public class UserAuthentication extends BaseDomain {
    private Integer authenticationId;
    private Byte isEmailVerify;
    private Byte isPhoneVerify;
    private String verifyQuestionOne;
    private String verifyQuestionOneAnswer;
    private String verifyQuestionTwo;
    private String verifyQuestionTwoAnswer;
    private String verifyQuestionThree;
    private String verifyQuestionThreeAnswer;
    private PUser userByUserId;

    @Id
    @GeneratedValue
    public Integer getAuthenticationId() {
        return authenticationId;
    }

    public void setAuthenticationId(Integer authenticationId) {
        this.authenticationId = authenticationId;
    }

    public Byte getIsEmailVerify() {
        return isEmailVerify;
    }

    public void setIsEmailVerify(Byte isEmailVerify) {
        this.isEmailVerify = isEmailVerify;
    }

    public Byte getIsPhoneVerify() {
        return isPhoneVerify;
    }

    public void setIsPhoneVerify(Byte isPhoneVerify) {
        this.isPhoneVerify = isPhoneVerify;
    }

    public String getVerifyQuestionOne() {
        return verifyQuestionOne;
    }

    public void setVerifyQuestionOne(String verifyQuestionOne) {
        this.verifyQuestionOne = verifyQuestionOne;
    }

    public String getVerifyQuestionOneAnswer() {
        return verifyQuestionOneAnswer;
    }

    public void setVerifyQuestionOneAnswer(String verifyQuestionOneAnswer) {
        this.verifyQuestionOneAnswer = verifyQuestionOneAnswer;
    }

    public String getVerifyQuestionTwo() {
        return verifyQuestionTwo;
    }

    public void setVerifyQuestionTwo(String verifyQuestionTwo) {
        this.verifyQuestionTwo = verifyQuestionTwo;
    }

    public String getVerifyQuestionTwoAnswer() {
        return verifyQuestionTwoAnswer;
    }

    public void setVerifyQuestionTwoAnswer(String verifyQuestionTwoAnswer) {
        this.verifyQuestionTwoAnswer = verifyQuestionTwoAnswer;
    }

    public String getVerifyQuestionThree() {
        return verifyQuestionThree;
    }

    public void setVerifyQuestionThree(String verifyQuestionThree) {
        this.verifyQuestionThree = verifyQuestionThree;
    }

    public String getVerifyQuestionThreeAnswer() {
        return verifyQuestionThreeAnswer;
    }

    public void setVerifyQuestionThreeAnswer(String verifyQuestionThreeAnswer) {
        this.verifyQuestionThreeAnswer = verifyQuestionThreeAnswer;
    }

    @ManyToOne
    public PUser getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(PUser userByUserId) {
        this.userByUserId = userByUserId;
    }
}
