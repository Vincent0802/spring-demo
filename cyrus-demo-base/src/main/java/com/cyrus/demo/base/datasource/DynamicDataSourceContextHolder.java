package com.cyrus.demo.base.datasource;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;

import com.alibaba.druid.pool.DruidDataSource;

public class DynamicDataSourceContextHolder {

	private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();

	@SuppressWarnings("unused")
	private static final String[] DATA_SOURCE_TYPE_NAMES = new String[] { "org.apache.tomcat.jdbc.pool.DataSource",
			"com.zaxxer.hikari.HikariDataSource", "org.apache.commons.dbcp.BasicDataSource",
			"org.apache.commons.dbcp2.BasicDataSource", "com.alibaba.druid.pool.DruidDataSource" };

	public static List<String> dataSourceIds = new ArrayList<String>();

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

	@SuppressWarnings("unchecked")
	public static DataSource buildDataSource(Map<String, Object> dsMap) {
		try {
			Object type = dsMap.get("type");
			String driverClassName = dsMap.get("driverClassName").toString();
			String url = dsMap.get("url").toString();
			String username = dsMap.get("username").toString();
			String password = dsMap.get("password").toString();

			if (type == null)
				type = "com.alibaba.druid.pool.DruidDataSource";// 默认DataSource

			Class<? extends DataSource> dataSourceType;
			dataSourceType = (Class<? extends DataSource>) Class.forName((String) type);

			DataSourceBuilder factory = DataSourceBuilder.create().driverClassName(driverClassName).url(url)
					.username(username).password(password).type(dataSourceType);
			String name = dataSourceType.getName();
			if ("org.apache.tomcat.jdbc.pool.DataSource".equals(name)) {
				org.apache.tomcat.jdbc.pool.DataSource tdataSource = (org.apache.tomcat.jdbc.pool.DataSource) factory
						.build();
				return tdataSource;
			} else if ("com.zaxxer.hikari.HikariDataSource".equals(name)) {
				com.zaxxer.hikari.HikariDataSource hdataSource = (com.zaxxer.hikari.HikariDataSource) factory.build();
				return hdataSource;
			} else if ("org.apache.commons.dbcp.BasicDataSource".equals(name)) {
				org.apache.commons.dbcp.BasicDataSource bdataSource = (org.apache.commons.dbcp.BasicDataSource) factory
						.build();
				return bdataSource;
			} else if ("org.apache.commons.dbcp2.BasicDataSource".equals(name)) {
				org.apache.commons.dbcp2.BasicDataSource b2dataSource = (org.apache.commons.dbcp2.BasicDataSource) factory
						.build();
				return b2dataSource;
			} else {
				com.alibaba.druid.pool.DruidDataSource ddataSource = (DruidDataSource) factory.build();
				return ddataSource;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

}
