package com.cyrus.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cyrus.demo.starters.demo.DemoService;

/**
 * @Description: SpringBoot启动类
 *
 * @author wudan
 *
 * @time: 2016年8月23日 上午9:57:19
 *
 */
@SuppressWarnings("deprecation")
@SpringBootApplication
@Controller
public class WebApp {

	@Autowired
	private DemoService demoService;
	
	@RequestMapping(value = { "", "/", "/index"})
	public String index() {
		return "index";
	}

	@RequestMapping("/home")
	public String home() {
		return "home";
	}

	@RequestMapping("/test-json")
	@ResponseBody
	public String testJson() {
//		return demoService.sayDemo();
		throw new RuntimeException("JSON");
	}
	
	@RequestMapping("/test")
	public String test() {
		return demoService.sayDemo(); 
	}

	@RequestMapping("/admin")
	public String helloAdmin() {
		return "admin";
	}

	@RequestMapping("/user")
	public String helloUser() {
		return "user";
	}

	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	@RequestMapping("/demo")
	public String demo() {
		return "demo";
	}

	@RequestMapping("/404.html")
	public String notFound() {
		return "error/404";
	}

	@Bean
	public EmbeddedServletContainerCustomizer containerCustomizer() {
		return new EmbeddedServletContainerCustomizer() {

			@Override
			public void customize(ConfigurableEmbeddedServletContainer container) {
				container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/404.html"));
			}
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(WebApp.class, args);
	}
}
