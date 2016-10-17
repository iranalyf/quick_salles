package br.com.informaticaf1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.informaticaf1.models.Pedido;
import br.com.informaticaf1.models.Produto;
import br.com.informaticaf1.repository.Produtos;

@Controller
@RequestMapping("/pedidos")
public class PedidoController {

	@Autowired
	private Produtos produtos;

	@RequestMapping("/produtosPorNome")
	public ModelAndView produtoPorNome(@ModelAttribute("produto") Produto produto, String nome) {

		ModelAndView mv = new ModelAndView();

		List<Produto> produtoPorNome = produtos.findByProdutoEndingWith(nome);

		mv.addObject("produtoPorNome", produtoPorNome);

		return mv;
	}

	@RequestMapping
	public ModelAndView pesquisaPedidos() {

		return new ModelAndView("pedido/PesquisaPedido");
	}

	@RequestMapping("/novo")
	public ModelAndView novo(@ModelAttribute("pedido") Pedido pedido) {

		ModelAndView mv = new ModelAndView("pedido/CadastroPedido");

		mv.addObject("pedido", pedido);

		return mv;
	}

}
