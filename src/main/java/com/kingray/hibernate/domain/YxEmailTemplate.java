package com.kingray.hibernate.domain;


import javax.persistence.*;
import java.util.Collection;

/**
 * Created by 瑛琪<a href="http://xiongyingqi.com">xiongyingqi.com</a> on 2014/5/6 0006.
 */
@Entity
@Table(name = "YX_EMAIL_TEMPLATE")
public class YxEmailTemplate extends BaseDomain {
    private Integer templateId;
    private Long textId;
    private String templateName;
    private String emailTitle;
    private Collection<YxTemplateAttachmentRel> yxTemplateAttachmentRelsByTemplateId;
    private Collection<YxTemplateInlineImageRel> yxTemplateInlineImageRelsByTemplateId;

    @Id
    @GeneratedValue
    @Column(name = "TEMPLATE_ID")
    public Integer getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Integer templateId) {
        this.templateId = templateId;
    }

    @Basic
    @Column(name = "TEXT_ID")
    public Long getTextId() {
        return textId;
    }

    public void setTextId(Long textId) {
        this.textId = textId;
    }

    @Basic
    @Column(name = "TEMPLATE_NAME")
    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        YxEmailTemplate that = (YxEmailTemplate) o;

        if (templateId != null ? !templateId.equals(that.templateId) : that.templateId != null) return false;
        if (templateName != null ? !templateName.equals(that.templateName) : that.templateName != null) return false;
        if (textId != null ? !textId.equals(that.textId) : that.textId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = templateId != null ? templateId.hashCode() : 0;
        result = 31 * result + (textId != null ? textId.hashCode() : 0);
        result = 31 * result + (templateName != null ? templateName.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "EMAIL_TITLE")
    public String getEmailTitle() {
        return emailTitle;
    }

    public void setEmailTitle(String emailTitle) {
        this.emailTitle = emailTitle;
    }

    @OneToMany(mappedBy = "yxEmailTemplateByTemplateId")
    public Collection<YxTemplateAttachmentRel> getYxTemplateAttachmentRelsByTemplateId() {
        return yxTemplateAttachmentRelsByTemplateId;
    }

    public void setYxTemplateAttachmentRelsByTemplateId(Collection<YxTemplateAttachmentRel> yxTemplateAttachmentRelsByTemplateId) {
        this.yxTemplateAttachmentRelsByTemplateId = yxTemplateAttachmentRelsByTemplateId;
    }

    @OneToMany(mappedBy = "yxEmailTemplateByTemplateId")
    public Collection<YxTemplateInlineImageRel> getYxTemplateInlineImageRelsByTemplateId() {
        return yxTemplateInlineImageRelsByTemplateId;
    }

    public void setYxTemplateInlineImageRelsByTemplateId(Collection<YxTemplateInlineImageRel> yxTemplateInlineImageRelsByTemplateId) {
        this.yxTemplateInlineImageRelsByTemplateId = yxTemplateInlineImageRelsByTemplateId;
    }
}
