package br.com.informaticaf1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.informaticaf1.models.FotoProduto;
import br.com.informaticaf1.models.Produto;
import br.com.informaticaf1.repository.Produtos;
import br.com.informaticaf1.service.FotoProdutoService;
import br.com.informaticaf1.service.ProdutoService;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;

	@Autowired
	private FotoProdutoService fotoService;

	@Autowired
	private Produtos produtos;

	@RequestMapping
	public ModelAndView listarProdutos(@ModelAttribute("produto") Produto produto) {

		ModelAndView mv = new ModelAndView("produto/PesquisaProduto");

		mv.addObject("produtos", this.produtos.findAll());

		return mv;
	}

	@RequestMapping("/novo")
	public ModelAndView novo(@ModelAttribute("produto") Produto produto) {

		return new ModelAndView("produto/CadastroProduto");
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("produto") Produto produto,
			@RequestParam(value = "file", required = false) MultipartFile file, RedirectAttributes atributes) {

		FotoProduto fotoProduto = fotoService.getFotoProdutoByUpload(file);
		produto.setFotoProduto(fotoProduto);

		this.produtoService.save(produto);

		atributes.addFlashAttribute("mensagem", "Produto Cadastrado com Sucesso");

		return "redirect:/produtos";
	}

	@RequestMapping("/estoque")
	public ModelAndView estoqueProdutos() {

		return new ModelAndView("produto/PesquisaProdutos");
	}

}
