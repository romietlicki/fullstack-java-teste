package br.com.mietlicki.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonManagedReference;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * @author Rodrigo
 * 
 * Pedido bean
 *
 */
@Entity
@Table(name = "pedido")
public class Pedido {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String dataCriacao;
	private Double valorTotal;
	private Cliente cliente;
	private List<ItemPedido> itens = new ArrayList<>();
	
	public Pedido() {
		super();
	}
	
	@JsonCreator
	public Pedido(@JsonProperty("id") Long id,@JsonProperty("dataCriacao") String dataCriacao,@JsonProperty("valorTotal") Double valorTotal,
			@JsonProperty("cliente") Cliente cliente, @JsonProperty("itens") List<ItemPedido> itens) {
		super();
		this.id = id;
		this.dataCriacao = dataCriacao;
		this.valorTotal = valorTotal;
		this.cliente = cliente;
		this.itens = itens;
	}

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@NotNull
	@Column(name = "data_criacao", nullable = false)
	public String getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(String dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	@Column(name = "valor_total", nullable = false)
	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	@NotNull
	@ManyToOne
	@JoinColumn(name = "cliente_id", nullable = false)
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	@JsonManagedReference
	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	public List<ItemPedido> getItens() {
		return itens;
	}

	public void setItens(List<ItemPedido> itens) {
		this.itens = itens;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", dataCriacao=" + dataCriacao
				+ ", valorTotal=" + valorTotal + ", cliente=" + cliente
				+ ", itens=" + itens + "]";
	}


}