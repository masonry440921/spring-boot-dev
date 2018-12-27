package com.mason;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class WebApplication {
	
	@RequestMapping("/")
	String home() {
		return "hello world";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(WebApplication.class, args);
	}

}

