/**
 * YIXUN_1.5_EE
 */
package com.kingray.vo;

import com.kingray.hibernate.domain.PUser;
import com.kingray.hibernate.domain.YxLogLevel;
import com.kingray.hibernate.domain.YxLogType;
import com.xiongyingqi.util.EntityHelper;

/**
 * @author 瑛琪 <a href="http://xiongyingqi.com">xiongyingqi.com</a>
 * @version 2013-10-15 下午10:09:38
 */
public class LogVo {
    private YxLogType logType;
    private YxLogLevel logLevel;
    private String invokeMethod;
    private String methodFrom;
    private String target;
    private String invokeArgs;
    private String methodReturn;
    private int invokeTime;
    private PUser user;
    private String ip;

    public LogVo() {

    }

    public LogVo(YxLogType logType, YxLogLevel logLevel, String invokeMethod, String methodFrom,
                 String target, String invokeArgs, String methodReturn, int invokeTime, PUser user, String ip
    ) {//KrEmployee employee
        this.logType = logType;
        this.logLevel = logLevel;
        this.invokeMethod = invokeMethod;
        this.methodFrom = methodFrom;
        this.target = target;
        this.invokeArgs = invokeArgs;
        this.methodReturn = methodReturn;
        this.invokeTime = invokeTime;
        this.user = user;
        this.ip = ip;
    }

    /**
     * YxLogType
     *
     * @return the logType
     */
    public YxLogType getLogType() {
        return this.logType;
    }

    /**
     * YxLogType
     *
     * @param logType the logType to set
     */
    public void setLogType(YxLogType logType) {
        this.logType = logType;
    }

    /**
     * YxLogLevel
     *
     * @return the logLevel
     */
    public YxLogLevel getLogLevel() {
        return this.logLevel;
    }

    /**
     * YxLogLevel
     *
     * @param logLevel the logLevel to set
     */
    public void setLogLevel(YxLogLevel logLevel) {
        this.logLevel = logLevel;
    }

    /**
     * String
     *
     * @return the invokeMethod
     */
    public String getInvokeMethod() {
        return this.invokeMethod;
    }

    /**
     * String
     *
     * @param invokeMethod the invokeMethod to set
     */
    public void setInvokeMethod(String invokeMethod) {
        this.invokeMethod = invokeMethod;
    }

    /**
     * String
     *
     * @return the methodFrom
     */
    public String getMethodFrom() {
        return this.methodFrom;
    }

    /**
     * String
     *
     * @param methodFrom the methodFrom to set
     */
    public void setMethodFrom(String methodFrom) {
        this.methodFrom = methodFrom;
    }

    /**
     * String
     *
     * @return the target
     */
    public String getTarget() {
        return this.target;
    }

    /**
     * String
     *
     * @param target the target to set
     */
    public void setTarget(String target) {
        this.target = target;
    }

    /**
     * String
     *
     * @return the invokeArgs
     */
    public String getInvokeArgs() {
        return this.invokeArgs;
    }

    /**
     * String
     *
     * @param invokeArgs the invokeArgs to set
     */
    public void setInvokeArgs(String invokeArgs) {
        this.invokeArgs = invokeArgs;
    }

    /**
     * String
     *
     * @return the methodReturn
     */
    public String getMethodReturn() {
        return this.methodReturn;
    }

    /**
     * String
     *
     * @param methodReturn the methodReturn to set
     */
    public void setMethodReturn(String methodReturn) {
        this.methodReturn = methodReturn;
    }

    /**
     * int
     *
     * @return the invokeTime
     */
    public int getInvokeTime() {
        return this.invokeTime;
    }

    /**
     * int
     *
     * @param invokeTime the invokeTime to set
     */
    public void setInvokeTime(int invokeTime) {
        this.invokeTime = invokeTime;
    }

    /**
     * KrEmployee
     *
     * @return the employee
     */
//	public KrEmployee getEmployee() {
//		return this.employee;
//	}

    /**
     * KrEmployee
     *
     * @param employee
     *            the employee to set
     */
//	public void setEmployee(KrEmployee employee) {
//		this.employee = employee;
//	}

    /**
     * <br>
     * 2013-10-15 下午10:13:25
     *
     * @see Object#toString()
     */
    @Override
    public String toString() {
        return EntityHelper.reflectToString(this);
    }

    public PUser getUser() {
        return user;
    }

    public void setUser(PUser user) {
        this.user = user;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
