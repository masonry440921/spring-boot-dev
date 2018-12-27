If no failure analyzers are able to handle the exception, you can still display the full conditions report to better understand what went wrong. To do so, you need to enable the debug property or enable DEBUG logging for ```org.springframework.boot.autoconfigure.logging.ConditionEvaluationReportLoggingListener```.


####Customizing the Banner

 If the file has an encoding other than UTF-8, you can set spring.banner.charset. In addition to a text file, you can also add a banner.gif, banner.jpg, or banner.png image file to your classpath or set the spring.banner.image.location property. Images are converted into an ASCII art representation and printed above any text banner..

###Customizing SpringApplication

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(MySpringConfiguration.class);
		app.setBannerMode(Banner.Mode.OFF);
		app.run(args);
	}

###Fluent Builder API

There are some restrictions when creating an ApplicationContext hierarchy. For example, Web components must be contained within the child context, and the same Environment is used for both parent and child contexts. See the SpringApplicationBuilder Javadoc for full details.