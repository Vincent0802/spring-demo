package com.cyrus.demo.starters.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Description: properties属性的获取
 *
 * @author wudan
 *
 * @time: 2016年9月1日 上午10:22:37
 *
 */
@Component
@ConfigurationProperties(prefix = "demo")
public class DemoServiceProperties {
	
	private static final String MSG = "test1";
	
	private String msg = MSG;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
