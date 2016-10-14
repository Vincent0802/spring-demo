package com.cyrus.demo.ui.web;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cyrus.demo.account.api.service.RoleService;
import com.cyrus.demo.account.api.service.UserService;
import com.cyrus.demo.base.annotation.MethodLog;
import com.cyrus.demo.domain.Role;
import com.cyrus.demo.domain.User;
import com.cyrus.demo.ui.resolver.CustomerDate;

@Controller
@RequestMapping("account")
public class AccountController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;

	@RequestMapping(value = "get-date")
	@ResponseBody
	public Date getDate(@CustomerDate(value = "date") Date date) {
		logger.info("Date = " + date);
		return date;
	}
	
	@RequestMapping(value = "user/get/{id}", method = RequestMethod.GET)
	@ResponseBody
	@MethodLog(remark = "查看用户")
	public User getByPK(@PathVariable Long id) {
		return userService.getByPK(id);
	}

	@RequestMapping( value = "user/get-user", method = RequestMethod.POST)
	@ResponseBody
	public User getUser(@RequestBody User user) {
		/*User user =new User();
		user.setName(name);
		user.setPassword(password);*/
		return userService.getNyName(user);
	}
	
	@RequestMapping( value = "user/login", method = RequestMethod.POST)
	@ResponseBody
	public int login(@RequestBody User user) {
		String password = userService.getNyName(user).getPassword();
		if(password.equals(user.getPassword())) {
			return 1;
		} else {
			return 0;
		}
	}
	
	@RequestMapping(value = "user/add" ,method = RequestMethod.POST)
	@ResponseBody
	public int add(@RequestBody User user) {
		logger.info("User Name = " + user.getName());
		return userService.add(user);
	}
	
	@RequestMapping(value = "role/get/{id}", method = RequestMethod.GET)
	@ResponseBody
	@MethodLog(remark = "查看角色")
	public Role getRoleByPK(@PathVariable Long id) {
		return roleService.getByPK(id);
	}
	
	@RequestMapping( value = "role/get-role", method = RequestMethod.POST)
	@ResponseBody
	public Role getRole(@RequestBody Role role) {
		return roleService.getRole(role);
	}
	
	@RequestMapping(value = "role/add" ,method = RequestMethod.POST)
	@ResponseBody
	public int addRole(@RequestBody Role role) {
		logger.info("Role Name = " + role.getRolename());
		return roleService.add(role);
	}
	
}
