package com.desafio.docket.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.docket.client.JSONPlaceHolderClient;
import com.desafio.docket.model.Certidao;

@Service
public class CertidaoService {
	
	@Autowired
	private JSONPlaceHolderClient client;
	
	public Object buscarTodasCertidoes() {
		
		List<Certidao> lstCertidao =this.client.buscarTodasCertidoes();
		if (lstCertidao.isEmpty()) {
			return new ArrayList<>();
		}

		return lstCertidao;
	}

}
