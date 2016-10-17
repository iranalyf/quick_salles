package br.com.informaticaf1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.informaticaf1.models.FotoProduto;

public interface FotosProdutos extends JpaRepository<FotoProduto, Short> {

}
