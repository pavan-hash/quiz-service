package com.pk.quiz_service_v3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class QuizServiceV3Application {

	public static void main(String[] args) {
		SpringApplication.run(QuizServiceV3Application.class, args);
	}

}
