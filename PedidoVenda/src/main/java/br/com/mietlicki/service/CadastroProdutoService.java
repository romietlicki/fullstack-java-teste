package br.com.mietlicki.service;

import java.io.Serializable;
import java.util.List;

import br.com.mietlicki.model.Produto;
import br.com.mietlicki.repository.Produtos;

/**
 * @author Rodrigo
 * 
 *         Classe service que chama o dao de que tem os metodos de
 *         inserção/listagem dos produtos.
 *
 */
public class CadastroProdutoService implements Serializable {

	private static final long serialVersionUID = 1L;

	private Produtos produtos = new Produtos();

	public Produto inserirProduto(Produto produto) {

		return produtos.guardar(produto);
	}

	public List<Produto> listarProdutos() {

		return produtos.findAllProdutos();
	}

}
