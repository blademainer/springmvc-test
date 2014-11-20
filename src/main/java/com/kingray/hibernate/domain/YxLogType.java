package com.kingray.hibernate.domain;




import javax.persistence.*;

/**
 * Created by 瑛琪<a href="http://xiongyingqi.com">xiongyingqi.com</a> on 2014/6/10 0010.
 */
@Entity
@Table(name = "YX_LOG_TYPE")
public class YxLogType extends BaseDomain {
    public static final YxLogType CONTROLLER = new YxLogType();
    public static final YxLogType SERVICE = new YxLogType();

    static {
        CONTROLLER.setLogTypeId(1);
        CONTROLLER.setLogTypeCode("CONTROLLER");
        CONTROLLER.setLogTypeName("网络访问日志");
        initDomain(CONTROLLER);

        SERVICE.setLogTypeId(2);
        SERVICE.setLogTypeCode("SERVICE");
        SERVICE.setLogTypeName("服务日志");
        initDomain(SERVICE);
    }

    private Integer logTypeId;
    private String logTypeCode;
    private String logTypeName;

    @Id
    @Column(name = "LOG_TYPE_ID")
    public Integer getLogTypeId() {
        return logTypeId;
    }

    public void setLogTypeId(Integer logTypeId) {
        this.logTypeId = logTypeId;
    }

    @Basic
    @Column(name = "LOG_TYPE_CODE")
    public String getLogTypeCode() {
        return logTypeCode;
    }

    public void setLogTypeCode(String logTypeCode) {
        this.logTypeCode = logTypeCode;
    }

    @Basic
    @Column(name = "LOG_TYPE_NAME")
    public String getLogTypeName() {
        return logTypeName;
    }

    public void setLogTypeName(String logTypeName) {
        this.logTypeName = logTypeName;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        YxLogType yxLogType = (YxLogType) object;

        if (logTypeCode != null ? !logTypeCode.equals(yxLogType.logTypeCode) : yxLogType.logTypeCode != null)
            return false;
        if (logTypeId != null ? !logTypeId.equals(yxLogType.logTypeId) : yxLogType.logTypeId != null) return false;
        if (logTypeName != null ? !logTypeName.equals(yxLogType.logTypeName) : yxLogType.logTypeName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = logTypeId != null ? logTypeId.hashCode() : 0;
        result = 31 * result + (logTypeCode != null ? logTypeCode.hashCode() : 0);
        result = 31 * result + (logTypeName != null ? logTypeName.hashCode() : 0);
        return result;
    }
}
