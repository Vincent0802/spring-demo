package com.cyrus.demo.ui.resolver;

import java.lang.annotation.Annotation;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

public class CustomerHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {

	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
			NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {

		Annotation[] methodAnnotations = parameter.getParameterAnnotations();
		for (Annotation annotation : methodAnnotations) {
			if (annotation instanceof CustomerDate) {
				CustomerDate customerDate = (CustomerDate) annotation;
				String dataStringValue = customerDate.value();
				SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm");
				return formater.parse(dataStringValue);
			}
		}
		return null;
	}

	@Override
	@SuppressWarnings("rawtypes")
	public boolean supportsParameter(MethodParameter parameter) {
		Class parameterType = parameter.getParameterType();
		return parameterType.equals(Date.class);
	}

}