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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.desafio.docket.model.Cartorio;
import com.desafio.docket.repository.CartorioRepository;


@Controller
public class CartorioController extends BaseController {
	
	@Autowired
	private CartorioRepository cartorioRepository;

	@GetMapping("/cartorio/buscar")
	@ResponseBody
	public String cartorios(Model model) {
		model.addAttribute("listaCartorio", cartorioRepository.findAll());
		
		return "cartorio/index";
	}
	
	@GetMapping("/index")
	public ModelAndView welcome() {
	    ModelAndView modelAndView = new ModelAndView();
	    modelAndView.setViewName("index.html");
	    return modelAndView;
	}
	
	@GetMapping("cartorio/novo")
	@ResponseBody
	public String novaPessoa(Model model) {
		
		model.addAttribute("cartorio", new Cartorio());
		
		return "cartorio/form";
	}
	
	@GetMapping("/cartorio/{id}")
	@ResponseBody
	public String alterarCartorio(@PathVariable("id") long id, Model model) {
		Optional<Cartorio> cartorioOpt = cartorioRepository.findById(id);
		if (!cartorioOpt.isPresent()) {
			throw new IllegalArgumentException("Cartorio inválido.");
		}
		
		model.addAttribute("cartorio", cartorioOpt.get());
		
		return "cartorio/form";
	}
	
	@PostMapping("/cartorio/salvar")
	@ResponseBody
	public String salvarPessoa(@Valid @ModelAttribute("cartorio") Cartorio cartorio, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "rh/pessoas/form";
		}
		
		cartorioRepository.save(cartorio);
		return "redirect:/cartorio/buscar";
	}
	
	@GetMapping("/cartorio/excluir/{id}")
	@ResponseBody
	public String excluirCartorio(@PathVariable("id") long id) {
		Optional<Cartorio> cartorioOpt = cartorioRepository.findById(id);
		if (!cartorioOpt.isPresent()) {
			throw new IllegalArgumentException("Cartorio inválido.");
		}
		
		cartorioRepository.delete(cartorioOpt.get());
		return "redirect:/cartorio/buscar";
	}

}