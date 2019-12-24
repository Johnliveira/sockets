package br.com.caelum.chat;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import br.com.caelum.utils.Separador;

public class Cliente implements Runnable {

	private Socket cliente;
	
	public Cliente(Socket cliente) {
		super();
		this.cliente = cliente;
	}

	public static void main(String[] args) throws UnknownHostException, IOException {
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		
		try {
			cliente = new Socket("LOCALHOST", 12345);
			
			System.out.println("O cliente conectou ao servidor!");
			
			DataOutputStream saida = new DataOutputStream(cliente.getOutputStream());
			Separador separador = new Separador();
			
			saida.writeBytes(separador.carrega());
			
			saida.close();
			cliente.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
