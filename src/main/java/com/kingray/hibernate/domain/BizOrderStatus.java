package com.kingray.hibernate.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by qi on 2014/11/14 0014.
 */
@Entity
public class BizOrderStatus extends BaseDomain {

    /**
     * 支付成功
     */
    public static final BizOrderStatus SUCCESS = new BizOrderStatus();
    public static final BizOrderStatus READY = new BizOrderStatus();
    public static final BizOrderStatus EXPIRE = new BizOrderStatus();
    public static final BizOrderStatus FAIL = new BizOrderStatus();

    static {
        SUCCESS.setStatusId(1);
        SUCCESS.setStatusCode("SUCCESS");
        SUCCESS.setStatusName("支付成功");

        READY.setStatusId(2);
        READY.setStatusCode("READY");
        READY.setStatusName("待支付");

        EXPIRE.setStatusId(3);
        EXPIRE.setStatusCode("EXPIRE");
        EXPIRE.setStatusName("过期");

        FAIL.setStatusId(4);
        FAIL.setStatusCode("FAIL");
        FAIL.setStatusName("支付失败");

        String[] checkFields = {"statusId", "statusCode", "statusName"};
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
