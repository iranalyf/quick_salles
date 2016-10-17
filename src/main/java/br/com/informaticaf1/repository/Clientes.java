package br.com.informaticaf1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.informaticaf1.models.Cliente;

public interface Clientes extends JpaRepository<Cliente, Short> {

}
