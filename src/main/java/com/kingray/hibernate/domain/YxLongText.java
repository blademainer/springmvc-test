package com.kingray.hibernate.domain;





import javax.persistence.*;

/**
 * Created by 瑛琪<a href="http://xiongyingqi.com">xiongyingqi.com</a> on 2014/6/10 0010.
 */
@Entity
@Table(name = "YX_LONG_TEXT")
public class YxLongText extends BaseDomain {
    private Integer longTextId;
    private String longTextContent;

    @Id
    @GeneratedValue
    @Column(name = "LONG_TEXT_ID")
    public Integer getLongTextId() {
        return longTextId;
    }

    public void setLongTextId(Integer longTextId) {
        this.longTextId = longTextId;
    }

    @Basic
    @Column(name = "LONG_TEXT_CONTENT", length = 65535, columnDefinition = "TEXT")
    public String getLongTextContent() {
        return longTextContent;
    }

    public void setLongTextContent(String longTextContent) {
        this.longTextContent = longTextContent;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        YxLongText that = (YxLongText) object;

        if (longTextContent != null ? !longTextContent.equals(that.longTextContent) : that.longTextContent != null)
            return false;
        if (longTextId != null ? !longTextId.equals(that.longTextId) : that.longTextId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = longTextId != null ? longTextId.hashCode() : 0;
        result = 31 * result + (longTextContent != null ? longTextContent.hashCode() : 0);
        return result;
    }
}
