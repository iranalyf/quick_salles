package br.com.informaticaf1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.informaticaf1.models.Cliente;
import br.com.informaticaf1.repository.Clientes;

@Service
@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
public class ClienteService {

	@Autowired
	private Clientes clientes;

	@Transactional(readOnly = false)
	public void cadastrarOuAtualizar(Cliente cliente) {
		
		if (cliente.getId() == null) {
			this.clientes.save(cliente);
		}
	}
}
