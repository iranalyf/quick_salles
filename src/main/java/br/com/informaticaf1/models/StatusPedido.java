package br.com.informaticaf1.models;

public enum StatusPedido {

	EMITIDO("Emitido"), ORCAMENTO("Orçamento"), CANCELADO("Cancelado");

	private String descricao;

	StatusPedido(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
