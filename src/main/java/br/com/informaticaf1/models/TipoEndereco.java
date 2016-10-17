package br.com.informaticaf1.models;

public enum TipoEndereco {

	RUA("Rua"), AVENIDA("Avenida"), QUADRA("Quadra"), BECO("Beco"), CHACARA("Chácara"), CONDOMINIO(
			"Condomínio"), FAZENDA("Fazenda"), PRACA("Praça"), SITIO("Sítio"), ESTRADA("Estrada");

	private String descricao;

	TipoEndereco(String descricao) {
		this.descricao = descricao;

	}

	public String getDescricao() {
		return descricao;
	}

}
