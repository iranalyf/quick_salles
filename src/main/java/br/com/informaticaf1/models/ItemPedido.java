package br.com.informaticaf1.models;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name = "ITEM_PEDIDO")
public class ItemPedido extends AbstractPersistable<Short> {

	private static final long serialVersionUID = 1L;

	private Byte quantidade = 1;
	private BigDecimal valorUnitario = BigDecimal.ZERO;

	private Produto produto;
	private Pedido pedido;

	@Column(nullable = false, length = 3)
	public Byte getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Byte quantidade) {
		this.quantidade = quantidade;
	}

	@Column(nullable = false, precision = 10, scale = 2)
	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "PRODUTO_ID")
	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	@ManyToOne
	@JoinColumn(name = "PEDIDO_ID")
	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

}
