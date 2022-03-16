package com.desafio.docket.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="T_CERTIDAO")
public class Certidao {
	
	@Id
	@Column(name = "ID", unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="NOME_CERTIDAO")
	private String nomeCertidao;

}
