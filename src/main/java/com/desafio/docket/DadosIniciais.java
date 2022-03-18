package com.desafio.docket;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.desafio.docket.model.Cartorio;
import com.desafio.docket.model.Certidao;
import com.desafio.docket.repository.CartorioRepository;

@Component
@Transactional
public class DadosIniciais implements CommandLineRunner{

	@Autowired
	CartorioRepository cartorioRepository;
	
	@Override
	public void run(String... args) throws Exception {
		Certidao certidao= new Certidao(345L, "Cartorio Teste");

		Cartorio c1 = new Cartorio("Cartorio teste");
		c1.setEndereco("Rua das Laranjeiras");
		c1.setId(1L);
		c1.setCertidao(certidao);
		cartorioRepository.save(c1);
		
	}

}
