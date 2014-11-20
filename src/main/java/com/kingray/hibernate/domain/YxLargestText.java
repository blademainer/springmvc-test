package com.kingray.hibernate.domain;



import javax.persistence.*;

/**
 * Created by 瑛琪<a href="http://xiongyingqi.com">xiongyingqi.com</a> on 2014/6/10 0010.
 */
@Entity
@Table(name = "YX_LARGEST_TEXT")
public class YxLargestText extends BaseDomain {
    private Integer largestTextId;
    private String largestTextContent;

    @Id
    @GeneratedValue
    @Column(name = "LARGEST_TEXT_ID")
    public Integer getLargestTextId() {
        return largestTextId;
    }

    public void setLargestTextId(Integer largestTextId) {
        this.largestTextId = largestTextId;
    }

    @Basic
    @Column(name = "LARGEST_TEXT_CONTENT", length = Integer.MAX_VALUE, columnDefinition = "LONGTEXT")
    public String getLargestTextContent() {
        return largestTextContent;
    }

    public void setLargestTextContent(String largestTextContent) {
        this.largestTextContent = largestTextContent;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        YxLargestText that = (YxLargestText) object;

        if (largestTextContent != null ? !largestTextContent.equals(that.largestTextContent) : that.largestTextContent != null)
            return false;
        if (largestTextId != null ? !largestTextId.equals(that.largestTextId) : that.largestTextId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = largestTextId != null ? largestTextId.hashCode() : 0;
        result = 31 * result + (largestTextContent != null ? largestTextContent.hashCode() : 0);
        return result;
    }
}
