package com.kingray.hibernate.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Index;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * <br>
 * Created by 瑛琪<a href="http://xiongyingqi.com">xiongyingqi.com</a> on 2014/6/12 0012.
 */
@Entity
@Table(name = "YX_MESSAGE")
public class YxMessage extends BaseDomain {
    private Integer messageId;
    private Integer sentUserId;
    private Integer receiveUserId;
    private Timestamp messageTime;
    private Boolean isRead;
    private YxMessageType yxMessageTypeByTypeId;
    @JsonIgnore
    private YxTextStore yxTextStoreByTextId;
    private String messageBody;
    private Collection<YxMessageObject> yxMessageObjectsByMessageId;

    @Id
    @GeneratedValue
    @Column(name = "MESSAGE_ID")
    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    @Basic
    @Column(name = "SENT_USER_ID")
    public Integer getSentUserId() {
        return sentUserId;
    }

    public void setSentUserId(Integer sentUserId) {
        this.sentUserId = sentUserId;
    }

    @Basic
    @Column(name = "RECEIVE_USER_ID")
    public Integer getReceiveUserId() {
        return receiveUserId;
    }

    public void setReceiveUserId(Integer receiveUserId) {
        this.receiveUserId = receiveUserId;
    }

    @Basic
    @Column(name = "MESSAGE_TIME")
    public Timestamp getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(Timestamp messageTime) {
        this.messageTime = messageTime;
    }

    @Basic
    @Column(name = "IS_READ")
    @Index(name = "isReadIndex", columnNames = {"IS_READ"})
    public Boolean getIsRead() {
        return isRead;
    }

    public void setIsRead(Boolean isRead) {
        this.isRead = isRead;
    }


    @Transient
    public String getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        YxMessage yxMessage = (YxMessage) o;

        if (isRead != null ? !isRead.equals(yxMessage.isRead) : yxMessage.isRead != null) return false;
        if (messageId != null ? !messageId.equals(yxMessage.messageId) : yxMessage.messageId != null) return false;
        if (messageTime != null ? !messageTime.equals(yxMessage.messageTime) : yxMessage.messageTime != null)
            return false;
        if (receiveUserId != null ? !receiveUserId.equals(yxMessage.receiveUserId) : yxMessage.receiveUserId != null)
            return false;
        if (sentUserId != null ? !sentUserId.equals(yxMessage.sentUserId) : yxMessage.sentUserId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = messageId != null ? messageId.hashCode() : 0;
        result = 31 * result + (sentUserId != null ? sentUserId.hashCode() : 0);
        result = 31 * result + (receiveUserId != null ? receiveUserId.hashCode() : 0);
        result = 31 * result + (messageTime != null ? messageTime.hashCode() : 0);
        result = 31 * result + (isRead != null ? isRead.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "TYPE_ID", referencedColumnName = "TYPE_ID")
    public YxMessageType getYxMessageTypeByTypeId() {
        return yxMessageTypeByTypeId;
    }

    public void setYxMessageTypeByTypeId(YxMessageType yxMessageTypeByTypeId) {
        this.yxMessageTypeByTypeId = yxMessageTypeByTypeId;
    }

    @ManyToOne
    @JoinColumn(name = "TEXT_ID", referencedColumnName = "TEXT_ID")
    public YxTextStore getYxTextStoreByTextId() {
        return yxTextStoreByTextId;
    }

    public void setYxTextStoreByTextId(YxTextStore yxTextStoreByTextId) {
        this.yxTextStoreByTextId = yxTextStoreByTextId;
    }

    @OneToMany(mappedBy = "yxMessageByMessageId")
    public Collection<YxMessageObject> getYxMessageObjectsByMessageId() {
        return yxMessageObjectsByMessageId;
    }

    public void setYxMessageObjectsByMessageId(Collection<YxMessageObject> yxMessageObjectsByMessageId) {
        this.yxMessageObjectsByMessageId = yxMessageObjectsByMessageId;
    }

}
