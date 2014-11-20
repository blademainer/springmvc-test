package com.kingray.hibernate.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * 用户投资账号
 * Created by blademainer<a href="http://xiongyingqi.com">xiongyingqi.com</a> on 2014/11/3 0003.
 */
@Entity
public class BizUserAccount extends BaseDomain {
    private Integer accountId;
    private PUser user;
    /**
     * 总投入金额
     */
    private Double totalInterestAmount = 0.0;
    /**
     * 总收益
     */
    private Double totalRevenue = 0.0;
    /**
     * 总收益加权收益率
     */
    private Double totalYield = 0.0;
    /**
     * 冻结金额
     */
    private Double freezeAmount = 0.0;
    /**
     * 待收金额
     */
    private Double dueInAmount = 0.0;
    /**
     * 账户可用余额
     */
    private Double availableBalance = 0.0;

    @Id
    @GeneratedValue
    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    @OneToOne
    public PUser getUser() {
        return user;
    }

    public void setUser(PUser user) {
        this.user = user;
    }

    /**
     * 总投入金额
     */
    public Double getTotalInterestAmount() {
        return totalInterestAmount;
    }

    /**
     * 总投入金额
     */
    public void setTotalInterestAmount(Double totalInterestAmount) {
        this.totalInterestAmount = totalInterestAmount;
    }

    /**
     * 总收益
     */
    public Double getTotalRevenue() {
        return totalRevenue;
    }

    /**
     * 总收益
     */
    public void setTotalRevenue(Double totalRevenue) {
        this.totalRevenue = totalRevenue;
    }

    /**
     * 总收益加权收益率
     */
    public Double getTotalYield() {
        return totalYield;
    }

    /**
     * 总收益加权收益率
     */
    public void setTotalYield(Double totalYield) {
        this.totalYield = totalYield;
    }

    /**
     * 冻结金额
     */
    public Double getFreezeAmount() {
        return freezeAmount;
    }

    /**
     * 冻结金额
     */
    public void setFreezeAmount(Double freezeAmount) {
        this.freezeAmount = freezeAmount;
    }

    /**
     * 待收金额
     */
    public Double getDueInAmount() {
        return dueInAmount;
    }

    /**
     * 待收金额
     */
    public void setDueInAmount(Double dueInAmount) {
        this.dueInAmount = dueInAmount;
    }

    /**
     * 账户可用余额
     */
    public Double getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(Double availableBalance) {
        this.availableBalance = availableBalance;
    }
}
