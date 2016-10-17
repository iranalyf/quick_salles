package br.com.informaticaf1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.informaticaf1.models.FotoProduto;
import br.com.informaticaf1.models.Produto;

public interface Produtos extends JpaRepository<Produto, Short> {

	// Produto findById(Short id);

	@Query("select p from Produto p where p.nome like %?1%")
	List<Produto> findByProdutoEndingWith(String nome);

	Produto findByFotoProduto(FotoProduto fotoProduto);
}
