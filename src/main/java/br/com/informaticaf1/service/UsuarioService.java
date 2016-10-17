package br.com.informaticaf1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.informaticaf1.models.Usuario;
import br.com.informaticaf1.repository.Usuarios;

@Service
@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
public class UsuarioService {

	@Autowired
	private Usuarios usuarios;

	@Transactional(readOnly = false)
	public void saveOrUpdate(Usuario usuario) {

		if (usuario.getId() == null) {
			this.usuarios.save(usuario);
		}
	}
	
	public Usuario findByUsuariosAndSortAsc(){
		
		Order orderAsc = new Order(Direction.ASC, "nome");
		
		Sort sort = new Sort(orderAsc);
		
		List<Usuario> usuariosEmOrdemAs = this.usuarios.findAll(sort);
		
		
		return (Usuario) usuariosEmOrdemAs;
	}
}
