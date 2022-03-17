package com.desafio.docket.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.desafio.docket.model.Certidao;

import reactor.core.publisher.Mono;


@RestController
public class CertidaoService {
	
	@Autowired
	private WebClient webCliente;
	
	public Object buscarTodasCertidoes() {
		
	Mono<Certidao> monoCertidao= this.webCliente
		.method(HttpMethod.GET)
		.uri("/certidoes")
		.retrieve()
		.bodyToMono(Certidao.class);
		
		monoCertidao.block();
		
		List<Certidao> lstCertidao = (List<Certidao>) monoCertidao;
		if (lstCertidao.isEmpty()) {
			return new ArrayList<>();
		}

		return lstCertidao;
	}

}
