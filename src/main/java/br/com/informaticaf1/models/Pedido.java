package br.com.informaticaf1.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name = "PEDIDO")
public class Pedido extends AbstractPersistable<Short> {

	private static final long serialVersionUID = 1L;

	private LocalDateTime dataCricao = LocalDateTime.now();
	private BigDecimal valorFrete = BigDecimal.ZERO;
	private BigDecimal valorDesconto = BigDecimal.ZERO;
	private String observacao;
	private Date dataEntrega;

	private ItemPedido itens;
	private StatusPedido statusPedido;
	private Usuario vendedor;
	private Cliente cliente;

	@Column(name = "data_cricao", nullable = false)
	public LocalDateTime getDataCricao() {
		return dataCricao;
	}

	public void setDataCricao(LocalDateTime dataCricao) {
		this.dataCricao = dataCricao;
	}

	@Column(name = "valor_frete", nullable = false, precision = 10, scale = 2)
	public BigDecimal getValorFrete() {
		return valorFrete;
	}

	public void setValorFrete(BigDecimal valorFrete) {
		this.valorFrete = valorFrete;
	}

	@Column(name = "valor_desconto", nullable = false, precision = 10, scale = 2)
	public BigDecimal getValorDesconto() {
		return valorDesconto;
	}

	public void setValorDesconto(BigDecimal valorDesconto) {
		this.valorDesconto = valorDesconto;
	}

	@Column(name = "data_entrega", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	public Date getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	@Column(length = 100)
	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 30)
	public StatusPedido getStatusPedido() {
		return statusPedido;
	}

	public void setStatusPedido(StatusPedido statusPedido) {
		this.statusPedido = statusPedido;
	}

	@OneToMany(mappedBy = "pedido", cascade = { CascadeType.PERSIST, CascadeType.MERGE }, orphanRemoval = true)
	public ItemPedido getItens() {
		return itens;
	}

	public void setItens(ItemPedido itens) {
		this.itens = itens;
	}

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "VENDEDOR_ID")
	public Usuario getVendedor() {
		return vendedor;
	}

	public void setVendedor(Usuario vendedor) {
		this.vendedor = vendedor;
	}

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "CLIENTE_ID")
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
