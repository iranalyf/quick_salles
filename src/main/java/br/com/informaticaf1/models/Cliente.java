package br.com.informaticaf1.models;

import java.util.Date;

import javax.persistence.*;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name = "CLIENTE")
public class Cliente extends AbstractPersistable<Short> {

	private static final long serialVersionUID = 1L;

	public enum TipoTelefone {
		COMERCIAL, RESIDENCIAL, PARTICULAR
	}

	public enum TipoPessoa {
		FISICA, JURIDICA
	}

	private String nome;
	private TipoPessoa tipoPessoa;
	private Long cpf;
	private Date dataNascimento;
	private String email;
	private TipoTelefone tipoTelefone;
	private Integer numeroTelefone;

	private Endereco endereco;
	private Pedido pedidos;

	@Column(nullable = false, length = 80)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(nullable = false, length = 14)
	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	@Column(name = "data_nascimento", nullable = false, length = 10)
	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	@Column(nullable = false, length = 50)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_ENDERECO")
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_telefone", nullable = true, length = 30)
	public TipoTelefone getTipoTelefone() {
		return tipoTelefone;
	}

	public void setTipoTelefone(TipoTelefone tipoTelefone) {
		this.tipoTelefone = tipoTelefone;
	}

	@Column(name = "numero_telefone", nullable = true, length = 15)
	public Integer getNumeroTelefone() {
		return numeroTelefone;
	}

	public void setNumeroTelefone(Integer numeroTelefone) {
		this.numeroTelefone = numeroTelefone;
	}

	@OneToMany(mappedBy = "cliente")
	public Pedido getPedidos() {
		return pedidos;
	}

	public void setPedidos(Pedido pedidos) {
		this.pedidos = pedidos;
	}

	@Column(name = "tipo_pessoa", nullable = false, length = 10)
	@Enumerated(EnumType.STRING)
	public TipoPessoa getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(TipoPessoa tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

}
