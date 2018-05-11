package com;
/**
 * 
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author zhailiang
 *
 */
@SpringBootApplication
@EnableAsync
@EnableScheduling
public class ToqueAdminApplication {
	
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(ToqueAdminApplication.class);
		app.setAdditionalProfiles(args[0]);
		app.run(args);
	}

}