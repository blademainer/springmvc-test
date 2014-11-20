package com.kingray.hibernate.domain;

import javax.persistence.*;

/**
 * Created by 瑛琪<a href="http://xiongyingqi.com">xiongyingqi.com</a> on 2014/5/9 0009.
 */
@Entity
@Table(name = "YX_TEMPLATE_INLINE_IMAGE_REL")
@IdClass(YxTemplateInlineImageRelPK.class)
public class YxTemplateInlineImageRel {
    private Integer inlineId;
    private Integer templateId;
    private YxEmailTemplate yxEmailTemplateByTemplateId;
    private YxEmailInlineImage yxEmailInlineImageByInlineId;

    @Id
    @Column(name = "INLINE_ID")
    public Integer getInlineId() {
        return inlineId;
    }

    public void setInlineId(Integer inlineId) {
        this.inlineId = inlineId;
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

        YxTemplateInlineImageRel that = (YxTemplateInlineImageRel) object;

        if (inlineId != null ? !inlineId.equals(that.inlineId) : that.inlineId != null) return false;
        if (templateId != null ? !templateId.equals(that.templateId) : that.templateId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = inlineId != null ? inlineId.hashCode() : 0;
        result = 31 * result + (templateId != null ? templateId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    public YxEmailTemplate getYxEmailTemplateByTemplateId() {
        return yxEmailTemplateByTemplateId;
    }

    public void setYxEmailTemplateByTemplateId(YxEmailTemplate yxEmailTemplateByTemplateId) {
        this.yxEmailTemplateByTemplateId = yxEmailTemplateByTemplateId;
    }

    @ManyToOne
    public YxEmailInlineImage getYxEmailInlineImageByInlineId() {
        return yxEmailInlineImageByInlineId;
    }

    public void setYxEmailInlineImageByInlineId(YxEmailInlineImage yxEmailInlineImageByInlineId) {
        this.yxEmailInlineImageByInlineId = yxEmailInlineImageByInlineId;
    }
}
