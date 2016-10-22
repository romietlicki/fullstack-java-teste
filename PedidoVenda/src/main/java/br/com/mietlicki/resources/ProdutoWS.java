package br.com.mietlicki.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.mietlicki.model.Pedido;
import br.com.mietlicki.model.Produto;
import br.com.mietlicki.service.CadastroProdutoService;

@Path("/produtos")
public class ProdutoWS {
	CadastroProdutoService cadastroProdutoService = new CadastroProdutoService();
	
	@POST
	@Path("/inserirProduto")
	@Produces(MediaType.APPLICATION_JSON)
	public void inserirProduto(Produto produto){
		
		cadastroProdutoService.inserirProduto(produto);
	}
	
	@GET
	@Path("/listarProdutos")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Produto> getProdutos(){
		
		return cadastroProdutoService.listarProdutos();
	}
	
}
