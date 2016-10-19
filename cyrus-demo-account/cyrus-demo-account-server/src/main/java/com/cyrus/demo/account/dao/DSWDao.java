package com.cyrus.demo.account.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.alibaba.druid.pool.DruidDataSource;
import com.cyrus.demo.base.dao.JdbcTemplateDao;
import com.cyrus.demo.base.datasource.DataSourceProxy;
import com.cyrus.demo.base.datasource.DynamicDataSourceContextHolder;
import com.cyrus.demo.domain.Role;

@Repository
public class DSWDao extends JdbcTemplateDao {

	private final static String DRIVER = "com.mysql.jdbc.Driver";

	private final static String URL = "jdbc:mysql://localhost/cyrus_demo?useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=round";
	
	private final static String URL1 = "jdbc:mysql://localhost/demo1?useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=round";
	
	private final static String URL2 = "jdbc:mysql://localhost/demo2?useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=round";

	private final static String USERNAME = "root";

	private final static String PASSWORD = "root";

	public Role getDSW(Long id) {
		String sql = "SELECT * FROM T_ROLE WHERE ROLEID=" + id;
		Map<String, Object> dsMap = new HashMap<String, Object>();
//		dsMap.put("url", URL);
		dsMap.put("url", URL1);
//		dsMap.put("url", URL2);
		dsMap.put("driverClassName", DRIVER);
		dsMap.put("username", USERNAME);
		dsMap.put("password", PASSWORD);
		DruidDataSource dataSource = DynamicDataSourceContextHolder.buildDataSource(dsMap);
		DataSourceProxy dataSourceProxy = new DataSourceProxy(dataSource);
		return (Role) query(sql, dataSourceProxy);
	}

}
