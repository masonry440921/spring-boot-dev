package com.mason.web;

import java.util.stream.Stream;

import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext;

@SpringBootApplication
public class MasonSpringbootPartivApplication implements CommandLineRunner{

	public static void main(String[] args) {
		/*SpringApplication app = new SpringApplication(MasonSpringbootPartivApplication.class);
		
		app.setBannerMode(Banner.Mode.OFF);
		app.run(args);*/	
		//SpringApplication.run(MasonSpringbootPartivApplication.class, args);
	
		new SpringApplicationBuilder().sources(AnnotationConfigServletWebServerApplicationContext.class).child(MasonSpringbootPartivApplication.class).bannerMode(Banner.Mode.OFF).run(args);

	}

	
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Stream.of(args).forEach(System.out::println);
	}
	
	
}

