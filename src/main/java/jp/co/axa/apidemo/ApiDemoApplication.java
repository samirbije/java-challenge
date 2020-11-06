package jp.co.axa.apidemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class ApiDemoApplication {

	
	/** 
	 * The entry point of the spring boot application
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(ApiDemoApplication.class, args);
	}

}
