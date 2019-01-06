Spring Boot lets you externalize your configuration so that you can work with the same application code in different environments. You can use properties files, YAML files, environment variables, and command-line arguments to externalize configuration. Property values can be injected directly into your beans by using the ```@Value ``` annotation, accessed through Spring’s Environment abstraction, or be bound to structured objects through ```@ConfigurationProperties```.

**Spring Boot uses a very particular PropertySource order that is designed to allow sensible overriding of values.**

The ```RandomValuePropertySource``` is useful for injecting random values (for example, into secrets or test cases). It can produce integers, longs, uuids, or strings, as shown in the following 

	my.bignumber=${random.long}
	my.uuid=${random.uuid}
	my.number.less.than.ten=${random.int(10)}
	my.number.in.range=${random.int[1024,65536]}

In addition to ```application.properties``` files, profile-specific properties can also be defined by using the following naming convention: ```application-{profile}.properties```.

Spring Boot does not provide any built in support for encrypting property values, however, it does provide the hook points necessary to modify values contained in the Spring Environment. The EnvironmentPostProcessor interface allows you to manipulate the Environment before the application starts. 


###	Type-safe Configuration Properties	
	@ConfigurationProperties("acme")
	public class AcmeProperties {

		private boolean enabled;
	
		private InetAddress remoteAddress;
	
		private final Security security = new Security();
	
		public boolean isEnabled() { ... }
	
		public void setEnabled(boolean enabled) { ... }
	
		public InetAddress getRemoteAddress() { ... }
	
		public void setRemoteAddress(InetAddress remoteAddress) { ... }
	
		public Security getSecurity() { ... }
	
		public static class Security {
	
			private String username;
	
			private String password;
	
			private List<String> roles = new ArrayList<>(Collections.singleton("USER"));
	
			public String getUsername() { ... }
	
			public void setUsername(String username) { ... }
	
			public String getPassword() { ... }
	
			public void setPassword(String password) { ... }
	
			public List<String> getRoles() { ... }
	
			public void setRoles(List<String> roles) { ... }
	
		}
	}


Getters and setters are usually mandatory, since binding is through standard Java Beans property descriptors, just like in Spring MVC. A setter may be omitted in the following cases:

  - Maps, as long as they are initialized, need a getter but not necessarily a setter, since they can be mutated by the binder.
  - Collections and arrays can be accessed either through an index (typically with YAML) or by using a single comma-separated value (properties). In the latter case, a setter is mandatory. We recommend to always add a setter for such types. If you initialize a collection, make sure it is not immutable (as in the preceding example).
  - If nested POJO properties are initialized (like the Security field in the preceding example), a setter is not required. If you want the binder to create the instance on the fly by using its default constructor, you need a setter.

Some people use Project Lombok to add getters and setters automatically. Make sure that Lombok does not generate any particular constructor for such a type, as it is used automatically by the container to instantiate the object.

Finally, only standard Java Bean properties are considered and binding on static properties is not supported.

You also need to list the properties classes to register in the @EnableConfigurationProperties annotation, as shown in the following

As well as using @ConfigurationProperties to annotate a class, you can also use it on public @Bean methods. Doing so can be particularly useful when you want to bind properties to third-party components that are outside of your control.

**We recommend that, when possible, properties are stored in lower-case kebab format, such as ```my.property-name=acme```.**

You can also add a custom Spring Validator by creating a bean definition called configurationPropertiesValidator. The @Bean method should be declared static. The configuration properties validator is created very early in the application’s lifecycle, and declaring the @Bean method as static lets the bean be created without having to instantiate the @Configuration class. Doing so avoids any problems that may be caused by early instantiation. There is a property validation sample that shows how to set things up.