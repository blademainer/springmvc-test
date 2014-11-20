package com.kingray.hibernate.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by 瑛琪<a href="http://xiongyingqi.com">xiongyingqi.com</a> on 2014/5/9 0009.
 */
public class YxTemplateAttachmentRelPK implements Serializable {
    private Integer attachmentId;
    private Integer templateId;

    @Column(name = "ATTACHMENT_ID")
    @Id
    public Integer getAttachmentId() {
        return attachmentId;
    }

    public void setAttachmentId(Integer attachmentId) {
        this.attachmentId = attachmentId;
    }

    @Column(name = "TEMPLATE_ID")
    @Id
    public Integer getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Integer templateId) {
        this.templateId = templateId;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        YxTemplateAttachmentRelPK that = (YxTemplateAttachmentRelPK) object;

        if (attachmentId != null ? !attachmentId.equals(that.attachmentId) : that.attachmentId != null) return false;
        if (templateId != null ? !templateId.equals(that.templateId) : that.templateId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = attachmentId != null ? attachmentId.hashCode() : 0;
        result = 31 * result + (templateId != null ? templateId.hashCode() : 0);
        return result;
    }
}
