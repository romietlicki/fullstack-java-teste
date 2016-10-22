package br.com.mietlicki.service;

import br.com.mietlicki.model.Pedido;
import br.com.mietlicki.repository.Pedidos;

public class AlterarPedidoService {
	
	private Pedidos pedidoRepo = new Pedidos();
	
	public void alterarPedido(Pedido pedido){
		pedidoRepo.editarPedidoCliente(pedido);
	}

}
