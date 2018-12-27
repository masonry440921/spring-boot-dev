package com.mason.web;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext;

@SpringBootApplication
public class MasonSpringbootPartivApplication {

	public static void main(String[] args) {
		/*SpringApplication app = new SpringApplication(MasonSpringbootPartivApplication.class);
		
		app.setBannerMode(Banner.Mode.OFF);
		app.run(args);*/	
		//SpringApplication.run(MasonSpringbootPartivApplication.class, args);
	
		new SpringApplicationBuilder().sources(AnnotationConfigServletWebServerApplicationContext.class).child(MasonSpringbootPartivApplication.class).bannerMode(Banner.Mode.OFF).run(args);

	}
	

}

