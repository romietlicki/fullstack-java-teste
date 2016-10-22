package br.com.mietlicki.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.HibernateException;

import br.com.mietlicki.model.Cliente;
import br.com.mietlicki.util.jpa.EntityManagerProducer;

public class Clientes implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public Cliente porId(Long id) {
		return this.manager.find(Cliente.class, id);
	}
	
	  public List<Cliente> findAll() {
	        List<Cliente> clientes = null;
	        try {
	        	EntityManagerProducer emp = new EntityManagerProducer();
	    		
	    		manager = emp.createEntityManager();
	    		
	    		manager.getTransaction().begin();
	            Query query = manager.createQuery("from Cliente");
	            clientes = query.getResultList();
	            System.out.println("Exibindo todos os clientes... " +clientes);
	            
	        } catch (HibernateException e) {
	            System.out.println(e);
	        } finally {
	            manager.close();
	        }
	        return clientes;
	    }
	  
	
	public Cliente guardarCliente(Cliente clientes) {
		try{	
		EntityManagerProducer emp = new EntityManagerProducer();
		
		manager = emp.createEntityManager();
		
		manager.getTransaction().begin();
		return this.manager.merge(clientes);
		}catch(Exception e){
			System.out.println("Erro..." +e.getMessage());
			return null;
		}finally{
			manager.getTransaction().commit();
			manager.close();
		}
	}
	
	public List<Cliente> porNome(String nome) {
		return this.manager.createQuery("from Cliente " +
				"where upper(nome) like :nome", Cliente.class)
				.setParameter("nome", nome.toUpperCase() + "%")
				.getResultList();
	}
	
}