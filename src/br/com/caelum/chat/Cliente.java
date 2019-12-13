package br.com.caelum.chat;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import br.com.caelum.utils.Separador;

public class Cliente {

	public static void main(String[] args) throws UnknownHostException, IOException {
		
		Socket cliente = new Socket("127.0.0.1", 12345);
		System.out.println("O cliente conectou ao servidor!");
		
		DataOutputStream saida = new DataOutputStream(cliente.getOutputStream());
		Separador separador = new Separador();
		
		saida.writeBytes(separador.carrega());
		
		saida.close();
		cliente.close();
	}
}
