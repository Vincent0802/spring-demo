package com.cyrus.demo.starters.host.trusted;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Description: HostTrusted拦截器配置类
 *
 * @author wudan
 *
 * @time: 2016年9月2日 上午10:00:45
 *
 */
@Configuration
public class HostTrustedWebAppConfigurer extends WebMvcConfigurerAdapter {

	@Autowired
	private HostTrustedProperties hostTrustedProperties;

	@Autowired
	HostTrustedHandlerInterceptor hostTrustedHandlerInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(hostTrustedHandlerInterceptor).addPathPatterns(hostTrustedProperties.getPathPatterns())
				.excludePathPatterns(hostTrustedProperties.getExcludePathPatterns());
	}

}
