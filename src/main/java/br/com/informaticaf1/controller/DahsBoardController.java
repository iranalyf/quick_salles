package br.com.informaticaf1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/DashBoard")
public class DahsBoardController {

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView dash() {
		return new ModelAndView("dash/DashBoard");
	}
	
	
}
