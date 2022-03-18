package com.desafio.docket.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.desafio.docket.model.Cartorio;
import com.desafio.docket.repository.CartorioRepository;

import io.swagger.annotations.ApiOperation;


@Controller
public class CartorioController extends BaseController {
	
	@Autowired
	private CartorioRepository cartorioRepository;

	@ApiOperation(value = "Busca todos os cartorios", notes = "Busca todos os Cartorios")
	@GetMapping("/cartorio/cartorios")
	public String cartorios(Model model) {
		model.addAttribute("listaCartorios", cartorioRepository.findAll());
		
		return "cartorio/index";
	}
	
	@ApiOperation(value = "Cadastra um cartorio", notes = "Cadastra um Cartorio")
	@GetMapping("/cartorio/novo")
	public String novoCartorio(Model model) {
		
		model.addAttribute("cartorio", new Cartorio(""));
		
		return "cartorio/form";
	}
	
	@ApiOperation(value = "Edita um cartorio pelo id", notes = "Edita um cartorio pelo id")
	@GetMapping("/cartorio/editar-cartorio/{id}")
	public String alterarCartorio(@PathVariable("id") long id, Model model) {
		Optional<Cartorio> cartorioOpt = cartorioRepository.findById(id);
		if (!cartorioOpt.isPresent()) {
			throw new IllegalArgumentException("Cartorio inválido.");
		}
		
		model.addAttribute("cartorio", cartorioOpt.get());
		
		return "cartorio/form";
	}
	
	@PostMapping("/cartorio/salvar")
	public String salvarCartorio(@Valid @ModelAttribute("cartorio") Cartorio cartorio, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "cartorio/form";
		}
		
		cartorioRepository.save(cartorio);
		return "redirect:/cartorio/cartorios";
	}
	
	
	@ApiOperation(value = "Remove um cartorio pelo id", notes = "Remove um cartorio pelo id")
	@GetMapping("/cartorio/excluir-cartorio/{id}")
	public String excluirCartorio(@PathVariable("id") long id) {
		Optional<Cartorio> cartorioOpt = cartorioRepository.findById(id);
		if (!cartorioOpt.isPresent()) {
			throw new IllegalArgumentException("Cartorio inválido.");
		}
		
		cartorioRepository.delete(cartorioOpt.get());
		return "redirect:/cartorio/cartorios";
	}

}