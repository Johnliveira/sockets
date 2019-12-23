package br.com.caelum.utils;

import java.net.Socket;

/* CapConexao fara a captura do Cliente
 * localizado na porta local : 12345
 * e o encaminhará à uma nova porta.
 */

public class CapConexao implements Runnable {
	
	protected Socket cliente = null;
	
	public CapConexao(Socket cliente) {
		this.cliente = cliente;
	}


	@Override
	public void run() {
		
	}

	
}
