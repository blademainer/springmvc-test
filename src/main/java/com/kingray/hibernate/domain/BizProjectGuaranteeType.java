package com.kingray.hibernate.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 担保类型
 * Created by blademainer<a href="http://xiongyingqi.com">xiongyingqi.com</a> on 2014/11/12 0012.
 */
@Entity
public class BizProjectGuaranteeType extends BaseDomain {
    /**
     * 无担保
     */
    public static final BizProjectGuaranteeType NO_GUARANTEE = new BizProjectGuaranteeType();
    /**
     * 平台担保
     */
    public static final BizProjectGuaranteeType PLATFORM_GUARANTEE = new BizProjectGuaranteeType();
    /**
     * 第三方担保
     */
    public static final BizProjectGuaranteeType THIRD_PARTY_GUARANTEE = new BizProjectGuaranteeType();

    static {
        NO_GUARANTEE.setTypeId(1);
        NO_GUARANTEE.setTypeCode("NO_GUARANTEE");
        NO_GUARANTEE.setTypeName("无担保");
        PLATFORM_GUARANTEE.setTypeId(2);
        PLATFORM_GUARANTEE.setTypeCode("PLATFORM_GUARANTEE");
        PLATFORM_GUARANTEE.setTypeName("平台担保");
        THIRD_PARTY_GUARANTEE.setTypeId(3);
        THIRD_PARTY_GUARANTEE.setTypeCode("THIRD_PARTY_GUARANTEE");
        THIRD_PARTY_GUARANTEE.setTypeName("第三方担保");


        String[] checkFields = {"typeId", "typeCode", "typeName"};
        checkAndInitDomain(NO_GUARANTEE, checkFields);
        checkAndInitDomain(PLATFORM_GUARANTEE, checkFields);
        checkAndInitDomain(THIRD_PARTY_GUARANTEE, checkFields);
    }


    private Integer typeId;
    private String typeCode;
    private String typeName;

    @Id
    @GeneratedValue
    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
