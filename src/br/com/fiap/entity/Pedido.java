package br.com.fiap.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="PEDIDO")
public class Pedido {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IDPEDIDO")
	private int id;
	@ManyToOne(optional=false)
	@JoinColumn(name="IDCLIENTE",referencedColumnName="IDCLIENTE")
	private Cliente cliente;
	@Column(name="DATA")
	private Date data;
	@Column(name="DESCRICAO")
	private String descricao;
	@Column(name="VALOR")
	private double valor;
	
	public Pedido(){
		super();
	}
	public Pedido(Date data, String descricao, double valor, Cliente cliente) {
		super();
		this.data = data;
		this.descricao = descricao;
		this.valor = valor;
		this.cliente=cliente;
	}
	public Pedido(int id, Date data, String descricao, double valor, Cliente cliente) {
		this(data,descricao,valor,cliente);
		this.id=id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", Cliente=" + cliente.getNome() + ", data=" + data + ", descricao=" + descricao
				+ ", valor=" + valor + "]";
	}

}