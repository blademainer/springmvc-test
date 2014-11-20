package com.kingray.hibernate.domain;


import javax.persistence.*;

/**
 * Created by 瑛琪<a href="http://xiongyingqi.com">xiongyingqi.com</a> on 2014/5/6 0006.
 */
@Entity
@Table(name = "YX_EMAIL_ADDRESS_REL")
@IdClass(YxEmailAddressRelPK.class)
public class YxEmailAddressRel extends BaseDomain {
    private Integer linkId;
    private Integer templateId;

    @Id
    @Column(name = "LINK_ID")
    public Integer getLinkId() {
        return linkId;
    }

    public void setLinkId(Integer linkId) {
        this.linkId = linkId;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        YxEmailAddressRel that = (YxEmailAddressRel) o;

        if (linkId != null ? !linkId.equals(that.linkId) : that.linkId != null) return false;
        if (templateId != null ? !templateId.equals(that.templateId) : that.templateId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = linkId != null ? linkId.hashCode() : 0;
        result = 31 * result + (templateId != null ? templateId.hashCode() : 0);
        return result;
    }
}
