package br.com.informaticaf1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.informaticaf1.models.Usuario;


public interface Usuarios extends JpaRepository<Usuario, Short> {

	Usuario findByEmailAndSenha(String email, String senha);
	
	

}
