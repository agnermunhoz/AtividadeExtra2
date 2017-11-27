package br.com.fiap.helper;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.fiap.core.HibernateUtil;
import br.com.fiap.entity.Pedido;

public class PedidoHelper {

	Session session = null;
	
	public PedidoHelper() {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
	}
	
	private Session getSession() {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		return session;
	}
	
	public List<Pedido> getPedidos() {
		List<Pedido> pedidos = new ArrayList<>();
		try {
			Transaction tx = getSession().beginTransaction();
			TypedQuery<Pedido> q = session.createQuery("from Pedido");
			pedidos = q.getResultList();
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pedidos;
	}
	
	public Pedido getPedido(int id) {
		Pedido pedido = new Pedido();
		try {
			Transaction tx = getSession().beginTransaction();
			session.load(pedido,id);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pedido;
	}
	
	public Pedido salvarPedido(Pedido pedido) {
		try{
			Transaction tx = getSession().beginTransaction();
			session.save(pedido);
			tx.commit();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return pedido;
	}
}
