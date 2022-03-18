package com.desafio.docket.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.docket.model.dto.BaseResponseDTO;
import com.desafio.docket.service.CertidaoService;
import com.desafio.docket.util.MensagemUtil;

@RestController
@RequestMapping("/api/v1/certidao")
public class CertidaoController extends BaseController{
	private final Logger log = LoggerFactory.getLogger(CartorioController.class);
	
	@Autowired
	CertidaoService certidaoService;
	
	
	@GetMapping(value = "/buscar")
	public ResponseEntity<BaseResponseDTO> buscar() {
		try {
			return ok(certidaoService.buscarTodasCertidoes());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return error(MensagemUtil.ERRO_DESCONHECIDO);
		}
	}

}
