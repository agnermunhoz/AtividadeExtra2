package br.com.fiap.application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Pedido;
import br.com.fiap.helper.ClienteHelper;
import br.com.fiap.helper.PedidoHelper;

public class Aplicacao {

	public static int menu() {
		Scanner in = new Scanner(System.in); 
	    System.out.println("***************************");
	    System.out.println("*          MENU           *");
	    System.out.println("* 1  - Incluir Cliente    *");
	    System.out.println("* 4  - Pesquisar Cliente  *");
	    System.out.println("* 5  - Listar Clientes    *");
	    System.out.println("* 6  - Incluir Pedido     *");
	    System.out.println("* 9  - Pesquisar Pedidos  *");
	    System.out.println("* 10 - Listar Pedidos     *");
	    System.out.println("* 0  - Sair               *");
	    System.out.println("***************************");
	    
	    return in.nextInt();
	}
	
	public static void incluirCliente() {
		Scanner in = new Scanner(System.in); 
	    Cliente cliente = new Cliente();
	    System.out.println("Nome do cliente:");
	    cliente.setNome(in.next());
	    System.out.println("E-mail do cliente:");
	    cliente.setEmail(in.next());
	    try {
			new ClienteHelper().salvarCliente(cliente);
			System.out.println(cliente.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Cliente pesquisarCliente() {
		Scanner in = new Scanner(System.in);
		System.out.println("Id do cliente:");
		int id = in.nextInt();
		try {
			Cliente cliente = new ClienteHelper().getCliente(id);
			System.out.println(cliente.toString());
			return cliente;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void listarCliente() {
		try {
			List<Cliente> clientes = new ClienteHelper().getClientes();
			clientes.forEach(c -> System.out.println(c.toString()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	public static void incluirPedido() {
		Scanner in = new Scanner(System.in); 
	    Cliente cliente = pesquisarCliente();
	    Pedido pedido = new Pedido();
	    pedido.setCliente(cliente);
	    pedido.setData(new Date());
	    System.out.println("Descrição do pedido:");
	    pedido.setDescricao(in.next());
	    System.out.println("Valor do pedido:");
	    pedido.setValor(in.nextDouble());
	    try {
			new PedidoHelper().salvarPedido(pedido);
			System.out.println(pedido.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Pedido pesquisarPedido() {
		Scanner in = new Scanner(System.in);
		System.out.println("Id do pedido:");
		int id = in.nextInt();
		try {
			Pedido pedido = new PedidoHelper().getPedido(id);
			System.out.println(pedido.toString());
			return pedido;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void listarPedidos() {
		try {
			List<Pedido> pedidos = new PedidoHelper().getPedidos();
			pedidos.forEach(p -> System.out.println(p.toString()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		int option = 0;
		do {
			option = menu();
			switch (option) {
			case 1:
				incluirCliente();
				break;
			case 4:
				pesquisarCliente();
				break;
			case 5:
				listarCliente();
				break;
			case 6:
				incluirPedido();
				break;
			case 9:
				pesquisarPedido();
				break;
			case 10:
				listarPedidos();
				break;
			default:
				System.out.println("Finalizando aplicativo!!!");
				break;
			}
		} while (option != 0);
	}

}
