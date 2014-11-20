package com.kingray.hibernate.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 结算记录
 * Created by blademainer<a href="http://xiongyingqi.com">xiongyingqi.com</a> on 2014/11/19 0019.
 */
@Entity
public class BizSettlementRecord extends BaseDomain {
    private Integer recordId;

    @Id
    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }
}
