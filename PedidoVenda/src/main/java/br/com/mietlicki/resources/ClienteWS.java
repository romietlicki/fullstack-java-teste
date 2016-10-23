package br.com.mietlicki.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.mietlicki.model.Cliente;
import br.com.mietlicki.service.CadastroClienteService;

/**
 * @author Rodrigo
 * 
 *         Classe responsavel pela criação dos servicos rest de inserção e e
 *         listagem dos clientes
 *
 */
@Path("/cliente")
public class ClienteWS {

	CadastroClienteService cadastroClienteService = new CadastroClienteService();

	@POST
	@Path("/inserirCliente")
	@Consumes(MediaType.APPLICATION_JSON)
	public Cliente inserirCliente(Cliente cliente) {

		return cadastroClienteService.cadastrarCliente(cliente);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/buscarCliente")
	public List<Cliente> buscarClientes() {

		return cadastroClienteService.buscarCliente();
	}

}
