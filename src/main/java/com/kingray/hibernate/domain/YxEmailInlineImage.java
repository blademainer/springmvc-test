package com.kingray.hibernate.domain;

import javax.persistence.*;

/**
 * Created by 瑛琪<a href="http://xiongyingqi.com">xiongyingqi.com</a> on 2014/5/9 0009.
 */
@Entity
@Table(name = "YX_EMAIL_INLINE_IMAGE")
public class YxEmailInlineImage {
    private Integer inlineId;
    private String inlineCode;
    private YxFile yxFileByFileId;

    @Id
    @Column(name = "INLINE_ID")
    public Integer getInlineId() {
        return inlineId;
    }

    public void setInlineId(Integer inlineId) {
        this.inlineId = inlineId;
    }

    @Basic
    @Column(name = "INLINE_CODE")
    public String getInlineCode() {
        return inlineCode;
    }

    public void setInlineCode(String inlineCode) {
        this.inlineCode = inlineCode;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        YxEmailInlineImage that = (YxEmailInlineImage) object;

        if (inlineCode != null ? !inlineCode.equals(that.inlineCode) : that.inlineCode != null) return false;
        if (inlineId != null ? !inlineId.equals(that.inlineId) : that.inlineId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = inlineId != null ? inlineId.hashCode() : 0;
        result = 31 * result + (inlineCode != null ? inlineCode.hashCode() : 0);
        return result;
    }

    @ManyToOne
    public YxFile getYxFileByFileId() {
        return yxFileByFileId;
    }

    public void setYxFileByFileId(YxFile yxFileByFileId) {
        this.yxFileByFileId = yxFileByFileId;
    }
}
