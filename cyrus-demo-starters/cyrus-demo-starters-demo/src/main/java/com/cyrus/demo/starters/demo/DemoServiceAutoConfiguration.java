package com.cyrus.demo.starters.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description: 自动配置类
 *
 * @author wudan
 *
 * @time: 2016年9月1日 上午10:23:53
 *
 */
@Configuration
@EnableConfigurationProperties(DemoServiceProperties.class)//根据DemoServiceProperties提供参数
@ConditionalOnClass(DemoService.class)//判断DemoService，是否存在
@ConditionalOnProperty(prefix = "demo", value = "enabled", matchIfMissing = true)
public class DemoServiceAutoConfiguration {

	@Autowired
	private DemoServiceProperties demoServiceProperties;
	
	@Bean
	@ConditionalOnMissingBean
	public DemoService demoService() {//DemoService若不存在，自动配置
		DemoService demoService = new DemoService();
		demoService.setMsg(demoServiceProperties.getMsg());
		return demoService;
	}
}
