package com.mason.externalizedConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
@Component
@PropertySource("classpath:application-externalizd.properties")
public class SimpleBean {
	@Value("${name}")
	private String name;

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		System.out.println(name);
		return super.toString();
	}
}
