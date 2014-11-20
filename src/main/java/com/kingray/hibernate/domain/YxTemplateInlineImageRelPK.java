package com.kingray.hibernate.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by 瑛琪<a href="http://xiongyingqi.com">xiongyingqi.com</a> on 2014/5/9 0009.
 */
public class YxTemplateInlineImageRelPK implements Serializable {
    private Integer inlineId;
    private Integer templateId;

    @Column(name = "INLINE_ID")
    @Id
    public Integer getInlineId() {
        return inlineId;
    }

    public void setInlineId(Integer inlineId) {
        this.inlineId = inlineId;
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

        YxTemplateInlineImageRelPK that = (YxTemplateInlineImageRelPK) object;

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
}
