package br.com.informaticaf1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/login")
public class SegurancaController {

	@RequestMapping
	public ModelAndView login() {

		return new ModelAndView("Login");
	}
}
