package com.cyrus.demo.base.dynamic.record;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Pointcut;

import com.cyrus.demo.base.annotation.MethodLog;

public class BaseDynamicRecordAspectJ {

	// @Pointcut(value = "execution(public *
	// com.szu.insight.*.service.*.*(..))")
	@Pointcut("@annotation(com.cyrus.demo.base.annotation.MethodLog)")
	public void methodCachePointcut() {

	}

	/**
	 * 获取方法的中文备注____用于记录用户的操作日志描述
	 * 
	 * @param joinPoint
	 * @return 方法的中文备注
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public static String getMethodRemark(JoinPoint joinPoint) throws Exception {
		String targetName = joinPoint.getTarget().getClass().getName();
		String methodName = joinPoint.getSignature().getName();
		Object[] arguments = joinPoint.getArgs();

		Class targetClass = Class.forName(targetName);
		Method[] method = targetClass.getMethods();
		String methode = "";
		for (Method m : method) {
			if (m.getName().equals(methodName)) {
				Class[] tmpCs = m.getParameterTypes();
				if (tmpCs.length == arguments.length) {
					MethodLog methodCache = m.getAnnotation(MethodLog.class);
					methode = methodCache.remark();
					break;
				}
			}
		}
		return methode;
	}

}
