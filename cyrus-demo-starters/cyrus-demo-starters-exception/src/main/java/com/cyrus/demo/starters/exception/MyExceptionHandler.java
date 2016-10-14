package com.cyrus.demo.starters.exception;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;

import com.cyrus.demo.starters.exception.Error;

/**
 * @Description: 处理不同的错误信息（页面 and json）
 *
 * @author wudan
 *
 * @time: 2016年8月18日 下午6:02:32
 *
 */
@ControllerAdvice
public class MyExceptionHandler {

	/**
	 * 处理错误信息
	 * 
	 * @param request
	 *            请求信息
	 * @param response
	 *            响应信息
	 * @param handlerMethod
	 *            产生错误信息并需处理的方法
	 * @param exception
	 *            错误
	 * @return Error对象 or null
	 * @throws IOException
	 */
	@ExceptionHandler
	@ResponseBody
	public Object doResolveException(HttpServletRequest request, HttpServletResponse response,
			HandlerMethod handlerMethod, Exception exception) throws IOException {
		if (handlerMethod == null) {
			return null;
		}

		Method method = handlerMethod.getMethod();

		if (method == null) {
			return null;
		}

		ResponseBody responseBodyAnn = AnnotationUtils.findAnnotation(method, ResponseBody.class);

		// 处理带ResponseBody的请求
		if (responseBodyAnn != null) {
			Error error = new Error();
			error.setCode(exception.toString());
			error.setMsg(exception.getMessage());
			// error.setValidMsg(handleException(exception));
			return error;
		} else {
			response.sendError(HttpStatus.NOT_FOUND.value());
			return null;
		}

	}

	/**
	 * 获取@valid错误信息
	 * 
	 * @param exception错误
	 * 
	 * @return map对象 or null
	 *
	 */

	public Map<String, String> handleException(Exception exception) {

		BindingResult bindingResult = ((MethodArgumentNotValidException) exception).getBindingResult();
		if (bindingResult.hasErrors()) {
			Map<String, String> map = new HashMap<String, String>();
			for (FieldError error : bindingResult.getFieldErrors()) {
				map.put(error.getField(), error.getField() + " " + error.getDefaultMessage());
			}
			return map;
		}
		return null;
	}

}
