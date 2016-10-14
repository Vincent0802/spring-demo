package com.cyrus.demo.ui.configurer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		/*http
        .authorizeRequests()
            .antMatchers("/", "/demo", "/login").permitAll()
            .anyRequest().authenticated()
            .and()
        .formLogin()
            .loginPage("/demo")
            .defaultSuccessUrl("/home")
            .permitAll()
            .and()
        .logout()
            .permitAll();*/
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		/*auth
			.inMemoryAuthentication()
			.withUser("username")
			.password("password")
			.roles("USER");*/
	}

}
