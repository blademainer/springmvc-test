/**
 * YIXUN_1.5_EE
 */
package com.kingray.vo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xiongyingqi.util.EntityHelper;
import org.springframework.beans.BeanUtils;

/**
 * 返回代码及注释
 *
 * @author 瑛琪 <a href="http://xiongyingqi.com">xiongyingqi.com</a>
 * @version 2013-10-17 下午5:33:27
 */
public class CodeVo extends EntityHelper {
    /**
     * 默认所有操作值均返回该值
     */
    public static final CodeVo SUCCESS = new CodeVo(200, "SYSTEM", "ACCEPTED", "成功");

    public static final CodeVo BEAN_VALIDATE_ERROR = new CodeVo(1, "CLIENT", "BEAN_VALIDATE_ERROR", "对象验证失败");

    public static final CodeVo NO_LOGIN_ERROR = new CodeVo(100, "CLIENT", "NO_LOGIN_ERROR", "用户没有登录");
    public static final CodeVo PERMISSION_ERROR = new CodeVo(101, "SYSTEM", "PERMISSION_ERROR",
            "无权限访问");
    public static final CodeVo USER_NAME_PASSWORD_ERROR = new CodeVo(102, "CLIENT",
            "USER_NAME_PASSWORD_ERROR", "用户名或密码错误");
    public static final CodeVo LOGIN_ERROR_WITH_CAPTCHA = new CodeVo(103, "CLIENT", "LOGIN_MUST_WITH_CAPTCHA", "登录必须带验证码");

    public static final CodeVo USER_VERIFIED = new CodeVo(110, "CLIENT", "USER_VERIFIED", "用户已经验证");


    public static final CodeVo STOCK_IMPORT_ERROR = new CodeVo(104, "CLIENT", "STOCK_IMPORT_ERROR", "无法导入，可能没有对应的模板");

    public static final CodeVo FUND_IMPORT_ERROR = new CodeVo(105, "CLIENT", "FUND_IMPORT_ERROR", "有数据导入失败");

    public static final CodeVo VERIFY_ERROR = new CodeVo(106, "CLIENT", "VERIFY_ERROR", "验证失败");

    public static final CodeVo TOO_FREQUENTLY = new CodeVo(107, "CLIENT", "TOO_FREQUENTLY", "发送请求太频繁");

    public static final CodeVo MOBILE_EXISTS = new CodeVo(109, "CLIENT", "MOBILE_EXISTS", "手机号码已经存在");

    public static final CodeVo CAPTCHA_ERROR = new CodeVo(108, "CLIENT", "CAPTCHA_ERROR", "验证码错误");


    public static final CodeVo SQL_ERROR = new CodeVo(150, "SYSTEM", "SQL_ERROR", "数据库操作错误");
    public static final CodeVo SERVER_ERROR = new CodeVo(500, "SYSTEM", "SERVER_ERROR", "服务器内部错误");

    public CodeVo(int errorCode, String errorName, String errorValue, String errorReason) {
        this.resultCode = errorCode;
        this.resultName = errorName;
        this.resultReason = errorReason;
        this.resultValue = errorValue;
    }

    public CodeVo() {
    }

    private int resultCode;
    private String resultName;
    private String resultReason;
    private String resultValue;
    private Object resultObject;

    /**
     * int
     *
     * @return the resultCode
     */
    public int getResultCode() {
        return this.resultCode;
    }

    /**
     * int
     *
     * @param resultCode the resultCode to set
     */
    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    /**
     * String
     *
     * @return the resultName
     */
    public String getResultName() {
        return this.resultName;
    }

    /**
     * String
     *
     * @param resultName the resultName to set
     */
    public void setResultName(String resultName) {
        this.resultName = resultName;
    }

    /**
     * String
     *
     * @return the resultValue
     */
    public String getResultValue() {
        return this.resultValue;
    }

    /**
     * String
     *
     * @param resultValue the resultValue to set
     */
    public void setResultValue(String resultValue) {
        this.resultValue = resultValue;
    }

    /**
     * String
     *
     * @return the resultReason
     */
    public String getResultReason() {
        return this.resultReason;
    }


    /**
     * String
     *
     * @param resultReason the resultReason to set
     */
    public void setResultReason(String resultReason) {
        this.resultReason = resultReason;
    }

//    public Object getResultObject() {
//        return resultObject;
//    }

    /**
     * 调用完一次get之后就重置resultObject，防止其他方法调用CodeVo之后对象造成影响
     *
     * @return
     */
    public Object getResultObject() {
        Object resultObject1 = resultObject;
        resultObject = null;
        return resultObject1;
    }

    public void setResultObject(Object resultObject) {
        this.resultObject = resultObject;
    }

    public String toJSON() {
        ObjectMapper mapper = new ObjectMapper();
        String json = null;
        try {
            json = mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }

    /**
     * <br>
     * 2013-9-30 下午3:52:05
     *
     * @see Enum#toString()
     */
    @Override
    public String toString() {
        return reflectToString(this);
    }

    @Override
    public CodeVo clone() {
        CodeVo codeVo = new CodeVo();
        BeanUtils.copyProperties(this, codeVo);
        return codeVo;
    }

    public static void main(String[] args) {
        CodeVo.SUCCESS.setResultObject("a");
        System.out.println(CodeVo.SUCCESS.toJSON());
        System.out.println(CodeVo.SUCCESS.toJSON());
    }
}
