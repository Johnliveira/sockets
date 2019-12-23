package br.com.caelum.utils;

import java.io.IOException;
import java.net.Socket;

/* CapConexao fara a captura do Cliente
 * localizado na porta local : 12345
 * e o encaminhar� � uma nova porta.
 */

public class CapConexao {
	
	public void alteraPorta(Socket cliente) throws IOException {
		
		System.out.println("Nova conex�o!");
		System.out.println("Cliente: " + cliente.getInetAddress().getHostAddress() + " conectado!");
		System.out.println("Porta atual: " + cliente.getLocalPort());
		
	}
}
