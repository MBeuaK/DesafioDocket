package com.desafio.docket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DocketApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(DocketApplication.class, args);
	}

}
