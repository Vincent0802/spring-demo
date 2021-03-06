package com.cyrus.demo.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Controller;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@Controller
@EnableCaching
public class AccountApp {
    public static void main( String[] args ) {
    	SpringApplication.run(AccountApp.class, args);
    }
}
