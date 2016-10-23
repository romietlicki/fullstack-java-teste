package br.com.mietlicki.service;

import br.com.mietlicki.model.Pedido;
import br.com.mietlicki.repository.Pedidos;

/**
 * @author Rodrigo
 *
 */
public class AlterarPedidoService {

	private Pedidos pedidoRepo = new Pedidos();

	public Pedido alterarPedido(Pedido pedido) {
		return pedidoRepo.editarPedidoCliente(pedido);
	}

}
