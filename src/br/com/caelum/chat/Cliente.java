package br.com.caelum.chat;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import br.com.caelum.utils.Recebedor;

public class Cliente {
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		new Cliente("192.168.3.232", 12345).executa();
		
	}

	private String host;
	private int porta;
	
	public Cliente(String host, int porta) {
		super();
		this.host = host;
		this.porta = porta;
	}
	
	public void executa() throws UnknownHostException, IOException {
		Socket cliente = new Socket(this.host, this.porta);
		System.out.println("Conectado!");
		
		Recebedor mensagens = new Recebedor(cliente.getInputStream());
		new Thread(mensagens).start();
		
		Scanner teclado = new Scanner(System.in);
		PrintStream saida = new PrintStream(cliente.getOutputStream());
		while (teclado.hasNextLine()) {
			saida.println(teclado.nextLine());
		}
		
		saida.close();
		teclado.close();
		cliente.close();
	}

}
