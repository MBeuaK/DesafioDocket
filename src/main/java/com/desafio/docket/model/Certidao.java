package com.desafio.docket.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="T_CERTIDAO")
public class Certidao {
	
	@Id
	@Column(name = "ID", unique = true, columnDefinition = "int default 1")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="NOME_CERTIDAO")
	private String nomeCertidao;
}
