package com.kingray.hibernate.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by 瑛琪<a href="http://xiongyingqi.com">xiongyingqi.com</a> on 2014/8/4 0004.
 */
@Entity
public class YxStatusFlag extends BaseDomain {
    public static final YxStatusFlag ENABLE = new YxStatusFlag();
    public static final YxStatusFlag DISABLE = new YxStatusFlag();
    public static final YxStatusFlag DELETE = new YxStatusFlag();

    static {
        ENABLE.setStatusId(1);
        ENABLE.setStatusCode("ENABLE");
        ENABLE.setStatusName("可用");
        checkAndInitDomain(ENABLE, "statusId", "statusName");

        DISABLE.setStatusId(2);
        DISABLE.setStatusCode("DISABLE");
        DISABLE.setStatusName("禁用");
        checkAndInitDomain(DISABLE, "statusId", "statusName");

        DELETE.setStatusId(3);
        DELETE.setStatusCode("DELETE");
        DELETE.setStatusName("已删除");
        checkAndInitDomain(DELETE, "statusId", "statusName");


    }


    private int statusId;
    private String statusCode;
    private String statusName;

    @Id
    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
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
