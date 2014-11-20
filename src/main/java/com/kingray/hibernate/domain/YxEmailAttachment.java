package com.kingray.hibernate.domain;

import javax.persistence.*;

/**
 * Created by 瑛琪<a href="http://xiongyingqi.com">xiongyingqi.com</a> on 2014/5/9 0009.
 */
@Entity
@Table(name = "YX_EMAIL_ATTACHMENT")
public class YxEmailAttachment {
    private Integer attachmentId;
    private String attachmentName;
    private YxFile yxFileByFileId;

    @Id
    @GeneratedValue
    @Column(name = "ATTACHMENT_ID")
    public Integer getAttachmentId() {
        return attachmentId;
    }

    public void setAttachmentId(Integer attachmentId) {
        this.attachmentId = attachmentId;
    }

    @Basic
    @Column(name = "ATTACHMENT_NAME")
    public String getAttachmentName() {
        return attachmentName;
    }

    public void setAttachmentName(String attachmentName) {
        this.attachmentName = attachmentName;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        YxEmailAttachment that = (YxEmailAttachment) object;

        if (attachmentId != null ? !attachmentId.equals(that.attachmentId) : that.attachmentId != null) return false;
        if (attachmentName != null ? !attachmentName.equals(that.attachmentName) : that.attachmentName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = attachmentId != null ? attachmentId.hashCode() : 0;
        result = 31 * result + (attachmentName != null ? attachmentName.hashCode() : 0);
        return result;
    }

    @ManyToOne
    public YxFile getYxFileByFileId() {
        return yxFileByFileId;
    }

    public void setYxFileByFileId(YxFile yxFileByFileId) {
        this.yxFileByFileId = yxFileByFileId;
    }
}
