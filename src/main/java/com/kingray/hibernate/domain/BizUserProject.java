package com.kingray.hibernate.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

/**
 * 用户所投资的项目
 * Created by blademainer<a href="http://xiongyingqi.com">xiongyingqi.com</a> on 2014/10/30 0030.
 */
@Entity
public class BizUserProject extends BaseDomain {
    private Integer userProjectId;
    private PUser user;
    private BizProject project;
    /**
     * 投入金额
     */
    private Double investmentAmount;
    /**
     * 投资日期
     */
    private Date investmentDate;
    /**
     * 收益
     */
    private Double interest;
    /**
     * 收益率
     */
    private Double interestRate;


    @Id
    @GeneratedValue
    public Integer getUserProjectId() {
        return userProjectId;
    }

    public void setUserProjectId(Integer userProjectId) {
        this.userProjectId = userProjectId;
    }

    @ManyToOne
    public PUser getUser() {
        return user;
    }

    public void setUser(PUser user) {
        this.user = user;
    }

    @ManyToOne
    public BizProject getProject() {
        return project;
    }

    public void setProject(BizProject project) {
        this.project = project;
    }

    public Double getInvestmentAmount() {
        return investmentAmount;
    }

    public void setInvestmentAmount(Double investmentAmount) {
        this.investmentAmount = investmentAmount;
    }

    public Date getInvestmentDate() {
        return investmentDate;
    }

    public void setInvestmentDate(Date investmentDate) {
        this.investmentDate = investmentDate;
    }

    public Double getInterest() {
        return interest;
    }

    public void setInterest(Double interest) {
        this.interest = interest;
    }

    public Double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }

}
