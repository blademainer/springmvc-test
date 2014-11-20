package com.kingray.hibernate.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by blademainer<a href="http://xiongyingqi.com">xiongyingqi.com</a> on 2014/11/5 0005.
 */
@Entity
public class YxKeyStore extends BaseDomain {
    private Integer keyId;
    private String keyName;
    /**
     * Base64加密后存储key，多个key使用|分割
     */
    private YxTextStore keyBase;
    private Date expiresDate;
    private Integer allowLength;

    public YxKeyStore() {
    }

    public YxKeyStore(String keyName) {
        this.keyName = keyName;
    }

    public YxKeyStore(Integer keyId, String keyName, YxTextStore keyBase, Date expiresDate) {
        this.keyId = keyId;
        this.keyName = keyName;
        this.keyBase = keyBase;
        this.expiresDate = expiresDate;
    }


    @Id
    @GeneratedValue
    public Integer getKeyId() {
        return keyId;
    }

    public void setKeyId(Integer keyId) {
        this.keyId = keyId;
    }

    @Column(unique = true)
    public String getKeyName() {
        return keyName;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }

    @ManyToOne
    public YxTextStore getKeyBase() {
        return keyBase;
    }

    public void setKeyBase(YxTextStore keyBase) {
        this.keyBase = keyBase;
    }

    public Date getExpiresDate() {
        return expiresDate;
    }

    public void setExpiresDate(Date expiresDate) {
        this.expiresDate = expiresDate;
    }

    public Integer getAllowLength() {
        return allowLength;
    }

    public void setAllowLength(Integer allowLength) {
        this.allowLength = allowLength;
    }
}
