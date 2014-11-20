/**
 * YIXUN_1.5_EE
 */
package com.kingray.spring.http.convert;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.beans.PropertyEditorSupport;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.xiongyingqi.util.EntityHelper.print;

/**
 * 
 * spring3 mvc 的日期传递[前台-后台]bug: org.springframework.validation.BindException
 * 的解决方式.包括xml的配置
 * 
 * @author hmm
 * 
 */
public class DateConverter {

	@InitBinder
	public void binder(WebDataBinder binder) {
		print("binder");
		// DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//		CustomDateEditor dateEditor = new CustomDateEditor(format, true);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));   //true:允许输入空值，false:不能为空值

		String dateFormatShortStr = "yyyy-MM-dd";
		SimpleDateFormat dateFormat2 = new SimpleDateFormat(dateFormatShortStr);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat2, true));   //true:允许输入空值，false:不能为空值
//		binder.registerCustomEditor(Date.class, new MyDateEditor());   //true:允许输入空值，false:不能为空值
	}


	public class MyDateEditor extends PropertyEditorSupport {

		private final String dateFormatShortStr = "yyyy-MM-dd";
		private final String dateFormatStr = "yyyy-MM-dd HH:mm:ss";

		private final DateFormat dateFormatShort = new SimpleDateFormat(dateFormatShortStr);
		private final DateFormat dateFormat = new SimpleDateFormat(dateFormatStr);

		private final boolean allowEmpty;

		private final int exactDateLength;

		public MyDateEditor() {
			allowEmpty = true;
			exactDateLength = -1;
		}

		//		public MyDateEditor(DateFormat dateFormat, boolean allowEmpty) {
		//			this.allowEmpty = allowEmpty;
		//			this.exactDateLength = -1;
		//		}
		//
		//		public MyDateEditor(DateFormat dateFormat, boolean allowEmpty,
		//				int exactDateLength) {
		//			this.allowEmpty = allowEmpty;
		//			this.exactDateLength = exactDateLength;
		//		}

		/**
		 * Parse the Date from the given text, using the specified DateFormat.
		 */
		@Override
		public void setAsText(String text) throws IllegalArgumentException {
			if (this.allowEmpty && !StringUtils.hasText(text)) {
				// Treat empty String as null value.
				setValue(null);
			} else if (text != null && this.exactDateLength >= 0
					&& text.length() != this.exactDateLength) {
				throw new IllegalArgumentException("Could not parse date: it is not exactly"
						+ this.exactDateLength + "characters long");
			} else {
				int length = text.length();
				try {
					if (length <= dateFormatShortStr.length()) {
						setValue(dateFormatShort.parse(text));
					} else {
						setValue(dateFormat.parse(text));
					}

				} catch (ParseException ex) {
					throw new IllegalArgumentException("Could not parse date: " + ex.getMessage(),
							ex);
				}
			}
		}

		/**
		 * Format the Date as String, using the specified DateFormat.
		 */
		@Override
		public String getAsText() {
			Date value = (Date) getValue();
			return (value != null ? this.dateFormat.format(value) : "");
		}

	}

}
