package br.com.informaticaf1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.informaticaf1.models.Pedido;

public interface Pedidos extends JpaRepository<Pedido, Short> {

}
