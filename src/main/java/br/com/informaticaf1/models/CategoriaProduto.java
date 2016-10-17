package br.com.informaticaf1.models;

import javax.persistence.*;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name = "CATEGORIA_PRODUTO")
public class CategoriaProduto extends AbstractPersistable<Short> {

	private static final long serialVersionUID = 1L;

	@Column(nullable = false, length = 80)
	private String descricao;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
