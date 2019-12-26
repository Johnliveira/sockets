package br.com.caelum.utils;

import java.io.InputStream;
import java.util.Scanner;

import br.com.caelum.chat.Servidor;

public class Distribuidor implements Runnable {

	private InputStream cliente;
	private Servidor servidor;
	
	public Distribuidor(InputStream cliente, Servidor servidor) {
		super();
		this.cliente = cliente;
		this.servidor = servidor;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Scanner leitor = new Scanner(this.cliente);
		while (leitor.hasNextLine()) {
			servidor.distribuiMensagem(leitor.nextLine());
		}
		leitor.close();
	}

}
