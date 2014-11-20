package com.kingray.hibernate.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 项目状态
 * Created by blademainer<a href="http://xiongyingqi.com">xiongyingqi.com</a> on 2014/10/31 0031.
 */
@Entity
public class BizProjectStatus extends BaseDomain {
    /**
     * 准备中
     */
    public static final BizProjectStatus READY = new BizProjectStatus();
    /**
     * 可投
     */
    public static final BizProjectStatus AVAILABLE = new BizProjectStatus();
    /**
     * 满标
     */
    public static final BizProjectStatus FULL = new BizProjectStatus();
    /**
     * 流标
     */
    public static final BizProjectStatus DISABLE = new BizProjectStatus();
    /**
     * 还款中
     */
    public static final BizProjectStatus REPAYMENT = new BizProjectStatus();
    /**
     * 完结
     */
    public static final BizProjectStatus SUCCESS = new BizProjectStatus();

    static {
        READY.setStatusId(-1);
        READY.setStatusCode("READY");
        READY.setStatusName("准备中");

        AVAILABLE.setStatusId(1);
        AVAILABLE.setStatusCode("AVAILABLE");
        AVAILABLE.setStatusName("可投");

        FULL.setStatusId(2);
        FULL.setStatusCode("FULL");
        FULL.setStatusName("满标");

        DISABLE.setStatusId(3);
        DISABLE.setStatusCode("DISABLE");
        DISABLE.setStatusName("流标");

        REPAYMENT.setStatusId(4);
        REPAYMENT.setStatusCode("REPAYMENT");
        REPAYMENT.setStatusName("还款中");

        SUCCESS.setStatusId(5);
        SUCCESS.setStatusCode("SUCCESS");
        SUCCESS.setStatusName("完结");


        String[] checkFields = {"statusId", "statusCode", "statusName"};
        checkAndInitDomain(READY, checkFields);
        checkAndInitDomain(AVAILABLE, checkFields);
        checkAndInitDomain(FULL, checkFields);
        checkAndInitDomain(DISABLE, checkFields);
        checkAndInitDomain(REPAYMENT, checkFields);
        checkAndInitDomain(SUCCESS, checkFields);
    }

    private Integer statusId;
    private String statusCode;
    private String statusName;

    @Id
    @GeneratedValue
    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }
}
