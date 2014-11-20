package com.kingray.hibernate.domain;

import javax.persistence.*;

/**
 * <br>
 * Created by 瑛琪<a href="http://xiongyingqi.com">xiongyingqi.com</a> on 2014/6/12 0012.
 */
@Entity
@Table(name = "YX_MESSAGE_MAIN_TYPE")
public class YxMessageMainType extends BaseDomain {
    public static final YxMessageMainType SYSTEM_MESSAGE = new YxMessageMainType();
    public static final YxMessageMainType USER_MESSAGE = new YxMessageMainType();

    static {
        SYSTEM_MESSAGE.setTypeId(1);
        SYSTEM_MESSAGE.setTypeCode("SYSTEM_MESSAGE");
        SYSTEM_MESSAGE.setTypeName("系统消息");

        USER_MESSAGE.setTypeId(2);
        USER_MESSAGE.setTypeCode("USER_MESSAGE");
        USER_MESSAGE.setTypeName("用户消息");

        String[] checkFields = {"typeId", "typeCode", "typeName"};
        checkAndInitDomain(SYSTEM_MESSAGE, checkFields);
        checkAndInitDomain(USER_MESSAGE, checkFields);
    }


    private Integer typeId;
    private String typeCode;
    private String typeName;

    @Id
    @GeneratedValue
    @Column(name = "TYPE_ID")
    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    @Basic
    @Column(name = "TYPE_CODE")
    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    @Basic
    @Column(name = "TYPE_NAME")
    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        YxMessageMainType that = (YxMessageMainType) o;

        if (typeCode != null ? !typeCode.equals(that.typeCode) : that.typeCode != null) return false;
        if (typeId != null ? !typeId.equals(that.typeId) : that.typeId != null) return false;
        if (typeName != null ? !typeName.equals(that.typeName) : that.typeName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = typeId != null ? typeId.hashCode() : 0;
        result = 31 * result + (typeCode != null ? typeCode.hashCode() : 0);
        result = 31 * result + (typeName != null ? typeName.hashCode() : 0);
        return result;
    }
}
