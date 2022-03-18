package com.desafio.docket.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartorioDTO{
	
	private Long id;
	private String nomeCartorio;
	private String endereco;
}
