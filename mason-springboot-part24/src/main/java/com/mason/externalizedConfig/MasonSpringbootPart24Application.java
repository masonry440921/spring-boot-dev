package com.mason.externalizedConfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(ConfigPropertiers.class)
public class MasonSpringbootPart24Application {

	public static void main(String[] args) {
		SpringApplication.run(MasonSpringbootPart24Application.class, args);
		System.out.println("Started");
	}

}

