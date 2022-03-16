package com.desafio.docket.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="T_CARTORIO")
public class Cartorio {
	
	@Id
	@Column(name = "ID", unique = true)
	private Long id;
	
	@Column(name="NOME_CARTORIO")
	private String nomeCartorio;
	
	@Column(name="NOME_ENDERECO")
	private String endereco;
	
	@ManyToOne(fetch= FetchType.EAGER)
	@MapsId
	private Certidao certidao;

}
