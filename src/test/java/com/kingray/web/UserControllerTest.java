/**
 * YIXUN_1.5_EE
 */
package com.kingray.web;

import com.kingray.WebTest;
import com.xiongyingqi.util.DateHelper;
import org.junit.Test;

import java.util.Date;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * @author 瑛琪 <a href="http://xiongyingqi.com">xiongyingqi.com</a>
 * @version 2013-9-25 下午5:01:34
 */
//@TransactionConfiguration(defaultRollback = false)
public class UserControllerTest extends WebTest {

    @Test
    public void testValidate() throws Exception {
        mockMvc.perform(
                (post("/user/")
                        .param("userName", "1")
                        .param("userPassword", "111")
                        .param("mobile", "tewt")
                        .param("email", "test@gmail.com")
                        .param("birthday", DateHelper.dateToStrLong(new Date()))
                        .param("registerDate", DateHelper.dateToStrLong(new Date()))))
                .andDo(print());
    }

    @Test
    public void testValidate2() throws Exception {
        mockMvc.perform(
                (post("/user/validate")
                        .param("user.userName", "1")
                        .param("user.userPassword", "111")
                        .param("user.mobile", "tewt")
                        .param("user.email", "test@gmail.com")
                        .param("user.birthday", DateHelper.dateToStrLong(new Date()))
                        .param("user.registerDate", DateHelper.dateToStrLong(new Date()))))
                .andDo(print());
    }

    @Test
    public void testValidate3() throws Exception {
        mockMvc.perform(
                (post("/user/validate")
                        .param("user.userName", "admin")
                        .param("user.userPassword", "111")
                        .param("user.mobile", "15084818000")
                        .param("user.email", "test@gmail.com")
                        .param("user.birthday", DateHelper.dateToStrLong(new Date()))
                        .param("user.registerDate", DateHelper.dateToStrLong(new Date()))))
                .andDo(print());
    }

}
