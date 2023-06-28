package com.example.Async_Proj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class AsyncProjApplication {

	public static void main(String[] args) {
		SpringApplication.run(AsyncProjApplication.class, args);
	}

}
