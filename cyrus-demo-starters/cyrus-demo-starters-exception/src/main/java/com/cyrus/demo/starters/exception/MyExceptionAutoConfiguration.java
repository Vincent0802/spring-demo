package com.cyrus.demo.starters.exception;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(MyExceptionProperties.class)//根据DemoServiceProperties提供参数
@ConditionalOnClass(MyExceptionHandler.class)//判断DemoService，是否存在
@ConditionalOnProperty(prefix = "", value = "enabled", matchIfMissing = true)
public class MyExceptionAutoConfiguration {

	@Bean
	@ConditionalOnMissingBean
	public MyExceptionHandler myExceptionHandler() {
		return new MyExceptionHandler();
	}
}
