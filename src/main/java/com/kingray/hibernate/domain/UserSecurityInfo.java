package com.kingray.hibernate.domain;


import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by 瑛琪<a href="http://xiongyingqi.com">xiongyingqi.com</a> on 2014/4/28 0028.
 */
@Entity
public class UserSecurityInfo extends BaseDomain {
    private Long logId;
    private Short timesLoginFail;
    private Short timesPayPasswordFail;
    private PUser userByUserId;
    private Timestamp lastTimePayPasswordFail;

    @Id
    @GeneratedValue
    public Long getLogId() {
        return logId;
    }

    public void setLogId(Long logId) {
        this.logId = logId;
    }

    @Basic
    public Short getTimesLoginFail() {
        return timesLoginFail;
    }

    public void setTimesLoginFail(Short timesLoginFail) {
        this.timesLoginFail = timesLoginFail;
    }

    @Basic
    public Short getTimesPayPasswordFail() {
        return timesPayPasswordFail;
    }

    public void setTimesPayPasswordFail(Short timesPayPasswordFail) {
        this.timesPayPasswordFail = timesPayPasswordFail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserSecurityInfo that = (UserSecurityInfo) o;

        if (logId != null ? !logId.equals(that.logId) : that.logId != null) return false;
        if (timesLoginFail != null ? !timesLoginFail.equals(that.timesLoginFail) : that.timesLoginFail != null)
            return false;
        if (timesPayPasswordFail != null ? !timesPayPasswordFail.equals(that.timesPayPasswordFail) : that.timesPayPasswordFail != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = logId != null ? logId.hashCode() : 0;
        result = 31 * result + (timesLoginFail != null ? timesLoginFail.hashCode() : 0);
        result = 31 * result + (timesPayPasswordFail != null ? timesPayPasswordFail.hashCode() : 0);
        return result;
    }

    @ManyToOne
    public PUser getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(PUser userByUserId) {
        this.userByUserId = userByUserId;
    }

    public Timestamp getLastTimePayPasswordFail() {
        return lastTimePayPasswordFail;
    }

    public void setLastTimePayPasswordFail(Timestamp lastTimePayPasswordFail) {
        this.lastTimePayPasswordFail = lastTimePayPasswordFail;
    }
}
