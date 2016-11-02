package com.cyrus.demo.account.dao;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import com.cyrus.demo.base.dao.JdbcTemplateDao;
import com.cyrus.demo.base.datasource.DataSourceProxy;
import com.cyrus.demo.base.datasource.DynamicDataSourceContextHolder;
import com.cyrus.demo.domain.Role;

@Repository
public class DSWDao extends JdbcTemplateDao {

	private final static String TYPE = "com.alibaba.druid.pool.DruidDataSource";

	private final static String TYPE1 = "org.apache.tomcat.jdbc.pool.DataSource";

	private final static String TYPE2 = "com.zaxxer.hikari.HikariDataSource";

	private final static String TYPE3 = "org.apache.commons.dbcp.BasicDataSource";

	private final static String TYPE4 = "org.apache.commons.dbcp2.BasicDataSource";

	private final static String DRIVER = "com.mysql.jdbc.Driver";

	private final static String DRIVER1 = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

	private final static String DRIVER2 = "oracle.jdbc.driver.OracleDriver";

	private final static String DRIVER3 = "org.apache.hive.jdbc.HiveDriver";

	private final static String URL = "jdbc:mysql://localhost/cyrus_demo?useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=round";

	private final static String URL1 = "jdbc:mysql://localhost/demo1?useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=round";

	private final static String URL2 = "jdbc:mysql://localhost/demo2?useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=round";

	private final static String USERNAME = "root";

	private final static String PASSWORD = "root";

	public Role getDSW(Long id) {

		String sql = "SELECT * FROM T_ROLE WHERE ROLEID=" + id;
		Map<String, Object> dsMap = new HashMap<String, Object>();
		dsMap.put("type", TYPE);
		dsMap.put("url", URL);
		// dsMap.put("url", "jdbc:hive2://172.31.238.138:10000/sg_dw");
		// dsMap.put("url", URL2);
		dsMap.put("driverClassName", DRIVER);
		dsMap.put("username", USERNAME);
		dsMap.put("password", PASSWORD);
		DataSource dataSource = DynamicDataSourceContextHolder.buildDataSource(dsMap);
		// DataSourceProxy dataSourceProxy = new DataSourceProxy(dataSource);
		return (Role) query(sql, dataSource);
	}

}
