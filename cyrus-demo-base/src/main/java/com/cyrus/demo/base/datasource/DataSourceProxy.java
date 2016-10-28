package com.cyrus.demo.base.datasource;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;

import com.alibaba.druid.pool.DruidDataSource;
import com.cyrus.demo.domain.DataSourceConfig;

/**
 * @Description: 动态数据源的配置类，根据DataSourceConfig里面的信息创建不同的数据源并获取对应的Connection
 *
 * @author wudan
 *
 * @time: 2016年10月20日 上午9:29:09
 *
 */
public class DataSourceProxy {

	/**
	 * @Description: DEFAULT_TYPE : 默认数据源类型
	 */
	private final static String DEFAULT_DATA_SOURCE_TYPE_NAME = "com.alibaba.druid.pool.DruidDataSource";

	@SuppressWarnings("unused")
	private static final String[] DATA_SOURCE_TYPE_NAMES = new String[] { "org.apache.tomcat.jdbc.pool.DataSource",
			"com.zaxxer.hikari.HikariDataSource", "org.apache.commons.dbcp.BasicDataSource",
			"org.apache.commons.dbcp2.BasicDataSource", "com.alibaba.druid.pool.DruidDataSource" };

	/**
	 * 根据传进来的DataSourceConfig对象的信息创建数据源
	 * 
	 * @param dataSourceConfig
	 *            数据源配置信息
	 * @return DataSource数据源
	 */
	@SuppressWarnings({ "unchecked", "deprecation" })
	public DataSource buildDataSource(DataSourceConfig dataSourceConfig) {
		try {
			String type = dataSourceConfig.getType();
			String driverClassName = dataSourceConfig.getDriver();
			String url = dataSourceConfig.getUrl();
			String username = dataSourceConfig.getUsername();
			String password = dataSourceConfig.getPassword();
			int initialSize = dataSourceConfig.getInitialSize();
			int minIdle = dataSourceConfig.getMinIdle();
			int maxActive = dataSourceConfig.getMaxActive();
			int maxIdle = dataSourceConfig.getMaxIdle();
			int timeBetweenEvictionRunsMillis = dataSourceConfig.getTimeBetweenEvictionRunsMillis();
			String validationQuery = dataSourceConfig.getValidationQuery();
			boolean testWhileIdle = dataSourceConfig.isTestWhileIdle();
			boolean poolPreparedStatements = dataSourceConfig.isPoolPreparedStatements();
			int maxPoolPreparedStatementPerConnectionSize = dataSourceConfig
					.getMaxPoolPreparedStatementPerConnectionSize();

			if (type == null)
				type = DEFAULT_DATA_SOURCE_TYPE_NAME;// 默认DataSource

			Class<? extends DataSource> dataSourceType;
			dataSourceType = (Class<? extends DataSource>) Class.forName((String) type);

			DataSourceBuilder factory = DataSourceBuilder.create().driverClassName(driverClassName).url(url)
					.username(username).password(password).type(dataSourceType);
			String name = dataSourceType.getName();
			if ("org.apache.tomcat.jdbc.pool.DataSource".equals(name)) {
				org.apache.tomcat.jdbc.pool.DataSource tdataSource = (org.apache.tomcat.jdbc.pool.DataSource) factory
						.build();
				tdataSource.setInitialSize(initialSize);
				tdataSource.setMinIdle(minIdle);
				tdataSource.setMaxActive(maxActive);
				tdataSource.setMaxIdle(maxIdle);
				tdataSource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
				tdataSource.setValidationQuery(validationQuery);
				tdataSource.setTestWhileIdle(testWhileIdle);
				return tdataSource;
			} else if ("com.zaxxer.hikari.HikariDataSource".equals(name)) {
				com.zaxxer.hikari.HikariDataSource hdataSource = (com.zaxxer.hikari.HikariDataSource) factory.build();
				return hdataSource;
			} else if ("org.apache.commons.dbcp.BasicDataSource".equals(name)) {
				org.apache.commons.dbcp.BasicDataSource bdataSource = (org.apache.commons.dbcp.BasicDataSource) factory
						.build();
				bdataSource.setInitialSize(initialSize);
				bdataSource.setMinIdle(minIdle);
				bdataSource.setMaxActive(maxActive);
				bdataSource.setMaxIdle(maxIdle);
				bdataSource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
				bdataSource.setValidationQuery(validationQuery);
				bdataSource.setTestWhileIdle(testWhileIdle);
				bdataSource.setPoolPreparedStatements(poolPreparedStatements);
				return bdataSource;
			} else if ("org.apache.commons.dbcp2.BasicDataSource".equals(name)) {
				org.apache.commons.dbcp2.BasicDataSource b2dataSource = (org.apache.commons.dbcp2.BasicDataSource) factory
						.build();
				b2dataSource.setInitialSize(initialSize);
				b2dataSource.setMinIdle(minIdle);
				b2dataSource.setMaxIdle(maxIdle);
				b2dataSource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
				b2dataSource.setValidationQuery(validationQuery);
				b2dataSource.setTestWhileIdle(testWhileIdle);
				b2dataSource.setPoolPreparedStatements(poolPreparedStatements);
				return b2dataSource;
			} else {
				com.alibaba.druid.pool.DruidDataSource ddataSource = (DruidDataSource) factory.build();
				ddataSource.setInitialSize(initialSize);
				ddataSource.setMinIdle(minIdle);
				ddataSource.setMaxIdle(maxIdle);
				ddataSource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
				ddataSource.setValidationQuery(validationQuery);
				ddataSource.setTestWhileIdle(testWhileIdle);
				ddataSource.setPoolPreparedStatements(poolPreparedStatements);
				ddataSource.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);
				return ddataSource;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

}
