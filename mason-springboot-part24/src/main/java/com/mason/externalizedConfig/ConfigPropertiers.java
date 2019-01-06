package com.mason.externalizedConfig;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@ConfigurationProperties("auth")
@Validated
public class ConfigPropertiers {
	private boolean enabled;
	
	@NotNull
	private InetAddress remoteAddress;

	@Valid
	private final Security security = new Security();

	public boolean isEnabled(){
		return enabled;
	}

	public void setEnabled(boolean enabled) {}

	public InetAddress getRemoteAddress(){
		return remoteAddress;
		
	}

	public void setRemoteAddress(InetAddress remoteAddress) {
		this.remoteAddress = remoteAddress;
	}

	public Security getSecurity(){
		return security;
		
	}

	public static class Security {
		
		@NotEmpty
		private String username;

		private String password;

		private List<String> roles = new ArrayList<>(Collections.singleton("USER"));

		public String getUsername(){
			return password;
			
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
			
		}

		public void setPassword(String password) { }

		public List<String> getRoles(){
			return roles;
			
		}

		public void setRoles(List<String> roles) {}

	}
}
