package br.com.mietlicki.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * @author Rodrigo
 *
 *Cliente bean
 *
 */
@Entity
@Table(name = "cliente")
public class Cliente {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private String email;
	private String cpf_cnpj;
	private TipoPessoa tipo;

	public Cliente() {
		super();
	}

	@JsonCreator
	public Cliente(@JsonProperty("id") Long id,
			@JsonProperty("nome") String nome,
			@JsonProperty("email") String email,
			@JsonProperty("cpf_cnpj") String cpf_cnpj,
			@JsonProperty("tipo") TipoPessoa tipo) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpf_cnpj = cpf_cnpj;
		this.tipo = tipo;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(nullable = false, length = 100)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(nullable = false, length = 255)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(nullable = false, length = 20)
	public String getCpf_cnpj() {
		return cpf_cnpj;
	}

	public void setCpf_cnpj(String cpf_cnpj) {
		this.cpf_cnpj = cpf_cnpj;
	}

	@Enumerated(EnumType.STRING)
	@Column(nullable = true, length = 10)
	public TipoPessoa getTipo() {
		return tipo;
	}

	public void setTipo(TipoPessoa tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", email=" + email
				+ ", cpf_cnpj=" + cpf_cnpj + ", tipo=" + tipo + "]";
	}

}
