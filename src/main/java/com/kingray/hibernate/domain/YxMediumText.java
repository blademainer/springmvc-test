package com.kingray.hibernate.domain;





import javax.persistence.*;

/**
 * Created by 瑛琪<a href="http://xiongyingqi.com">xiongyingqi.com</a> on 2014/6/10 0010.
 */
@Entity
@Table(name = "YX_MEDIUM_TEXT")
public class YxMediumText extends BaseDomain {
    private Integer mediumTextId;
    private String mediumTextContent;

    @Id
    @GeneratedValue
    @Column(name = "MEDIUM_TEXT_ID")
    public Integer getMediumTextId() {
        return mediumTextId;
    }

    public void setMediumTextId(Integer mediumTextId) {
        this.mediumTextId = mediumTextId;
    }

    @Basic
    @Column(name = "MEDIUM_TEXT_CONTENT", length = 16777215, columnDefinition = "MEDIUMTEXT")
    public String getMediumTextContent() {
        return mediumTextContent;
    }

    public void setMediumTextContent(String mediumTextContent) {
        this.mediumTextContent = mediumTextContent;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        YxMediumText that = (YxMediumText) object;

        if (mediumTextContent != null ? !mediumTextContent.equals(that.mediumTextContent) : that.mediumTextContent != null)
            return false;
        if (mediumTextId != null ? !mediumTextId.equals(that.mediumTextId) : that.mediumTextId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = mediumTextId != null ? mediumTextId.hashCode() : 0;
        result = 31 * result + (mediumTextContent != null ? mediumTextContent.hashCode() : 0);
        return result;
    }
}
