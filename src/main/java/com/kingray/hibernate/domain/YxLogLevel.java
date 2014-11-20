package com.kingray.hibernate.domain;




import javax.persistence.*;

/**
 * Created by 瑛琪<a href="http://xiongyingqi.com">xiongyingqi.com</a> on 2014/6/10 0010.
 */
@Entity
@Table(name = "YX_LOG_LEVEL")
public class YxLogLevel extends BaseDomain {
    public static final YxLogLevel INFO = new YxLogLevel();
    public static final YxLogLevel DEBUG = new YxLogLevel();
    public static final YxLogLevel WARN = new YxLogLevel();
    public static final YxLogLevel ERROR = new YxLogLevel();

    static {
        INFO.setLogLevelId(1);
        INFO.setLogLevelCode("INFO");
        INFO.setLogLevelName("信息");
        initDomain(INFO);

        DEBUG.setLogLevelId(2);
        DEBUG.setLogLevelCode("DEBUG");
        DEBUG.setLogLevelName("调试");
        initDomain(DEBUG);

        WARN.setLogLevelId(3);
        WARN.setLogLevelCode("WARN");
        WARN.setLogLevelName("警告");
        initDomain(WARN);

        ERROR.setLogLevelId(4);
        ERROR.setLogLevelCode("ERROR");
        ERROR.setLogLevelName("错误");
        initDomain(ERROR);
    }



    private Integer logLevelId;
    private String logLevelCode;
    private String logLevelName;

    @Id
    @Column(name = "LOG_LEVEL_ID")
    public Integer getLogLevelId() {
        return logLevelId;
    }

    public void setLogLevelId(Integer logLevelId) {
        this.logLevelId = logLevelId;
    }

    @Basic
    @Column(name = "LOG_LEVEL_CODE")
    public String getLogLevelCode() {
        return logLevelCode;
    }

    public void setLogLevelCode(String logLevelCode) {
        this.logLevelCode = logLevelCode;
    }

    @Basic
    @Column(name = "LOG_LEVEL_NAME")
    public String getLogLevelName() {
        return logLevelName;
    }

    public void setLogLevelName(String logLevelName) {
        this.logLevelName = logLevelName;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        YxLogLevel that = (YxLogLevel) object;

        if (logLevelCode != null ? !logLevelCode.equals(that.logLevelCode) : that.logLevelCode != null) return false;
        if (logLevelId != null ? !logLevelId.equals(that.logLevelId) : that.logLevelId != null) return false;
        if (logLevelName != null ? !logLevelName.equals(that.logLevelName) : that.logLevelName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = logLevelId != null ? logLevelId.hashCode() : 0;
        result = 31 * result + (logLevelCode != null ? logLevelCode.hashCode() : 0);
        result = 31 * result + (logLevelName != null ? logLevelName.hashCode() : 0);
        return result;
    }
}
