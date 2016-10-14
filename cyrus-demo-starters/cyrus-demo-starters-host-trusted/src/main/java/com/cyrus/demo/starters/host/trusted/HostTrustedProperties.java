package com.cyrus.demo.starters.host.trusted;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Description: HostTrusted的properties属性的获取
 *
 * @author wudan
 *
 * @time: 2016年9月1日 上午10:22:37
 *
 */
@ConfigurationProperties(prefix = "service")
public class HostTrustedProperties {

	private static final String TRUSTED = "127.0.0.1";

	private static final String[] PATHPATTERNS = { "/**" };

	private static final String[] EXCLUDEPATHPATTERNS = { "/js/**", "/css/**", "/images/**", "/favicon.ico" };

	private String trusted = TRUSTED;

	private String[] pathPatterns = PATHPATTERNS;

	private String[] excludePathPatterns = EXCLUDEPATHPATTERNS;

	public String getTrusted() {
		return trusted;
	}

	public void setTrusted(String trusted) {
		this.trusted = trusted;
	}

	public String[] getPathPatterns() {
		return pathPatterns;
	}

	public void setPathPatterns(String[] pathPatterns) {
		this.pathPatterns = pathPatterns;
	}

	public String[] getExcludePathPatterns() {
		return excludePathPatterns;
	}

	public void setExcludePathPatterns(String[] excludePathPatterns) {
		this.excludePathPatterns = excludePathPatterns;
	}

}
