package br.com.mietlicki.service;

import br.com.mietlicki.model.Pedido;
import br.com.mietlicki.repository.Pedidos;

public class DeletarPedidoService {
	
	private Pedidos pedidoRepo = new Pedidos();
	
	public void deletarPedido(Pedido pedido){
		
		pedidoRepo.deletePedidos(pedido);
		
	}

}
