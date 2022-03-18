package com.desafio.docket.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	@Column(name = "ID", unique = true, columnDefinition = "int default 1")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="NOME_CARTORIO")
	private String nomeCartorio;
	
	@Column(name="ENDERECO")
	private String endereco;
	
	@ManyToOne(cascade=CascadeType.PERSIST,fetch= FetchType.LAZY)
	@JoinColumn(name = "FK_CERTIDAO", nullable = true, columnDefinition = "int default 1")
	private Certidao certidao;
	
	
	public Cartorio(String nomeCartorio) {
		this.nomeCartorio = nomeCartorio;
	}

}
