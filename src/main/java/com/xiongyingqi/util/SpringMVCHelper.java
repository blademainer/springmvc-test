/**
 * YIXUN_1.5_EE
 */
package com.xiongyingqi.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kingray.vo.CodeVo;
import com.kingray.web.exception.ValidateException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.reflect.Method;
import java.util.*;

import static com.xiongyingqi.util.EntityHelper.print;

/**
 * @author 瑛琪 <a href="http://xiongyingqi.com">xiongyingqi.com</a>
 * @version 2013-10-17 下午12:19:48
 */
public class SpringMVCHelper {
	/**
	 * 获取包下所有被Controller注解的类所表示的路径 <br>
	 * 2013-10-17 下午1:02:45
	 * 
	 * @param pkg
	 * @return
	 */
	public static Collection<String> getAnnotationMappedPaths(Package pkg) {
		if (pkg == null) {
			return null;
		}
		Collection<String> rs = new LinkedHashSet<String>();
		Set<Class<?>> classes = PackageUtil.getclass(pkg);
		for (Iterator iterator = classes.iterator(); iterator.hasNext();) {
			Class<?> clazz = (Class<?>) iterator.next();
			if (clazz.isAnnotationPresent(Controller.class)) {
				String[] clazzPaths = null;
				if (clazz.isAnnotationPresent(RequestMapping.class)) {
					RequestMapping typeMapping = clazz.getAnnotation(RequestMapping.class);
					clazzPaths = typeMapping.value();
				}

				String[] methodPaths = null;
				Collection<String> methodPathCollection = new ArrayList<String>();
				Method[] methods = clazz.getDeclaredMethods();
				for (int i = 0; i < methods.length; i++) {
					Method method = methods[i];
					if (method.isAnnotationPresent(RequestMapping.class)) {
						RequestMapping typeMapping = method.getAnnotation(RequestMapping.class);
						String[] methodPathsVar = typeMapping.value();
						Collections.addAll(methodPathCollection, methodPathsVar);
					}
				}
				if (methodPathCollection.size() > 0) {
					methodPaths = methodPathCollection.toArray(new String[] {});
				}

				if (clazzPaths != null && clazzPaths.length > 0 && methodPaths != null
						&& methodPaths.length > 0) {
					for (int i = 0; i < clazzPaths.length; i++) {
						String typePath = clazzPaths[i];
						typePath = checkForPath(typePath);
						for (int j = 0; j < methodPaths.length; j++) {
							String methodPath = methodPaths[j];
							methodPath = checkForPath(methodPath);
							String mappedPath = typePath + methodPath;
							rs.add(mappedPath);
						}
					}
				} else if ((clazzPaths != null && clazzPaths.length > 0)
						&& (methodPaths == null || methodPaths.length == 0)) {
					for (int i = 0; i < clazzPaths.length; i++) {
						String typePath = clazzPaths[i];
						typePath = checkForPath(typePath);
						rs.add(typePath);
					}
				} else if ((methodPaths != null && methodPaths.length > 0)
						&& (clazzPaths == null || clazzPaths.length == 0)) {
                    print(methodPaths);
                    for (int i = 0; i < clazzPaths.length; i++) {
						String typePath = clazzPaths[i];
						typePath = checkForPath(typePath);
						rs.add(typePath);
					}
				}
			}
		}
		return rs;
	}

	private static String checkForPath(String path) {
		if (!path.startsWith("/")) {
			path = "/" + path;
		}
		if (path.endsWith("/")) {
			path = path.substring(0, path.length() - 1);
		}
		return path;
	}

	/**
	 * 检查客户端的输入是否正确，如果错误，则抛出异常信息(JSON格式) <br>
	 * 2013-10-17 下午3:02:53
	 * 
	 * @param bindingResult
	 * @throws com.kingray.web.exception.ValidateException
	 */
	public static void assertBindingResult(BindingResult bindingResult) throws ValidateException {
		if (bindingResult.hasErrors()) {
			ObjectMapper mapper = new ObjectMapper();
			try {
				String s = mapper.writeValueAsString(builderBindingResult(bindingResult));
				throw new ValidateException(s);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 检查客户端的输入是否正确，如果正确则返回null，如果错误，则返回拼接的字符串 <br>
	 * 2013-10-17 下午3:02:53
	 * 
	 * @param bindingResult
	 * @return
	 */
	public static CodeVo builderBindingResult(BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			CodeVo codeVo = CodeVo.BEAN_VALIDATE_ERROR;
			Collection<CodeVo> errorCodes = new ArrayList<CodeVo>();
			List<ObjectError> errors = bindingResult.getAllErrors();
			for (Iterator iterator = errors.iterator(); iterator.hasNext();) {
				ObjectError objectError = (ObjectError) iterator.next();
				if(objectError instanceof FieldError){
					FieldError fieldError = (FieldError) objectError;
					//"Field error in object \'" + this.getObjectName() + "\' on field \'" + this.field + "\': rejected value [" + this.rejectedValue + "]; " + this.resolvableToString();
					//Field error in object 'PUser' on field 'userName': rejected value [1]; codes [Pattern.PUser.userName,Pattern.userName,Pattern.java.lang.String,Pattern]; arguments [org.springframework.context.support.DefaultMessageSourceResolvable: codes [PUser.userName,userName]; arguments []; default message [userName],[Ljavax.validation.constraints.Pattern$Flag;@a544ff1,^[a-zA-Z]\w{2,}]; default message [用户名必须以字母开头，并且必须大于3个字符]
					CodeVo errorCodeVo = CodeVo.BEAN_VALIDATE_ERROR.clone();
					String objectName = fieldError.getObjectName();
					String field = fieldError.getField();
					String defaultMessage = fieldError.getDefaultMessage();
					errorCodeVo.setResultName(objectName);
					errorCodeVo.setResultValue(field);
					errorCodeVo.setResultReason(defaultMessage);
					errorCodes.add(errorCodeVo);
				}
//				print(objectError);
//				CodeVo erroCodeVo = new BindingResultErroCode(0, objectError.getObjectName(),
//						objectError.getCode(), objectError.getDefaultMessage());
//				erroCodes.add(erroCodeVo);
			}
			codeVo.setResultObject(errorCodes);
			return codeVo;
		}
		return null;
	}

}
