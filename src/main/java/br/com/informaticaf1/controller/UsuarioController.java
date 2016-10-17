package br.com.informaticaf1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.informaticaf1.models.Usuario;
import br.com.informaticaf1.repository.Usuarios;
import br.com.informaticaf1.service.UsuarioService;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private Usuarios usuarios;

	@RequestMapping("/perfil")
	public ModelAndView perfil() {

		return new ModelAndView("usuario/PerfilUsuario");
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listar() {

		ModelAndView mv = new ModelAndView("usuario/PesquisaUsuarios");

		mv.addObject("usuarios", this.usuarios.findAll());

		return mv;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String cadastrar(@ModelAttribute("usuario") Usuario usuario, RedirectAttributes atributes) {

		usuarioService.saveOrUpdate(usuario);

		atributes.addFlashAttribute("mensagem", "Usuario Cadastrado com Sucesso");

		return "redirect:/usuarios";
	}

	@RequestMapping(value = "/novo", method = RequestMethod.GET)
	public ModelAndView novo(@ModelAttribute("usuario") Usuario usuario) {

		return new ModelAndView("usuario/CadastroUsuario");
	}

}
