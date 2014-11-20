/**
 * YIXUN_1.5_EE
 */
package com.kingray.web.file;

import org.springframework.core.io.Resource;

import java.io.IOException;

/**
 * @author hmm <a href="http://xiongyingqi.com">xiongyingqi.com</a>
 * @version 2013-9-30 下午4:33:42
 */
public class CommonsMultipartResolver extends
		org.springframework.web.multipart.commons.CommonsMultipartResolver {
	/**
	 * <br>
	 * 2013-9-30 下午4:36:41
	 * 
	 * @see org.springframework.web.multipart.commons.CommonsFileUploadSupport#setUploadTempDir(org.springframework.core.io.Resource)
	 */
	@Override
	public void setUploadTempDir(Resource uploadTempDir) throws IOException {//org.springframework.web.context.support.ServletContextResource
		if (uploadTempDir != null) {
			try {
				while (!uploadTempDir.exists()) {
					uploadTempDir.getFile().mkdirs();
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		super.setUploadTempDir(uploadTempDir);
	}

	//	/**
	//	 * <br>
	//	 * 2013-10-8 下午5:08:27
	//	 * 
	//	 * @see org.springframework.web.multipart.commons.CommonsMultipartResolver#isMultipart(javax.servlet.http.HttpServletRequest)
	//	 */
	//	@Override
	//	public boolean isMultipart(HttpServletRequest request) {
	//		ServletRequestContext ctx = new ServletRequestContext(request);
	//		String contentType = ctx.getContentType();
	//		System.out.println(contentType);
	//		if (contentType == null) {
	//			return false;
	//		}
	//		if (contentType.toLowerCase(Locale.ENGLISH).startsWith(FileUploadBase.MULTIPART)) {
	//			return true;
	//		}
	//		return false;
	////		return true;
	//		//		return super.isMultipart(request);
	//	}

}
