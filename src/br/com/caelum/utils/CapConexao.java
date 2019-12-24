package br.com.caelum.utils;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/* CapConexao fara a captura do Cliente
 * localizado na porta local : 12345
 * e o encaminhará à uma nova porta.
 */

public class CapConexao implements Runnable {
	
	private static Socket cliente = null;
	
	public CapConexao(Socket cliente) {
		CapConexao.cliente = cliente;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			Separador separador = new Separador();
			Scanner entrada = separador.salva(cliente);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
