package br.com.mietlicki.service;

import java.util.List;

import br.com.mietlicki.model.Cliente;
import br.com.mietlicki.repository.Clientes;

/**
 * @author Rodrigo
 * 
 *         Classe service que chama o dao de cadastrar cliente.
 *
 */
public class CadastroClienteService {

	Clientes clienteRepo = new Clientes();

	public Cliente cadastrarCliente(Cliente cliente) {

		return clienteRepo.guardarCliente(cliente);
	}

	public List<Cliente> buscarCliente() {
		return clienteRepo.findAll();
	}

}
