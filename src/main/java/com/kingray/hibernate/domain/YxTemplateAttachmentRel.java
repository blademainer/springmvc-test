package com.kingray.hibernate.domain;

import javax.persistence.*;

/**
 * Created by 瑛琪<a href="http://xiongyingqi.com">xiongyingqi.com</a> on 2014/5/9 0009.
 */
@Entity
@Table(name = "YX_TEMPLATE_ATTACHMENT_REL")
@IdClass(YxTemplateAttachmentRelPK.class)
public class YxTemplateAttachmentRel {
    private Integer attachmentId;
    private Integer templateId;
    private YxEmailTemplate yxEmailTemplateByTemplateId;
    private YxEmailAttachment yxEmailAttachmentByAttachmentId;

    @Id
    @Column(name = "ATTACHMENT_ID")
    public Integer getAttachmentId() {
        return attachmentId;
    }

    public void setAttachmentId(Integer attachmentId) {
        this.attachmentId = attachmentId;
    }

    @Id
    @Column(name = "TEMPLATE_ID")
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

        YxTemplateAttachmentRel that = (YxTemplateAttachmentRel) object;

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

    @ManyToOne
    @JoinColumn(name = "TEMPLATE_ID", referencedColumnName = "TEMPLATE_ID", nullable = false, insertable = false, updatable = false)
    public YxEmailTemplate getYxEmailTemplateByTemplateId() {
        return yxEmailTemplateByTemplateId;
    }

    public void setYxEmailTemplateByTemplateId(YxEmailTemplate yxEmailTemplateByTemplateId) {
        this.yxEmailTemplateByTemplateId = yxEmailTemplateByTemplateId;
    }

    @ManyToOne
    @JoinColumn(name = "ATTACHMENT_ID", referencedColumnName = "ATTACHMENT_ID", nullable = false, insertable = false, updatable = false)
    public YxEmailAttachment getYxEmailAttachmentByAttachmentId() {
        return yxEmailAttachmentByAttachmentId;
    }

    public void setYxEmailAttachmentByAttachmentId(YxEmailAttachment yxEmailAttachmentByAttachmentId) {
        this.yxEmailAttachmentByAttachmentId = yxEmailAttachmentByAttachmentId;
    }
}
