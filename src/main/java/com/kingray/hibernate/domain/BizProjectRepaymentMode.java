package com.kingray.hibernate.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 项目还款方式
 * Created by blademainer<a href="http://xiongyingqi.com">xiongyingqi.com</a> on 2014/11/7 0007.
 */
@Entity
public class BizProjectRepaymentMode extends BaseDomain {
    /**
     * 一次性还款
     */
    public static final BizProjectRepaymentMode ONE_TIME_PAYMENT = new BizProjectRepaymentMode();
    /**
     * 等额本金
     */
    public static final BizProjectRepaymentMode AVERAGE_CAPITAL = new BizProjectRepaymentMode();
    /**
     * 等额本息
     */
    public static final BizProjectRepaymentMode AVERAGE_CAPITAL_PLUS_INTEREST = new BizProjectRepaymentMode();

    static {
        ONE_TIME_PAYMENT.setModeId(1);
        ONE_TIME_PAYMENT.setModeCode("ONE_TIME_PAYMENT");
        ONE_TIME_PAYMENT.setModeName("一次性还款");
        AVERAGE_CAPITAL.setModeId(2);
        AVERAGE_CAPITAL.setModeCode("AVERAGE_CAPITAL");
        AVERAGE_CAPITAL.setModeName("等额本金");
        AVERAGE_CAPITAL_PLUS_INTEREST.setModeId(3);
        AVERAGE_CAPITAL_PLUS_INTEREST.setModeCode("AVERAGE_CAPITAL_PLUS_INTEREST");
        AVERAGE_CAPITAL_PLUS_INTEREST.setModeName("等额本息");


        String[] checkFields = {"modeId", "modeCode", "modeName"};
        checkAndInitDomain(ONE_TIME_PAYMENT, checkFields);
        checkAndInitDomain(AVERAGE_CAPITAL, checkFields);
        checkAndInitDomain(AVERAGE_CAPITAL_PLUS_INTEREST, checkFields);
    }


    private Integer modeId;
    private String modeCode;
    private String modeName;

    @Id
    @GeneratedValue
    public Integer getModeId() {
        return modeId;
    }

    public void setModeId(Integer modeId) {
        this.modeId = modeId;
    }

    public String getModeCode() {
        return modeCode;
    }

    public void setModeCode(String modeCode) {
        this.modeCode = modeCode;
    }

    public String getModeName() {
        return modeName;
    }

    public void setModeName(String modeName) {
        this.modeName = modeName;
    }
}
