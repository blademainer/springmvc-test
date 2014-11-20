package com.kingray.hibernate.domain;


import javax.persistence.*;
import java.util.Collection;

/**
 * 链接地址的作用是方便前后台交流进行配置快速链接，如邮件激活、账户信息的快速查看等。<p></p>
 * 链接基础地址包括域名和端口，例如: http://www.domain.com:8080/<p></p>
 * 相对路径即在链接基础地址上的地址，例如激活邮箱地址可能如下：http://www.domain.com:8080/account/verify?key=${key}&email=${email}<p></p>
 * 那么相对路径linkUri则为account/verify?key=${key}&email=${email}<p></p>
 * <p/>
 * 其中${key} 和${email}为前台需要的变量，后台在生成时注入值使用的变量。这里的变量必须在链接参数（yx_link_param）表中配置
 * <p/>
 * Created by 瑛琪<a href="http://xiongyingqi.com">xiongyingqi.com</a> on 2014/4/28 0028.
 */
@Entity
@Table(name = "YX_LINK_ADDR")
public class YxLinkAddr extends BaseDomain {
    private Integer linkId;
    private String linkCode;
    private String linkUseage;
    private String linkBaseUrl;
    private String linkUri;
    private Collection<YxLinkParam> yxLinkParamsByLinkId;

    @Id
    @GeneratedValue
    @Column(name = "LINK_ID")
    public Integer getLinkId() {
        return linkId;
    }

    public void setLinkId(Integer linkId) {
        this.linkId = linkId;
    }


    @Column(name = "LINK_CODE", unique = true)
    public String getLinkCode() {
        return linkCode;
    }

    public void setLinkCode(String linkCode) {
        this.linkCode = linkCode;
    }

    @Column(name = "LINK_USEAGE")
    public String getLinkUseage() {
        return linkUseage;
    }

    public void setLinkUseage(String linkUseage) {
        this.linkUseage = linkUseage;
    }

    @Column(name = "LINK_BASE_URL")
    public String getLinkBaseUrl() {
        return linkBaseUrl;
    }

    public void setLinkBaseUrl(String linkBaseUrl) {
        this.linkBaseUrl = linkBaseUrl;
    }

    @Column(name = "LINK_URI")
    public String getLinkUri() {
        return linkUri;
    }

    public void setLinkUri(String linkUri) {
        this.linkUri = linkUri;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        YxLinkAddr that = (YxLinkAddr) o;

        if (linkBaseUrl != null ? !linkBaseUrl.equals(that.linkBaseUrl) : that.linkBaseUrl != null) return false;
        if (linkId != null ? !linkId.equals(that.linkId) : that.linkId != null) return false;
        if (linkUri != null ? !linkUri.equals(that.linkUri) : that.linkUri != null) return false;
        if (linkUseage != null ? !linkUseage.equals(that.linkUseage) : that.linkUseage != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = linkId != null ? linkId.hashCode() : 0;
        result = 31 * result + (linkUseage != null ? linkUseage.hashCode() : 0);
        result = 31 * result + (linkBaseUrl != null ? linkBaseUrl.hashCode() : 0);
        result = 31 * result + (linkUri != null ? linkUri.hashCode() : 0);
        return result;
    }

    @OneToMany
    public Collection<YxLinkParam> getYxLinkParamsByLinkId() {
        return yxLinkParamsByLinkId;
    }

    public void setYxLinkParamsByLinkId(Collection<YxLinkParam> yxLinkParamsByLinkId) {
        this.yxLinkParamsByLinkId = yxLinkParamsByLinkId;
    }
}
