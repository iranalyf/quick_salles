package br.com.informaticaf1.models;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name = "PRODUTO")
public class Produto extends AbstractPersistable<Short> {

	private static final long serialVersionUID = 1L;

	@NotEmpty
	@Column(nullable = false, length = 10)
	private String codigo;
	@NotEmpty
	@Column(nullable = false, length = 80)
	private String nome;
	@NotEmpty
	@Column(nullable = false, length = 100)
	private String descricao;
	@Column(nullable = false, precision = 10, scale = 2)
	private BigDecimal valorUnitario = BigDecimal.ZERO;
	@Column(nullable = false)
	private Integer qtdeEstoque;

	@OneToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE }, fetch = FetchType.EAGER)
	@JoinColumn(name = "FOTOPRODUTO_ID")
	private FotoProduto fotoProduto;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "CATEGORIA_ID")
	private CategoriaProduto categoria;

	@Override
	public void setId(Short id) {

		super.setId(id);
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public Integer getQtdeEstoque() {
		return qtdeEstoque;
	}

	public void setQtdeEstoque(Integer qtdeEstoque) {
		this.qtdeEstoque = qtdeEstoque;
	}

	public CategoriaProduto getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaProduto categoria) {
		this.categoria = categoria;
	}

	public FotoProduto getFotoProduto() {
		return fotoProduto;
	}

	public void setFotoProduto(FotoProduto fotoProduto) {
		this.fotoProduto = fotoProduto;
	}

}
