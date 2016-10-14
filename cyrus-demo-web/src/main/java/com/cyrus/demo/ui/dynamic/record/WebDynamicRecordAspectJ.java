package com.cyrus.demo.ui.dynamic.record;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.cyrus.demo.base.dynamic.record.BaseDynamicRecordAspectJ;
import com.cyrus.demo.domain.DynamicRecord;
import com.cyrus.demo.domain.User;

@Aspect
@Component
public class WebDynamicRecordAspectJ extends BaseDynamicRecordAspectJ{

	@After("methodCachePointcut()")
	public void doAfter(JoinPoint joinPoint) throws Throwable {

		System.out.println("AspectJ Start\n");
		
		DynamicRecord record = new DynamicRecord();

		RequestAttributes ra = RequestContextHolder.getRequestAttributes();
		ServletRequestAttributes sra = (ServletRequestAttributes) ra;
		HttpServletRequest request = sra.getRequest();

		String url = request.getRequestURL().toString();
		String method = request.getMethod();
		String uri = request.getRequestURI();
		String queryString = request.getQueryString();

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		String operatedTime = df.format(new Date());

		String operator = null;
		Object obj = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (obj != null && obj instanceof User) {
			operator = ((User) obj).getName();
		}

		String action = joinPoint.getSignature().getName();
		String comment = getMethodRemark(joinPoint);

		record.setAction(action);
		record.setComment(comment);
		record.setOperatedTime(operatedTime);
		record.setOperator(operator);

		System.out.println("Action = " + action);
		System.out.println("Comment = " + comment);
		System.out.println("OperatedTime = " + operatedTime);
		System.out.println("Operator = " + operator);

	}

}
