package com.kingray.profile;

import com.xiongyingqi.Logger;
import com.xiongyingqi.util.PropertiesHelper;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.net.URL;
import java.util.Map;

/**
 * 站点配置
 * Created by blademainer<a href="http://xiongyingqi.com">xiongyingqi.com</a> on 2014/10/30 0030.
 */
//@Component
public class SiteProfile implements ApplicationContextAware {
    private String protocol = "http";
    private String siteBaseHost = "localhost";
    private String apiKey;
    /**
     * 发送短信间隔（秒）
     */
    private int sendSmsInterval;

    public SiteProfile() {
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getSiteBaseHost() {
        return siteBaseHost;
    }

    public void setSiteBaseHost(String siteBaseHost) {
        this.siteBaseHost = siteBaseHost;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public int getSendSmsInterval() {
        return sendSmsInterval;
    }

    public void setSendSmsInterval(int sendSmsInterval) {
        this.sendSmsInterval = sendSmsInterval;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        readProperties();
    }

    public void readProperties() {
        URL resource = getClass().getClassLoader().getResource("profile.properties");
        if (resource != null) {
            String file = resource.getFile();
            Map<String, String> propertiesMap = PropertiesHelper.readProperties(file);
            apiKey = propertiesMap.get("sms.apiKey");
            try {
                sendSmsInterval = Integer.parseInt(propertiesMap.get("sms.sendInterval"));
            } catch (Exception e) {
                sendSmsInterval = 30;
            }
        } else {
            System.err.println("短信属性文件没有找到！");
            Logger.error("短信属性文件没有找到！");
        }
    }


    public static void main(String[] args) {
        SiteProfile siteProfile = new SiteProfile();
        siteProfile.readProperties();
        System.out.println(siteProfile.getApiKey());
    }
}
