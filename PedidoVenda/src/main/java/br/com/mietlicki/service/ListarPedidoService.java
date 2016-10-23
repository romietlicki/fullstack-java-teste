package br.com.mietlicki.service;

import java.util.List;

import br.com.mietlicki.model.ItemPedido;
import br.com.mietlicki.model.Pedido;
import br.com.mietlicki.repository.Pedidos;

/**
 * @author Rodrigo
 * 
 *         Classe service que chama o Dao que tem os metodos de listagem de
 *         pedidos e itens do pedido.
 *
 */
public class ListarPedidoService {

	private Pedidos pedidoRepo = new Pedidos();

	public List<Pedido> listarPedidoPorId(Long id) {

		List<Pedido> lista = pedidoRepo.buscarPedidosPorId(id);

		return lista;
	}

	public List<ItemPedido> listarItensPedido(Long id) {

		List<ItemPedido> lista = pedidoRepo.buscarItensPedido(id);

		return lista;
	}

}
