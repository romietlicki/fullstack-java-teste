package br.com.mietlicki.service;

import java.io.Serializable;

import br.com.mietlicki.model.Pedido;
import br.com.mietlicki.repository.Pedidos;

/**
 * @author Rodrigo
 *
 */
public class CadastroPedidoService implements Serializable {

	private static final long serialVersionUID = 1L;

	private Pedidos pedidoRepo = new Pedidos();

	public Pedido salvarPedidoNovo(Pedido pedido) {

		return this.pedidoRepo.inserirPedidoCliente(pedido);
	}

}
