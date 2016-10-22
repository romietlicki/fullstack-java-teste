package br.com.mietlicki.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.mietlicki.model.ItemPedido;
import br.com.mietlicki.model.Pedido;
import br.com.mietlicki.util.jpa.EntityManagerProducer;

public class Pedidos implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	//inclusão de pedido
	public Pedido inserirPedidoCliente(Pedido pedido) {
		try{
		EntityManagerProducer emp = new EntityManagerProducer();
		manager = emp.createEntityManager();
		
		manager.getTransaction().begin();
		return this.manager.merge(pedido);
		}catch(Exception e){
			System.out.println("Erro..." +e);
			return null;
		}finally{
			manager.getTransaction().commit();
			manager.close();
		}
	}
	
	
	//inclusão de itens do pedido
/*	public List<ItemPedido> inserirItensPedido(Pedido pedido) {
		try{
		EntityManagerProducer emp = new EntityManagerProducer();
		manager = emp.createEntityManager();
		
		manager.getTransaction().begin();
		return this.manager.merge(pedido);
		}catch(Exception e){
			System.out.println("Erro..." +e);
			return null;
		}finally{
			manager.getTransaction().commit();
			manager.close();
		}
	}
*/
	
	public Pedido editarPedidoCliente(Pedido pedido) {
		try{
		EntityManagerProducer emp = new EntityManagerProducer();
		manager = emp.createEntityManager();
		
		manager.getTransaction().begin();
		return this.manager.merge(pedido);
		}catch(Exception e){
			System.out.println("Erro..." +e);
			return null;
		}finally{
			manager.getTransaction().commit();
			manager.close();
		}
	}
	
	public List<Pedido> buscarPedidosPorId(Long id) {
		
		try{
			EntityManagerProducer emp = new EntityManagerProducer();
			manager = emp.createEntityManager();
			this.manager.getTransaction().begin();
			Query query = this.manager.createQuery("from Pedido p where p.cliente.id =:id");
			query.setParameter("id", id);
			
			List<Pedido> pedidos = query.getResultList();
			
			this.manager.close();
			System.out.println("pedidos...:" +pedidos);
			return pedidos;
			
	} catch(Exception e){
		System.out.println("Erro buscar... " +e);
		return null;
	}
}
	
	
	public List<ItemPedido> buscarItensPedido(Long id) {
		
		try{
			EntityManagerProducer emp = new EntityManagerProducer();
			manager = emp.createEntityManager();
			this.manager.getTransaction().begin();
			Query query = this.manager.createQuery("from ItemPedido ip where ip.id =:id");
			query.setParameter("id", id);
			
			List<ItemPedido> itens = query.getResultList();
			
			this.manager.close();
			System.out.println("itens...:" +itens);
			return itens;
			
	} catch(Exception e){
		System.out.println("Erro buscar... " +e);
		return null;
	}
}
	
	
	public void deletePedidos(Pedido pedido) {
		try{
			
			EntityManagerProducer emp = new EntityManagerProducer();
			manager = emp.createEntityManager();
			this.manager.getTransaction().begin();
			
			pedido = this.manager.merge(pedido);
			
			System.out.println("Excluindo dados do pedido: " +pedido.getId());
			
			this.manager.remove(pedido);
			
			this.manager.getTransaction().commit();
			
		} finally{
			this.manager.close();
		}
		
	}
	
}