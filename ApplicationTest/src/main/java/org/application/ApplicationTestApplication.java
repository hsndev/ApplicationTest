package org.application;

import org.application.model.Message;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApplicationTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationTestApplication.class, args);
	}
	
	@Bean
	public Message message() {
		return new Message();
	}

}

