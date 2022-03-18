package com.desafio.docket.service;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.docket.model.Cartorio;
import com.desafio.docket.model.dto.CartorioDTO;
import com.desafio.docket.repository.CartorioRepository;
import com.desafio.docket.util.MensagemUtil;


@Service
public class CartorioService {

	@Autowired
	private CartorioRepository cartorioRepository;

	public Object cadastrarCartorio(CartorioDTO cartorioDTO) {
		Cartorio cartorio = new Cartorio();

		Optional<Cartorio> c = cartorioRepository.findById(cartorioDTO.getId());
		if (c.isPresent()) {
			throw new IllegalArgumentException(
					MessageFormat.format(MensagemUtil.CARTORIO_EXISTENTE, cartorioDTO.getNomeCartorio()));
		}

		BeanUtils.copyProperties(cartorioDTO, cartorio);
		return cartorioRepository.save(cartorio);
	}

	public Object buscarTodosCartorios() {
		List<Cartorio> lstcartorio = cartorioRepository.findAll();
		if (lstcartorio.isEmpty()) {
			return new ArrayList<>();
		}

		return lstcartorio;
	}

	public Object buscarCartorioPorId(Long id) {
		Optional<Cartorio> cartorio = cartorioRepository.findById(id);
		if (!cartorio.isPresent()) {
			throw new IllegalArgumentException(MessageFormat.format(MensagemUtil.CARTORIO_NAO_ECONTRADO, id));
		}

		return cartorio.get();
	}

	public Object editarcartorio(Long id, CartorioDTO cartorioDTO) {
		Optional<Cartorio> cartorio = cartorioRepository.findById(id);
		if (!cartorio.isPresent()) {
			throw new IllegalArgumentException(MessageFormat.format(MensagemUtil.CARTORIO_NAO_ECONTRADO, id));
		}

		cartorio.get().setEndereco(cartorioDTO.getEndereco());
		cartorio.get().setNomeCartorio(cartorioDTO.getNomeCartorio());;


		return cartorioRepository.save(cartorio.get());
	}

	public Object excluircartorio(Long id) {
		Optional<Cartorio> cartorio = cartorioRepository.findById(id);
		if (cartorio.isPresent()) {
			cartorioRepository.deleteById(id);
			return "ok";
		}

		return null;
	}

}