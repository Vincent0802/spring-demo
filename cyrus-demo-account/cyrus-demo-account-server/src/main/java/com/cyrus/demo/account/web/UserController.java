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

import com.cyrus.demo.account.service.UserService;
import com.cyrus.demo.domain.User;

@Controller
@RequestMapping("user")
public class UserController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "get/{id}" ,method = RequestMethod.GET)
	@ResponseBody
	public User getByPK(@PathVariable Long id) {
		logger.info("User ID = " + id);
		return userService.getByPK(id);
	}
	
	@RequestMapping(value = "get-user" ,method = RequestMethod.POST)
	@ResponseBody
	public User getUser(@RequestBody User user) {
		logger.info("User Name = " + user.getName());
		return userService.getNyName(user.getName());
	}
	
	@RequestMapping(value = "add" ,method = RequestMethod.POST)
	@ResponseBody
	public int add(@RequestBody User user) {
		logger.info("User Name = " + user.getName());
		return userService.add(user);
	}
}
