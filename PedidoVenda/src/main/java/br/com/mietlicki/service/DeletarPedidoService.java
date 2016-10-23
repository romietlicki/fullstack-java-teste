package br.com.mietlicki.service;

import br.com.mietlicki.model.Pedido;
import br.com.mietlicki.repository.Pedidos;

/**
 * @author Rodrigo
 * 
 *         Classe service que chama o Dao que tem o metodo de remoção de
 *         pedidos.
 *
 */
public class DeletarPedidoService {

	private Pedidos pedidoRepo = new Pedidos();

	public void deletarPedido(Pedido pedido) {

		pedidoRepo.deletePedidos(pedido);

	}

}
