package com.cyrus.demo.account.service;

import java.util.List;
import javax.sql.DataSource;

import com.cyrus.demo.domain.DataSourceConfig;

/**
 * @Description: 数据源Service类
 *
 * @author wudan
 *
 * @time: 2016年10月19日 下午6:09:25
 *
 */
public interface DataSourceService {

	/**
	 * 得到所有数据源配置信息
	 * 
	 * @return DataSourceConfig的List列表
	 */
	public List<DataSourceConfig> getDataSourceConfigs();

	/**
	 * 根据DB的id查询数据源配置信息
	 * 
	 * @param id
	 *            DB的id
	 * @return DataSourceConfig
	 */
	public DataSourceConfig getOneDataSourceConfig(Long id);

	/**
	 * 获取DataSourceProxy数据源动态类
	 * 
	 * @param id
	 *            DB的id
	 * @return DataSourceProxy数据源动态类可以获取Connection
	 */
	public DataSource getDataSourceProxy(Long id);

}
