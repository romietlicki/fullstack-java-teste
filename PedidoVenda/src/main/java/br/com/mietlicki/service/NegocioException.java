package br.com.mietlicki.service;

/**
 * @author Rodrigo
 * 
 *         Classe exeption criada para mostrar o exeption correto no metodo de
 *         remoção de produtos.
 *
 */
public class NegocioException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NegocioException(String msg) {
		super(msg);
	}

}
