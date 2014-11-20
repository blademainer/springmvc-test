package com.kingray.hibernate.domain;

import javax.persistence.*;
import java.util.Collection;

/**
 * <br>
 * Created by 瑛琪<a href="http://xiongyingqi.com">xiongyingqi.com</a> on 2014/6/12 0012.
 */
@Entity
@Table(name = "YX_MESSAGE_TYPE")
public class YxMessageType extends BaseDomain {
    public static final YxMessageType USER_MESSAGE = new YxMessageType();
    public static final YxMessageType FRIEND_REQUEST = new YxMessageType();

    static {
        String[] checkFields = {"typeId", "typeCode", "typeName"};

        USER_MESSAGE.setTypeId(2);
        USER_MESSAGE.setYxMessageMainTypeByMainTypeId(YxMessageMainType.USER_MESSAGE);
        USER_MESSAGE.setTypeCode("USER_MESSAGE");
        USER_MESSAGE.setTypeName("用户消息");

        checkAndInitDomain(USER_MESSAGE, checkFields);

        FRIEND_REQUEST.setTypeId(1);
        FRIEND_REQUEST.setYxMessageMainTypeByMainTypeId(YxMessageMainType.SYSTEM_MESSAGE);
        FRIEND_REQUEST.setTypeCode("FRIEND_REQUEST");
        FRIEND_REQUEST.setTypeName("好友请求");
        checkAndInitDomain(FRIEND_REQUEST, checkFields);
    }

    private Integer typeId;
    private String typeCode;
    private String typeName;
    private Collection<YxMessage> yxMessagesByTypeId;
    private YxMessageMainType yxMessageMainTypeByMainTypeId;

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
    @Column(name = "TYPE_NAME")
    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Basic
    @Column(name = "TYPE_CODE")
    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        YxMessageType that = (YxMessageType) o;

        if (typeCode != null ? !typeCode.equals(that.typeCode) : that.typeCode != null) return false;
        if (typeId != null ? !typeId.equals(that.typeId) : that.typeId != null) return false;
        if (typeName != null ? !typeName.equals(that.typeName) : that.typeName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = typeId != null ? typeId.hashCode() : 0;
        result = 31 * result + (typeName != null ? typeName.hashCode() : 0);
        result = 31 * result + (typeCode != null ? typeCode.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "yxMessageTypeByTypeId")
    public Collection<YxMessage> getYxMessagesByTypeId() {
        return yxMessagesByTypeId;
    }

    public void setYxMessagesByTypeId(Collection<YxMessage> yxMessagesByTypeId) {
        this.yxMessagesByTypeId = yxMessagesByTypeId;
    }

    @ManyToOne
    @JoinColumn(name = "MAIN_TYPE_ID", referencedColumnName = "TYPE_ID")
    public YxMessageMainType getYxMessageMainTypeByMainTypeId() {
        return yxMessageMainTypeByMainTypeId;
    }

    public void setYxMessageMainTypeByMainTypeId(YxMessageMainType yxMessageMainTypeByMainTypeId) {
        this.yxMessageMainTypeByMainTypeId = yxMessageMainTypeByMainTypeId;
    }
}
