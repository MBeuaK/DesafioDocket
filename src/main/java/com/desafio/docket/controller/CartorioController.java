package com.desafio.docket.controller;

import java.text.MessageFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.docket.model.dto.BaseResponseDTO;
import com.desafio.docket.model.dto.CartorioDTO;
import com.desafio.docket.service.CartorioService;
import com.desafio.docket.util.MensagemUtil;


@RestController
@RequestMapping("/api/v1/cartorio")
public class CartorioController extends BaseController {
	private final Logger log = LoggerFactory.getLogger(CartorioController.class);

	@Autowired
	private CartorioService cartorioService;

	@PostMapping
	public ResponseEntity<BaseResponseDTO> criar(@RequestBody CartorioDTO cartorioDTO) {
		try {
			return create(cartorioService.cadastrarCartorio(cartorioDTO));
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return error(MensagemUtil.ERRO_DESCONHECIDO);
		}
	}

	@GetMapping(value = "/buscar")
	public ResponseEntity<BaseResponseDTO> buscar() {
		try {
			return ok(cartorioService.buscarTodosCartorios());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return error(MensagemUtil.ERRO_DESCONHECIDO);
		}
	}

	@GetMapping(value = "/buscar-cartorio/{id}")
	public ResponseEntity<BaseResponseDTO> buscarPorId(@PathVariable(value = "id", required = true) Long id) {
		try {
			return ok(cartorioService.buscarCartorioPorId(id));
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return error(MensagemUtil.ERRO_DESCONHECIDO);
		}
	}

	@PutMapping("/editar-cartorio/{id}")
	public ResponseEntity<BaseResponseDTO> editar(@PathVariable(value = "id", required = true) Long id,
			@RequestBody(required = true) CartorioDTO cartorioDTO) {
		try {
			return ok(cartorioService.editarcartorio(id, cartorioDTO));
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return error(MensagemUtil.ERRO_DESCONHECIDO);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<BaseResponseDTO> cancelar(@PathVariable(value = "id", required = true) Long id) {
		try {
			Object response = cartorioService.excluircartorio(id);
			if (response == null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND)
						.body(new BaseResponseDTO(404, MessageFormat.format(MensagemUtil.CARTORIO_NAO_ECONTRADO, id), null));
			}
			return ok(response);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return error(MensagemUtil.ERRO_DESCONHECIDO);
		}
	}

}