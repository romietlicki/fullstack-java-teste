package br.com.mietlicki.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.mietlicki.model.Cliente;
import br.com.mietlicki.model.ItemPedido;
import br.com.mietlicki.model.Pedido;
import br.com.mietlicki.model.Produto;
import br.com.mietlicki.model.TipoPessoa;
import br.com.mietlicki.repository.Clientes;
import br.com.mietlicki.repository.Pedidos;
import br.com.mietlicki.repository.Produtos;
import br.com.mietlicki.service.CadastroPedidoService;
import br.com.mietlicki.service.CadastroProdutoService;
import br.com.mietlicki.service.ListarPedidoService;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Clientes clienteRepo = new Clientes();
		Produtos produtoRepo = new Produtos();
		Pedidos pedidoRepo = new Pedidos();
		ListarPedidoService listaPedidoService = new ListarPedidoService();
		
		Cliente clientes = new Cliente();
		clientes.setEmail("rodrigo.albuquerque@gmail.com");
		clientes.setNome("Rodrigo");
		clientes.setTipo(TipoPessoa.FISICA);
		clientes.setCpf_cnpj("42957068822");
		clientes.setId(6L);
		
		Produto produtos = new Produto();
		produtos.setNome("Mochila");
		produtos.setQuantidadeEstoque(112);
		produtos.setValorUnitario(50.00);
		
		Pedido pedidos = new Pedido();
		pedidos.setCliente(clientes);
		pedidos.setDataCriacao(new Date());
/*		ItemPedido item = new ItemPedido();
		List<ItemPedido> lista = new ArrayList<ItemPedido>();
		item.setPedido(pedidos);
		item.setId(21L);
		item.setProduto(produtos);
		item.setQuantidade(4);
		lista.add(item);*/
		//item.setValorUnitario(23.70);
		//pedidos.setItens(lista);
		pedidos.setValorTotal(12.60*5);

		/*try{
		clienteRepo.guardarCliente(clientes);	
		} catch(Exception e){
			System.out.println("Erro main..." +e.getMessage());
		}*/
		
		//produtoRepo.guardar(produtos);
		pedidoRepo.inserirPedidoCliente(pedidos);
		
		/*Pedido pedidos666 = new Pedido();
		pedidos666.setId(4L);*/
		
		//pedidoRepo.deletePedidos(pedidos666);
		
	/*	Cliente cliente1 = new Cliente();
		cliente1.setId(3L);*/
		
		//pedidoRepo.buscarPedidosPorId(clientes);
		
		pedidoRepo.buscarItensPedido(2L);
		/*Long id = clientes.getId();
		listaPedidoService.listarPedidoPorId(id);*/
		
		/*CadastroProdutoService service = new CadastroProdutoService();
		
		service.listarProdutos();*/
		
		//clienteRepo.findAll();
		
	}

}

