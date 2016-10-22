package br.com.mietlicki.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.mietlicki.model.ItemPedido;
import br.com.mietlicki.model.Pedido;
import br.com.mietlicki.service.AlterarPedidoService;
import br.com.mietlicki.service.CadastroPedidoService;
import br.com.mietlicki.service.DeletarPedidoService;
import br.com.mietlicki.service.ListarPedidoService;

@Path("/pedidos")
public class PedidosWS {
	   
	 CadastroPedidoService pedidoService = new CadastroPedidoService();
	 ListarPedidoService listaPedidoService = new ListarPedidoService();
	 AlterarPedidoService alterarPedidoService = new AlterarPedidoService();
	 DeletarPedidoService deletarPedidoService = new DeletarPedidoService();
	 
		@GET
		@Path("/listarPedidos/{id}")
		@Produces(MediaType.APPLICATION_JSON)
		@Consumes(MediaType.APPLICATION_JSON)
		
		public List<Pedido> getPedidosCliente(@PathParam("id") Long id){
			
			return listaPedidoService.listarPedidoPorId(id);
		}
		
		
		@GET
		@Path("/listarItens/{id}")
		@Produces(MediaType.APPLICATION_JSON)
		@Consumes(MediaType.APPLICATION_JSON)
		
		public List<ItemPedido> getItensPedido(@PathParam("id") Long id){
			
			return listaPedidoService.listarItensPedido(id);
		}
	 
	 
/*	    @GET  
	    @Path("/{id}")  
	    @Produces(MediaType.APPLICATION_JSON)
	 public Pedidos buscarPedidosPorId(@PathParam("id") int id)
	 {  
	  return pedidoService.getPedido(id);
	 }  */
	      
	 @POST
	 @Path("/inserirPedido")
	 @Consumes(MediaType.APPLICATION_JSON)  
	 public Pedido addPedido(Pedido pedido){  
	    	return pedidoService.salvarPedidoNovo(pedido);
	 	}  
	  
	 @PUT  
	 @Produces(MediaType.APPLICATION_JSON)
	 public void alterarPedido(Pedido pedido){  
	    	alterarPedidoService.alterarPedido(pedido);
	 }  
	   
	 @DELETE  
	 //@Path("/{id}")  
	 @Produces(MediaType.APPLICATION_JSON)  
	 public void deleteCountry(Pedido pedido){
	    	deletarPedidoService.deletarPedido(pedido);
	 }  
}
