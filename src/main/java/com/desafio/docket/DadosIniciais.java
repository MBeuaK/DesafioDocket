package com.desafio.docket;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.desafio.docket.client.JSONPlaceHolderClient;
import com.desafio.docket.model.Cartorio;
import com.desafio.docket.model.Certidao;
import com.desafio.docket.repository.CartorioRepository;

@Component
@Transactional
public class DadosIniciais implements CommandLineRunner{

	@Autowired
	CartorioRepository cartorioRepository;
	
	@Autowired
	JSONPlaceHolderClient client;
	
	@Override
	public void run(String... args) throws Exception {
		List<Certidao> certidoes= new ArrayList<>();
		certidoes = client.buscarTodasCertidoes();
		
		Cartorio c1 = new Cartorio("Cartorio teste");
		c1.setEndereco("Rua das Laranjeiras");
		c1.setId(1L);
		c1.setCertidoes(certidoes);
		certidoes.forEach(i->i.setCartorio(c1));
		cartorioRepository.save(c1);
	}

}
