package com.cyrus.demo.account.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cyrus.demo.account.service.RoleService;
import com.cyrus.demo.domain.Role;

@Controller
@RequestMapping("role")
public class RoleController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private RoleService roleService;
	
	@RequestMapping(value = "get/{id}" ,method = RequestMethod.GET)
	@ResponseBody
	public Role getByPK(@PathVariable Long id) {
		logger.info("Role ID = " + id);
		return roleService.getByPK(id);
	}
	
	@RequestMapping(value = "get-role" ,method = RequestMethod.POST)
	@ResponseBody
	public Role getRole(@RequestBody Role role) {
		logger.info("Role Name = " + role.getRolename());
		return roleService.getRole(role);
	}
	
	@RequestMapping(value = "add" ,method = RequestMethod.POST)
	@ResponseBody
	public int add(@RequestBody Role role) {
		logger.info("Role Name = " + role.getRolename());
		return roleService.add(role);
	}
	
}
