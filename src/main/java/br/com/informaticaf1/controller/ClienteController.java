package br.com.informaticaf1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.informaticaf1.models.Cliente;
import br.com.informaticaf1.models.TipoEndereco;
import br.com.informaticaf1.models.Cliente.TipoPessoa;
import br.com.informaticaf1.models.Cliente.TipoTelefone;
import br.com.informaticaf1.service.ClienteService;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@RequestMapping
	public ModelAndView listar() {

		return new ModelAndView("cliente/PesquisaClientes");
	}

	@RequestMapping(value = "/novo")
	public ModelAndView novo(Cliente cliente) {

		ModelAndView mv = new ModelAndView("cliente/CadastroCliente");

		mv.addObject("tipos", TipoPessoa.values());
		mv.addObject("tiposTelefone", TipoTelefone.values());
		mv.addObject("tiposEndereco", TipoEndereco.values());

		return mv;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Cliente cliente, RedirectAttributes atributes) {

		this.clienteService.cadastrarOuAtualizar(cliente);

		atributes.addFlashAttribute("mensagem", "Cliente Cadastrado com Sucesso");

		return "redirect:/clientes";
	}
}
