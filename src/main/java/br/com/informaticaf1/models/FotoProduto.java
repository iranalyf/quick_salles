package br.com.informaticaf1.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name = "FOTO_PRODUTO")
public class FotoProduto extends AbstractPersistable<Short> {

	private static final long serialVersionUID = 1L;

	@Column(nullable = false)
	private String titulo;
	@Column(nullable = false)
	private String tipo;
	@Lob
	@Column(nullable = false)
	private byte[] fotoProduto;

	@Override
	public void setId(Short id) {
		super.setId(id);
	}
	
	@Override
	public Short getId() {
		// TODO Auto-generated method stub
		return super.getId();
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public byte[] getFotoProduto() {
		return fotoProduto;
	}

	public void setFotoProduto(byte[] fotoProduto) {
		this.fotoProduto = fotoProduto;
	}

}
