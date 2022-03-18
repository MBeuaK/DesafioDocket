package com.desafio.docket.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.desafio.docket.model.Certidao;

@FeignClient(value="certidoes",url ="https://docketdesafiobackend.herokuapp.com/api/v1/certidoes")
public interface JSONPlaceHolderClient {
	
	@RequestMapping(method = RequestMethod.GET, value = "/")
    List<Certidao> buscarTodasCertidoes();
	
	@RequestMapping(method = RequestMethod.GET, value="/{id}")
	Certidao getCertidaoById(@PathVariable("id") long id);

}
