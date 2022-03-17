package com.desafio.docket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EntityScan(basePackages = "com.desafio.docket.model")
@ComponentScan(basePackages = {"com.*"})
public class DocketApplication {
	
	@Bean
	public WebClient webClient(WebClient.Builder builder) {
		return builder
				.baseUrl("https://docketdesafiobackend.herokuapp.com/api/v1")
					.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
					.build();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(DocketApplication.class, args);
	}

}
