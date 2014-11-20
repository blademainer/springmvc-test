package com.kingray.hibernate.domain;



import javax.persistence.*;

/**
 * Created by 瑛琪<a href="http://xiongyingqi.com">xiongyingqi.com</a> on 2014/6/10 0010.
 */
@Entity
@Table(name = "YX_TEXT_STORE")
public class YxTextStore extends BaseDomain {
    private Long textId;
    private Integer largestTextId;
    private Integer mediumTextId;
    private Integer longTextId;
    private String smallTextContent;
    private YxMediumText yxMediumTextByMediumTextId;
    private YxLargestText yxLargestTextByLargestTextId;
    private YxLongText yxLongTextByLongTextId;

    @Id
    @GeneratedValue
    @Column(name = "TEXT_ID")
    public Long getTextId() {
        return textId;
    }

    public void setTextId(Long textId) {
        this.textId = textId;
    }

    @Basic
    @Column(name = "LARGEST_TEXT_ID")
    public Integer getLargestTextId() {
        return largestTextId;
    }

    public void setLargestTextId(Integer largestTextId) {
        this.largestTextId = largestTextId;
    }

    @Basic
    @Column(name = "MEDIUM_TEXT_ID")
    public Integer getMediumTextId() {
        return mediumTextId;
    }

    public void setMediumTextId(Integer mediumTextId) {
        this.mediumTextId = mediumTextId;
    }

    @Basic
    @Column(name = "LONG_TEXT_ID")
    public Integer getLongTextId() {
        return longTextId;
    }

    public void setLongTextId(Integer longTextId) {
        this.longTextId = longTextId;
    }


    @Basic
    @Column(name = "SMALL_TEXT_CONTENT")
    public String getSmallTextContent() {
        return smallTextContent;
    }

    public void setSmallTextContent(String smallTextContent) {
        this.smallTextContent = smallTextContent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        YxTextStore that = (YxTextStore) o;

        if (largestTextId != null ? !largestTextId.equals(that.largestTextId) : that.largestTextId != null)
            return false;
        if (longTextId != null ? !longTextId.equals(that.longTextId) : that.longTextId != null) return false;
        if (mediumTextId != null ? !mediumTextId.equals(that.mediumTextId) : that.mediumTextId != null) return false;
        if (smallTextContent != null ? !smallTextContent.equals(that.smallTextContent) : that.smallTextContent != null)
            return false;
        if (textId != null ? !textId.equals(that.textId) : that.textId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = textId != null ? textId.hashCode() : 0;
        result = 31 * result + (largestTextId != null ? largestTextId.hashCode() : 0);
        result = 31 * result + (mediumTextId != null ? mediumTextId.hashCode() : 0);
        result = 31 * result + (longTextId != null ? longTextId.hashCode() : 0);
        result = 31 * result + (smallTextContent != null ? smallTextContent.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "MEDIUM_TEXT_ID", referencedColumnName = "MEDIUM_TEXT_ID", insertable = false, updatable = false)
    public YxMediumText getYxMediumTextByMediumTextId() {
        return yxMediumTextByMediumTextId;
    }

    public void setYxMediumTextByMediumTextId(YxMediumText yxMediumTextByMediumTextId) {
        this.yxMediumTextByMediumTextId = yxMediumTextByMediumTextId;
    }


    @ManyToOne
    @JoinColumn(name = "LARGEST_TEXT_ID", referencedColumnName = "LARGEST_TEXT_ID", insertable = false, updatable = false)
    public YxLargestText getYxLargestTextByLargestTextId() {
        return yxLargestTextByLargestTextId;
    }

    public void setYxLargestTextByLargestTextId(YxLargestText yxLargestTextByLargestTextId) {
        this.yxLargestTextByLargestTextId = yxLargestTextByLargestTextId;
    }

    @ManyToOne
    @JoinColumn(name = "LONG_TEXT_ID", referencedColumnName = "LONG_TEXT_ID", insertable = false, updatable = false)
    public YxLongText getYxLongTextByLongTextId() {
        return yxLongTextByLongTextId;
    }

    public void setYxLongTextByLongTextId(YxLongText yxLongTextByLongTextId) {
        this.yxLongTextByLongTextId = yxLongTextByLongTextId;
    }
}
