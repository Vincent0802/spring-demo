package com.cyrus.demo.starters.host.trusted;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description: HostTrusted自动配置类
 *
 * @author wudan
 *
 * @time: 2016年9月1日 上午10:23:53
 *
 */
@Configuration
@EnableConfigurationProperties(HostTrustedProperties.class)
@ConditionalOnClass(HostTrustedHandlerInterceptor.class)
@ConditionalOnProperty(prefix = "service", value = "enabled", matchIfMissing = true)
public class HostTrustedAutoConfiguration {

	@Autowired
	private HostTrustedProperties hostTrustedProperties;

	@Bean
	@ConditionalOnMissingBean
	public HostTrustedHandlerInterceptor hostTrustedHandlerInterceptor() {
		String hosts = hostTrustedProperties.getTrusted();
		HostTrustedHandlerInterceptor hostTrustedHandlerInterceptor = new HostTrustedHandlerInterceptor(hosts);
		return hostTrustedHandlerInterceptor;
	}
}
