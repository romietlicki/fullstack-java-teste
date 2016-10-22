package br.com.mietlicki.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.hibernate.HibernateException;

import br.com.mietlicki.model.Produto;
import br.com.mietlicki.service.NegocioException;
import br.com.mietlicki.util.jpa.EntityManagerProducer;

public class Produtos implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public Produto guardar(Produto produto) {
		try{
		EntityManagerProducer emp = new EntityManagerProducer();
		
		manager = emp.createEntityManager();
		
		manager.getTransaction().begin();
		return manager.merge(produto);
		
		} catch(Exception e){
			System.out.println("Erro..." +e);
		}finally{
			manager.getTransaction().commit();
		}
		return null;
	}
	
	  public List<Produto> findAllProdutos() {
	        List<Produto> produtos = null;
	        try {
	        	EntityManagerProducer emp = new EntityManagerProducer();
	    		
	    		manager = emp.createEntityManager();
	    		
	    		manager.getTransaction().begin();
	            Query query = manager.createQuery("from Produto");
	            produtos = query.getResultList();
	            System.out.println("Exibindo todos os produtos... " +produtos);
	            
	        } catch (HibernateException e) {
	            System.out.println(e);
	        } finally {
	            manager.close();
	        }
	        return produtos;
	    }
	
	public void remover(Produto produto) {
		try {
			produto = porId(produto.getId());
			manager.remove(produto);
			manager.flush();
		} catch (PersistenceException e) {
			throw new NegocioException("Produto não pode ser excluído.");
		}
	}

	public Produto porId(Long id) {
		return manager.find(Produto.class, id);
	}

	public List<Produto> porNome(String nome) {
		return this.manager.createQuery("from Produto where upper(nome) like :nome", Produto.class)
				.setParameter("nome", nome.toUpperCase() + "%").getResultList();
	}
	
}
