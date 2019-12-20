package br.com.caelum.utils;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;

/* CapConexao fara a captura do Cliente
 * localizado na porta local : 12345
 * e o encaminhará à uma nova porta.
 */

public class CapConexao {
	
	public void alteraPorta(Socket cliente) throws IOException {
		
		HashSet<ServerSocket> portas = new HashSet<>(10);
		
		ServerSocket porta0 = new ServerSocket(1000);
		ServerSocket porta1 = new ServerSocket(1001);
		ServerSocket porta2 = new ServerSocket(1002);
		ServerSocket porta3 = new ServerSocket(1003);
		ServerSocket porta4 = new ServerSocket(1004);
		ServerSocket porta5 = new ServerSocket(1005);
		ServerSocket porta6 = new ServerSocket(1006);
		ServerSocket porta7 = new ServerSocket(1007);
		ServerSocket porta8 = new ServerSocket(1008);
		ServerSocket porta9 = new ServerSocket(1009);
		
		portas.add(porta0);
		portas.add(porta1);
		portas.add(porta2);
		portas.add(porta3);
		portas.add(porta4);
		portas.add(porta5);
		portas.add(porta6);
		portas.add(porta7);
		portas.add(porta8);
		portas.add(porta9);
		
		System.out.println("Nova conexão!");
		System.out.println("Cliente: " + cliente.getInetAddress().getHostAddress() + " conectado!");
		System.out.println("Porta atual: " + cliente.getLocalPort());
		
	}
}
