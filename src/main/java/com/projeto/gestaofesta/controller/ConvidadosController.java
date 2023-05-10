package com.projeto.gestaofesta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.projeto.gestaofesta.model.Convidado;
import com.projeto.gestaofesta.repository.Convidados;

@Controller
@RequestMapping("/convidados")
public class ConvidadosController {
	
	@Autowired
	private Convidados convidados;
	
	@GetMapping
	public ModelAndView listar() {
		
		ModelAndView modelAndView = new ModelAndView("ListaConvidados");
		
		modelAndView.addObject(new Convidado());
		
		modelAndView.addObject("convidados", convidados.findAll());//Add objetos para a view
		return modelAndView;
	}
	
	//redirect:/convidados -> o Browser faz uma nova requisição GET, atualizando a tabela com a nova pesquisa
	@PostMapping
	public String salvar(Convidado convidado) {
		this.convidados.save(convidado);
		return "redirect:/convidados";  
	}
}
