package br.com.informaticaf1.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name = "GRUPO")
public class Grupo extends AbstractPersistable<Short> {

	private static final long serialVersionUID = 1L;

	private String nome;
	private String descricao;
	
	private Usuario usuario;

	@Column(nullable = false, length = 30)
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Column(nullable=false, length=30)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "USUARIO_GRUPO", 
	joinColumns = @JoinColumn(name = "GRUPO_ID"), 
	inverseJoinColumns = @JoinColumn(name = "USUARIO_ID"))
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	

}