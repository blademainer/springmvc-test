package com.kingray.hibernate.domain;



import javax.persistence.*;

/**
 * Created by 瑛琪<a href="http://xiongyingqi.com">xiongyingqi.com</a> on 2014/4/28 0028.
 */
@Entity
@Table(name = "YX_LINK_PARAM")
public class YxLinkParam extends BaseDomain {
    private Integer paramId;
    private Integer linkId;
    private String paramUseage;
    private String paramName;
    private YxLinkAddr yxLinkAddrByLinkId;
    /**
     * 参数对应值，不存入数据库
     */
    private String paramValue;

    @Id
    @GeneratedValue
    @Column(name = "PARAM_ID")
    public Integer getParamId() {
        return paramId;
    }

    public void setParamId(Integer paramId) {
        this.paramId = paramId;
    }

    @Basic
    @Column(name = "LINK_ID")
    public Integer getLinkId() {
        return linkId;
    }

    public void setLinkId(Integer linkId) {
        this.linkId = linkId;
    }

    @Basic
    @Column(name = "PARAM_USEAGE")
    public String getParamUseage() {
        return paramUseage;
    }

    public void setParamUseage(String paramUseage) {
        this.paramUseage = paramUseage;
    }

    @Basic
    @Column(name = "PARAM_NAME")
    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    @Transient
    public String getParamValue() {
        return paramValue;
    }

    public void setParamValue(String paramValue) {
        this.paramValue = paramValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        YxLinkParam that = (YxLinkParam) o;

        if (linkId != null ? !linkId.equals(that.linkId) : that.linkId != null) return false;
        if (paramId != null ? !paramId.equals(that.paramId) : that.paramId != null) return false;
        if (paramName != null ? !paramName.equals(that.paramName) : that.paramName != null) return false;
        if (paramUseage != null ? !paramUseage.equals(that.paramUseage) : that.paramUseage != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = paramId != null ? paramId.hashCode() : 0;
        result = 31 * result + (linkId != null ? linkId.hashCode() : 0);
        result = 31 * result + (paramUseage != null ? paramUseage.hashCode() : 0);
        result = 31 * result + (paramName != null ? paramName.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "LINK_ID", referencedColumnName = "LINK_ID", insertable = false, updatable = false)
    public YxLinkAddr getYxLinkAddrByLinkId() {
        return yxLinkAddrByLinkId;
    }

    public void setYxLinkAddrByLinkId(YxLinkAddr yxLinkAddrByLinkId) {
        this.yxLinkAddrByLinkId = yxLinkAddrByLinkId;
    }
}
