package com.cyrus.demo.account.web;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cyrus.demo.account.service.DSWService;
import com.cyrus.demo.domain.DataSourceConfig;
import com.cyrus.demo.domain.Role;

@Controller
@RequestMapping(value = "dsw")
public class DSWController {

	@Autowired
	private DSWService dswService;

	@RequestMapping(value = "get/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Role getRoles(@PathVariable Long id) {
		return dswService.getDSW(id);
	}
	
	@RequestMapping(value = "dsc-list")
	@ResponseBody
	public List<DataSourceConfig> getDataSourceConfigs(@PathVariable Long id) {
		return dswService.getDataSourceConfigs(id);
	}
	
	@RequestMapping(value = "get-dsc/{id}")
	@ResponseBody
	public DataSourceConfig getOneDataSourceConfig(@PathVariable Long id) {
		return dswService.getOneDataSourceConfig(id);
	}
	
	@RequestMapping(value = "get-ds/{id}")
	@ResponseBody
	public DataSource getOneDataSource(@PathVariable Long id) {
		return dswService.getOneDataSource(id);
	}
}
