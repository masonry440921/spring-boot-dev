package com.mason.externalizedConfig;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SimpleService {
	
	private final ConfigPropertiers propertiers;
	
	@Autowired
	public SimpleService(ConfigPropertiers propertiers) {
		// TODO Auto-generated constructor stub
		this.propertiers = propertiers;
	}
	
	@PostConstruct
	public void openConnection() {
		//Server server = new Server(this.properties.getRemoteAddress());
		// ...
	}
}
