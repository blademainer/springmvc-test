package com.kingray.hibernate.domain;

import javax.persistence.*;

/**
 * 微信用户绑定信息
 * Created by blademainer<a href="http://xiongyingqi.com">xiongyingqi.com</a> on 2014/10/30 0030.
 */
@Entity
public class YxWeiXinUserBind extends BaseDomain {
    private Integer bindId;
    private String weiXinUserId;
    private PUser user;
    /**
     * 随机生成密钥
     */
    private String secretKey;

    @Id
    @GeneratedValue
    public Integer getBindId() {
        return bindId;
    }

    public void setBindId(Integer bindId) {
        this.bindId = bindId;
    }

    @Column(unique = true)
    public String getWeiXinUserId() {
        return weiXinUserId;
    }

    public void setWeiXinUserId(String weiXinUserId) {
        this.weiXinUserId = weiXinUserId;
    }

    @ManyToOne
    public PUser getUser() {
        return user;
    }

    public void setUser(PUser user) {
        this.user = user;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }
}
