package com.desafio.docket.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
	@Column(name = "ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="NOME_CARTORIO")
	private String nomeCartorio;
	
	@Column(name="ENDERECO")
	private String endereco;
	
	@OneToMany(mappedBy = "cartorio", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Certidao> certidoes;
	
	
	public Cartorio(String nomeCartorio) {
		this.nomeCartorio = nomeCartorio;
	}

}
