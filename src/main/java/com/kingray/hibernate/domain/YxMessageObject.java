package com.kingray.hibernate.domain;

import org.hibernate.annotations.Index;

import javax.persistence.*;

/**
 * <br>
 * Created by 瑛琪<a href="http://xiongyingqi.com">xiongyingqi.com</a> on 2014/6/12 0012.
 */
@Entity
@Table(name = "YX_MESSAGE_OBJECT")
public class YxMessageObject {
    private Integer objectId;
    private String objectName;
    private String objectValue;
    private YxMessage yxMessageByMessageId;

    @Id
    @GeneratedValue
    @Column(name = "OBJECT_ID")
    public Integer getObjectId() {
        return objectId;
    }

    public void setObjectId(Integer objectId) {
        this.objectId = objectId;
    }

    @Basic
    @Column(name = "OBJECT_NAME")
    @Index(name = "objectNameIndex", columnNames = {"OBJECT_NAME"})
    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    @Basic
    @Column(name = "OBJECT_VALUE")
    public String getObjectValue() {
        return objectValue;
    }

    public void setObjectValue(String objectValue) {
        this.objectValue = objectValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        YxMessageObject that = (YxMessageObject) o;

        if (objectId != null ? !objectId.equals(that.objectId) : that.objectId != null) return false;
        if (objectName != null ? !objectName.equals(that.objectName) : that.objectName != null) return false;
        if (objectValue != null ? !objectValue.equals(that.objectValue) : that.objectValue != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = objectId != null ? objectId.hashCode() : 0;
        result = 31 * result + (objectName != null ? objectName.hashCode() : 0);
        result = 31 * result + (objectValue != null ? objectValue.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "MESSAGE_ID", referencedColumnName = "MESSAGE_ID")
    public YxMessage getYxMessageByMessageId() {
        return yxMessageByMessageId;
    }

    public void setYxMessageByMessageId(YxMessage yxMessageByMessageId) {
        this.yxMessageByMessageId = yxMessageByMessageId;
    }
}
