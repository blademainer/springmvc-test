/**
 * YIXUN_1.5_EE
 */
package com.kingray;

import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

/**
 * @author 瑛琪 <a href="http://xiongyingqi.com">xiongyingqi.com</a>
 * @version 2013-9-25 下午5:21:26
 */
@WebAppConfiguration
public class WebTest extends BaseTest {
	@Autowired
	protected WebApplicationContext wac;

	protected MockMvc mockMvc;

	@Before
	public void setup() {
		// webAppContextSetup 注意上面的static import  
		// webAppContextSetup 构造的WEB容器可以添加fileter 但是不能添加listenCLASS  
		// WebApplicationContext context =  
		// ContextLoader.getCurrentWebApplicationContext();  
		// 如果控制器包含如上方法 则会报空指针  
		this.mockMvc = webAppContextSetup(this.wac).build();
	}
}
