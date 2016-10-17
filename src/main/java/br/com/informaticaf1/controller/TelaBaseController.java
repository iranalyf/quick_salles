package br.com.informaticaf1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TelaBaseController {

	@RequestMapping
	public String teste(){
		return "produto/PesquisaProdutos";
	}
}
