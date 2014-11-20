package com.kingray.hibernate.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

/**
 * 项目
 * Created by blademainer<a href="http://xiongyingqi.com">xiongyingqi.com</a> on 2014/10/30 0030.
 */
@Entity
public class BizProject extends BaseDomain {
    private Integer projectId;
    /**
     * 项目名
     */
    private String projectName;
    /**
     * 项目年收益率
     */
    private Double interestRateOfYear;

    /**
     * 项目创建时间
     */
    private Date produceDate;

    /**
     * 项目开始投标时间
     */
    private Date availableDate;

    /**
     * 投标最后时间
     */
    private Date deadlineDate;

    /**
     * 项目生效时间
     */
    private Date startDate;

    /**
     * 到期时间（回款时间）
     */
    private Date endDate;

    /**
     * 项目期限描述（根据到期时间与项目生效时间计算出来的描述性文本），如：10天，三个月，一年等
     */
    private String periodDescribe;

    /**
     * 总金额
     */
    private Double totalAmount;
    /**
     * 项目简介（存储字段）
     */
    @JsonIgnore
    private YxTextStore projectIntroduction;
    /**
     * 项目简介
     */
    private String projectIntroductionText;
    /**
     * 已投资金额
     */
    private Double investmentAmount;

    /**
     * 项目状态
     */
    private BizProjectStatus projectStatus;

    /**
     * 还款方式
     */
    private BizProjectRepaymentMode repaymentMode;

    /**
     * 是否平台担保
     */
    private BizProjectGuaranteeType guaranteeType;

    @Id
    @GeneratedValue
    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Double getInterestRateOfYear() {
        return interestRateOfYear;
    }

    public void setInterestRateOfYear(Double interestRateOfYear) {
        this.interestRateOfYear = interestRateOfYear;
    }

    public Date getProduceDate() {
        return produceDate;
    }

    public void setProduceDate(Date produceDate) {
        this.produceDate = produceDate;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Double getInvestmentAmount() {
        return investmentAmount;
    }

    public void setInvestmentAmount(Double investmentAmount) {
        this.investmentAmount = investmentAmount;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @ManyToOne
    public YxTextStore getProjectIntroduction() {
        return projectIntroduction;
    }

    public void setProjectIntroduction(YxTextStore projectIntroduction) {
        this.projectIntroduction = projectIntroduction;
    }

    public Date getDeadlineDate() {
        return deadlineDate;
    }

    public void setDeadlineDate(Date deadlineDate) {
        this.deadlineDate = deadlineDate;
    }

    @ManyToOne
    public BizProjectStatus getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(BizProjectStatus projectStatus) {
        this.projectStatus = projectStatus;
    }

    @ManyToOne
    public BizProjectRepaymentMode getRepaymentMode() {
        return repaymentMode;
    }

    public void setRepaymentMode(BizProjectRepaymentMode repaymentMode) {
        this.repaymentMode = repaymentMode;
    }

    @ManyToOne
    public BizProjectGuaranteeType getGuaranteeType() {
        return guaranteeType;
    }

    public void setGuaranteeType(BizProjectGuaranteeType guaranteeType) {
        this.guaranteeType = guaranteeType;
    }

    public Date getAvailableDate() {
        return availableDate;
    }

    public void setAvailableDate(Date availableDate) {
        this.availableDate = availableDate;
    }

    @Transient
    public String getProjectIntroductionText() {
        return projectIntroductionText;
    }

    public void setProjectIntroductionText(String projectIntroductionText) {
        this.projectIntroductionText = projectIntroductionText;
    }

    public String getPeriodDescribe() {
        return periodDescribe;
    }

    public void setPeriodDescribe(String periodDescribe) {
        this.periodDescribe = periodDescribe;
    }
}
