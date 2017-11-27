package br.com.fiap.helper;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.fiap.core.HibernateUtil;
import br.com.fiap.entity.Cliente;

public class ClienteHelper {

	Session session = null;
	
	public ClienteHelper() {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
	}
	
	private Session getSession() {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		return session;
	}
	
	public List<Cliente> getClientes() {
		List<Cliente> clientes = new ArrayList<>();
		try {
			Transaction tx = getSession().beginTransaction();
			TypedQuery<Cliente> q = session.createQuery("from Cliente");
			clientes = q.getResultList();
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return clientes;
	}
	
	public Cliente getCliente(int id) {
		Cliente cliente = new Cliente();
		try {
			Transaction tx = getSession().beginTransaction();
			session.load(cliente,id);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cliente;
	}
	
	public Cliente salvarCliente(Cliente cliente) {
		try{
			Transaction tx = getSession().beginTransaction();
			session.save(cliente);
			tx.commit();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return cliente;
	}
}
