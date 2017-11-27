package br.com.fiap.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CLIENTE")
public class Cliente implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IDCLIENTE")
	private int id;
	@Column(name="NOME")
	private String nome;
	@Column(name="EMAIL")
	private String email;
	@OneToMany(mappedBy="cliente", targetEntity=Pedido.class, fetch=FetchType.EAGER)
	private List<Pedido> pedidos;
	
	public Cliente(){
		super();
	}
	
	public Cliente(String nome, String email) {
		super();
		this.nome = nome;
		this.email = email;
	}
	
	public Cliente(int id, String nome, String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
	}

	public Cliente(int id, String nome, String email, List<Pedido> pedidos) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.pedidos = pedidos;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Pedido> getPedidos() {
		return pedidos;
	}
	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", email=" + email + "]"+(pedidos.isEmpty() ? "" : " Pedidos: "+pedidos.toString());
	}
	
}