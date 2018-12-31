package com.mason.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

@Component
public class MBean {
	@Autowired
	public MBean(ApplicationArguments args) {
		// TODO Auto-generated constructor stub
		boolean debug = args.containsOption("debug");
		List<String> list = args.getNonOptionArgs();
		list.stream().forEach(System.out::println);
	}
}
