package com.cyrus.demo.base.datasource;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.alibaba.druid.pool.DruidDataSource;

public class DynamicDataSourceContextHolder {

	private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();
	public static List<String> dataSourceIds = new ArrayList<>();

	public static void setDataSourceType(String dataSourceType) {
		contextHolder.set(dataSourceType);
	}

	public static String getDataSourceType() {
		return contextHolder.get();
	}

	public static void clearDataSourceType() {
		contextHolder.remove();
	}

	/**
	 * 判断指定DataSrouce当前是否存在
	 *
	 * @param dataSourceId
	 * @return
	 * @author SHANHY
	 * @create 2016年1月24日
	 */
	public static boolean containsDataSource(String dataSourceId) {
		return dataSourceIds.contains(dataSourceId);
	}

	public static DruidDataSource buildDataSource(Map<String, Object> dsMap) {
		String driverClassName = dsMap.get("driverClassName").toString();
		String url = dsMap.get("url").toString();
		String username = dsMap.get("username").toString();
		String password = dsMap.get("password").toString();
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		return dataSource;
	}

}
