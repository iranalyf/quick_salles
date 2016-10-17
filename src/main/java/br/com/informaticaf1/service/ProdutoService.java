package br.com.informaticaf1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.informaticaf1.models.FotoProduto;
import br.com.informaticaf1.models.Produto;
import br.com.informaticaf1.repository.Produtos;

@Service
@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
public class ProdutoService {

	@Autowired
	private Produtos produtos;

	public Produto findByFotoProduto(FotoProduto fotoProduto) {
		return produtos.findByFotoProduto(fotoProduto);
	}

	public Produto findById(Short id) {
		return produtos.findOne(id);
	}

	public List<Produto> findAll() {
		return produtos.findAll();
	}

	@Transactional(readOnly = false)
	public void save(Produto produto) {

		this.produtos.save(produto);

	}

}
